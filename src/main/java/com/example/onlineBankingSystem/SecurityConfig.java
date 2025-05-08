package com.example.onlineBankingSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/login",
                                "/api/customer/create",
                                "/api/account/create",
                                "/api/transaction/deposit",
                                "/api/transaction/withdraw",
                                "/api/transaction/transfer"
                        ).permitAll()
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/customer/getDetails/**",
                                "/api/account/getAccountDetails/**",
                                "/api/account/existsAccountId/**",
                                "/api/account/existsCustomerId/**",
                                "/api/transaction/transactionHistory"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
