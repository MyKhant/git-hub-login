package com.example.githublogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Throwable{
        http.oauth2Login();
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated();
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }
    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider
                .GITHUB
                .getBuilder("github")
                .clientId("29e2a637390d9156db77")
                .clientSecret("2206bbd0135b6253a46a54a91f1533f2a8bbe48e")
                .build();
    }
}
