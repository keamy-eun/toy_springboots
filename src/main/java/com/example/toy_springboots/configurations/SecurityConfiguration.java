package com.example.toy_springboots.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests()
            // .antMatchers("/").authenticated()   // 로그인 여부만 판단.
            // .antMatchers("/admin").access("hasRole('ROLE_ADMIN')") // 로그인 & 권한
            .antMatchers("/user/*").authenticated()
            .antMatchers("/manager/*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
            .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
            .anyRequest().permitAll();      // 설정한 URL 이외는 접근 가능(로그인 & 로그아웃).
        

        httpSecurity.formLogin().loginPage("/loginForm") 
            .failureUrl("/loginForm?fail=true")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/");

        return httpSecurity.build();
    }
    
    @Bean
    public BCryptPasswordEncoder encoderPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
