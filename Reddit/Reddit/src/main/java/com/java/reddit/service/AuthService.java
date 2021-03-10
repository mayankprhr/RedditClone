package com.java.reddit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import com.java.reddit.dto.RegisterRequest;
import com.java.reddit.model.User;
import com.java.reddit.model.VerificationToken;
import com.java.reddit.repository.UserRepository;
import com.java.reddit.repository.VerificationTokenRepository;

@Service
@AllArgsConstructor
public class AuthService {

    //field injection
    // @Autowired
    // private PasswordEncoder passwordEncoder;
    // @Autowired
    // private UserRepository userRepository;
    //   alternative is to use constructor injection

    //constructor injection
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;    

    @Transactional
    public void signup(RegisterRequest registerRequest)
    {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false); 
        userRepository.save(user);


        generateVerificationToken (user);
    }

    public String generateVerificationToken(User user)
    {
            String token=UUID.randomUUID().toString();
            VerificationToken verificationToken=new VerificationToken();
            verificationToken.setToken(token);
            verificationToken.setUser(user);

            verificationTokenRepository.save(verificationToken);
            return token;
        }
        
}
