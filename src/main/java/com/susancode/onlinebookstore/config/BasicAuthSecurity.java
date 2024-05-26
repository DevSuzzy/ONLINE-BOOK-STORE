package com.susancode.onlinebookstore.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.susancode.onlinebookstore.config.PasswordEncoderConfig.passwordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicAuthSecurity {
    private final RestAuthenticationEntryPoint authenticationEntryPoint;



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint))
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/public/secureAPI").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/vi/books").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/api/vi/books").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/vi/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/vi/books/**").hasRole("ADMIN")
                        .requestMatchers("/secureAPI").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated());
                      return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("codeDiva1")
                .password(passwordEncoder().encode("UniqueCoda1"))
                .roles("ADMIN");
    }
}

