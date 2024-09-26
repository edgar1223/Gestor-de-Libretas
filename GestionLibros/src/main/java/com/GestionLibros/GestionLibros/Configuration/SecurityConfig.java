package com.GestionLibros.GestionLibros.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración funcional de Spring Security 6.1+
        http
                .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("**").permitAll()  // Permitir acceso sin autenticación a /api/usuarios
                        .anyRequest().authenticated()  // Requerir autenticación para las demás rutas
                )
                .httpBasic(withDefaults());  // Nueva forma de habilitar HTTP Basic Authentication sin lambda

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Autenticación en memoria, para fines de desarrollo
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
