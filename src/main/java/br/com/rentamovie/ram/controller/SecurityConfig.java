/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author hernanematida
 */
@Configuration
public class SecurityConfig {
    
    
    /**
     * Bean que encripta a senha para salvamento e veiricação do Spring Security.
     * @return BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
