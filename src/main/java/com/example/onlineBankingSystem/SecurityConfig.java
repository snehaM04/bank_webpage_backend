package com.example.onlineBankingSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers("/api/login", "/api/customer/create" , "/api/account/create" , "/api/transaction/deposit" ,"/api/transaction/transactionHistory").permitAll()
                .anyRequest().authenticated();

        return http.build();
    }
}
