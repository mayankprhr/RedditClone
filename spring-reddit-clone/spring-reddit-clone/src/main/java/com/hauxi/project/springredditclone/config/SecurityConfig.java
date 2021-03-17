package com.hauxi.project.springredditclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;

/**
 * SecurityConfig
 */

 @EnableWebSecurity                     //main annotation which enables web security in this class 
 @AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{           //default web security funcitons

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()       //
        .authorizeRequests()                //to authorize requests 
        .antMatchers("/api/auth/**")        //which starts with following pattern
        .permitAll()
        .anyRequest()
        .authenticated();                   //any other requests should be authenticated
    }
    
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();   
    }

}