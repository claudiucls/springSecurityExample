package com.telacad.exempluSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz ->
                        authz
                                // Combine permitAll for cleaner configuration
                                .requestMatchers("/webjars/**", "/h2-console/**").permitAll()
                                // Secure only endpoints under /api/**
                                .requestMatchers("/api/**").authenticated()
                                // Make all other requests publicly accessible
                                .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults());

        // --- H2 Console Fix ---
        // The H2 console runs in a frame, so we need to disable CSRF and frame options for that path.
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"));
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

        return http.build();
    }

}
