package com.example.javaspringdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration  {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/js/**", "/css/**", "/img/**" ,"/pressiplus", "/public/**",
                "/index", "/", "/login").permitAll();
        http.authorizeRequests()
                .antMatchers("/my-portfolio").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll();

        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "webjars/**", "/assets/**");
//    }
}
