package org.internetstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.
            authorizeHttpRequests(
             request -> request
                     .requestMatchers("/", "/register", "/signin", "/saveUser").permitAll()
                     .requestMatchers("/user/**").authenticated()
            )
            .csrf(csrf ->csrf.disable())
            .formLogin(form -> form
                    .loginPage("/signin")
                    .loginProcessingUrl("/userLogin")
                    .defaultSuccessUrl("/user/profile")
                    .permitAll()
            )
    ;
    return http.build();
    }

    @Bean
    WebSecurityCustomizer configureWebSecurity() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/css/**");
    }
}
