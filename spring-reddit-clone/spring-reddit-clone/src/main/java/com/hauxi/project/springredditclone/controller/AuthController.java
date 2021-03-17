package com.hauxi.project.springredditclone.controller;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.hauxi.project.springredditclone.dto.RegisterRequest;
import com.hauxi.project.springredditclone.service.AuthService;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(OK);
    }
    
@GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successully", OK);
    }

}