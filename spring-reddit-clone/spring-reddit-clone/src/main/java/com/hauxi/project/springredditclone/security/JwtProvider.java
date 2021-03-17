package com.hauxi.project.springredditclone.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;

import com.hauxi.project.springredditclone.exception.RedditException;

//import io.jsonwebtoken.Jwts;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {
    private KeyStore keyStore;

    @PostConstruct
    public void init(){
        try{
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream= getClass().getResourceAsStream("/springblog.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } 

        catch(KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e){
            throw new RedditException("Exception occured on loading keystore");
        }
    }

    public String generateToken(Authentication authentication){
        org.springframework.security.core.userdetails.User principal = (User)authentication.getPrincipal();

        principal.getClass();
        return "null";
    }
}