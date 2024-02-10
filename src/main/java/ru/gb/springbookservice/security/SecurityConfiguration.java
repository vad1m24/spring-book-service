package ru.gb.springbookservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> registry
//                        .requestMatchers("/ui/**").authenticated()
//                        .requestMatchers("/issue/**").hasAuthority("admin")
//                        .requestMatchers("/reader/**").hasAuthority("reader")
//                        .requestMatchers("/book/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }

}
