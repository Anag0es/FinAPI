package com.finapi.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita CSRF para facilitar os testes (ajuste em produção)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize
                                // Permite o POST para /users sem autenticação (criação de usuário)
                                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                                // Permite o acesso ao console do H2
                                .requestMatchers("/h2-console/**").permitAll()
                                // Exige autenticação para GET /users e demais requisições
                                .requestMatchers(HttpMethod.GET, "/users/**").authenticated()
                                // Para qualquer outra requisição, exige autenticação
                                .anyRequest().authenticated()
                )
                // Habilita a autenticação básica
                .httpBasic(Customizer.withDefaults());

        // Permite o funcionamento do H2 Console
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }
}
