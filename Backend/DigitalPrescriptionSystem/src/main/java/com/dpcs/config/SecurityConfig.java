package com.dpcs.config;

import com.dpcs.security.JwtAuthenticationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();

    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(

                                "/api/auth/**",

                                "/api/users/register",

                                "/v3/api-docs/**",

                                "/swagger-ui/**",

                                "/swagger-ui.html"

                        ).permitAll()

                        // ADMIN
                        .requestMatchers("/api/users/**").hasRole("ADMIN")
                        
                        .requestMatchers("/api/medicines/**")
                        .hasAnyRole("ADMIN","DOCTOR","PHARMACIST")

                        // DOCTOR
                        .requestMatchers("/api/doctors/**")
                        //.authenticated()
                        .hasAnyRole("ADMIN","DOCTOR")
                        
                        .requestMatchers("/api/prescriptions/**")
                        //.authenticated()
                        .hasAnyRole("ADMIN","DOCTOR","PHARMACIST")

                        // PATIENT
                        .requestMatchers("/api/patients/**").hasAnyRole("ADMIN","DOCTOR","PATIENT")

                        // PHARMACIST
                        .requestMatchers("/api/pharmacies/**").hasRole("PHARMACIST")
                        
                        .requestMatchers("/api/dispenses/**")
                        .hasAnyRole("ADMIN","PHARMACIST")
                        
                         // APPOINTMENTS
                        .requestMatchers("/api/appointments/**")
                        .hasAnyRole("ADMIN", "DOCTOR", "PATIENT")
                        .requestMatchers("/api/dashboard/admin")
                        .hasRole("ADMIN")
                        .requestMatchers("/api/reports/**")
                        .hasRole("ADMIN")

                        .anyRequest().authenticated()

                )

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();

    }

}