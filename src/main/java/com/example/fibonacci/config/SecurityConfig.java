package com.example.fibonacci.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/api/**").permitAll()  // Permitir acceso a Swagger UI y OpenAPI
                                .anyRequest().permitAll()  // Requiere autenticación para otros endpoints
                )
                .csrf(csrf -> csrf.disable());  // Desactivar CSRF si estás usando Swagger UI

        return http.build();
    }
}
