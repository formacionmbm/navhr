package com.oola.headhunter.navhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("user1")).roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2").password(passwordEncoder().encode("user2")).roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/img/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/h2-console/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated());
        return http.build();
    }

}
