package com.example.user_service.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // 설정 파일로서의 역할
@EnableWebSecurity // 시큐리티 필터 체인에 이 로직이 추가됨
public class WebSecurity extends WebSecurityConfigurerAdapter {

    // 권한과 관련된 작업 -> h2 DB 접속 원할하게 하기 위함
    // 401 에러 고침
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users").permitAll(); // 해당 요청은 허락해주세요
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();

        http.headers().frameOptions().disable();
    }
}
