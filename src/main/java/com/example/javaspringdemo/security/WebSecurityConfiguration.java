package com.example.javaspringdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.authorizeRequests()
                .antMatchers(
                        "/my-portfolio","/my-portfolio/education",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/fonts/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll();

        return http.build();
    }

//    @Override
//    protected WebSecurityCustomizer configure(AuthenticationManagerBuilder auth) throws Exception {
//        return auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("user1pass")).authorities(
//                "ROLE_USER");
//    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
//        return (web) -> web.ignoring().antMatchers(
//                "/js/**",
//                "/css/**",
//                "/img/**");
//    }
}
