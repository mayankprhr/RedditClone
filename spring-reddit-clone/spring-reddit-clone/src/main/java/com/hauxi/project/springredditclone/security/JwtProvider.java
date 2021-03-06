package com.hauxi.project.springredditclone.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.hauxi.project.springredditclone.exception.RedditException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import static io.jsonwebtoken.Jwts.parser;
import static java.util.Date.from;

@Service
public class JwtProvider {
    private KeyStore keyStore;
    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;

    @PostConstruct
    public void init(){
        try{
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream= getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "password".toCharArray());
        } 

        catch(KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e){
            throw new RedditException("Exception occured on loading keystore", e);
        }
    }

    public String generateToken(Authentication authentication){
        org.springframework.security.core.userdetails.User principal = (User)authentication.getPrincipal();

        return Jwts.builder().setSubject(principal.getUsername()).signWith(getPrivateKey()).setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis))).compact();
    }

    public String generateTokenWithUserName(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }


    private PrivateKey getPrivateKey(){
        try {
            return (PrivateKey) keyStore.getKey("springblog", "password".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
 
            throw new RedditException("Error occured on generating a key from keystore",e);
        }
    }


    private PublicKey getPublicKey(){
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            // handle exception
            throw new RedditException("Exception occured on retrieving public key from keystore.", e);
        }
    }


    /*
    Summary. JWT is used to transport user identity/entitlements between interested parties in a secured manner.
    JWS and JWE are instances of the JWT ??? when used compact serialization. 
    JWS and JWE can be serialized using either the compact serialization or JSON serialization. 
     */
   
     /* LINK TO JWT JWS and JWE
     https://medium.facilelogin.com/jwt-jws-and-jwe-for-not-so-dummies-b63310d201a3
     */

    public boolean validateToken(String jwt){
        parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt);
        return true;    
    }

    public String getUSerNameFormJWT(String token){
        Claims claims=parser().setSigningKey(getPublicKey()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }
    
}