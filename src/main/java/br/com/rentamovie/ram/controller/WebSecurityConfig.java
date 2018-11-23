/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rentamovie.ram.controller;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author hernanematida
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public static final String USUARIO_POR_LOGIN = "SELECT email, password, is_active, name FROM person WHERE email = ?";

    /**
     * Configura o Spring Security quanto a segurança ao acesso ao sistema.
     * Libera o acessos a pacotes comuns como css, scripts e imagens que não 
     * requerem autenticação.
     */
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/webjars/**", "/css/**", "/less/**", "/img/**", "/js/**", "/images/**");
    }
    
    /**
     * Configura o Spring Security quanto a segurança ao acesso ao sistema.
     * Protege as views que requerem login para acesso e libera as views
     * de login e cadastro de novo usuário.
     */
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/novo").permitAll()
                .antMatchers("/save_person").permitAll()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
    
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    
    /**
     * Configura o Spring Security quanto a segurança ao acesso ao sistema.
     * Constrói as querys para localizac'ão do usuário no login.
     */
    protected void configure(AuthenticationManagerBuilder builder
    ) throws Exception {
        builder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USUARIO_POR_LOGIN)
                .authoritiesByUsernameQuery(USUARIO_POR_LOGIN);
    }

}
