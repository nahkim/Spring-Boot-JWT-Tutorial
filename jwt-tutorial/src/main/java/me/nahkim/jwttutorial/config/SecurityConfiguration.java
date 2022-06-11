package me.nahkim.jwttutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()    // HttpServletRequest를 사용하는 요청들에 대한 접근제한 설정함
                .antMatchers("/api/hello").permitAll()  // 여기에 들어가있는 요청들은 인증없이 접근을 허용함
                .anyRequest().authenticated();  // 나머지 요청들은 모두 인증되어야함
        return http.build();
    }
}