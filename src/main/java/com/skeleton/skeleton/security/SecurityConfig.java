package com.skeleton.skeleton.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(registry -> {
      registry.requestMatchers("/users/index").hasRole("ADMIN");
      registry.requestMatchers(HttpMethod.POST, "/users").permitAll();
      registry.anyRequest().permitAll();
    })
        .formLogin(formLogin -> formLogin.permitAll());
    return httpSecurity.csrf().disable().build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails regularUser = User.builder()
        .username("user")
        .password("$2a$12$7HY/fK7Yp0UdOJILiaIQHeQdU2tz8gjNn06F6sSQuJdF7jwOVmDXi")
        .roles("USER")
        .build();

    UserDetails admin = User.builder()
        .username("admin")
        .password("$2a$12$ncdAUeECELjOSChEbzCa4uaeLYb4HBNDygbOca2MduMc72GcLOsGe")
        .roles("USER", "ADMIN")
        .build();
    return new InMemoryUserDetailsManager(regularUser, admin);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
