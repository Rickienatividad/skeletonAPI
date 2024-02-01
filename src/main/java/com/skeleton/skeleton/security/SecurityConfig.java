package com.skeleton.skeleton.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.cors().disable()
        .csrf().disable()
        .authorizeHttpRequests().requestMatchers("/users").permitAll().and()
        .build();
  }
}
