package com.oola.headhunter.navhr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
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
    @Autowired
    ClaseManejadorOk claseManejadorOk;

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

        http .csrf(Customizer.withDefaults())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/img/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/h2-console/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                // 👇 habilita el formulario de login
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successHandler(claseManejadorOk)
                        .failureUrl("/loginError")
                        .successForwardUrl("/buscador/paises").permitAll())
                // 👇 permite hacer logout
                //.logout(Customizer.withDefaults());
                .logout((logout) -> logout
                        .permitAll());


        return http.build();
    }

}
