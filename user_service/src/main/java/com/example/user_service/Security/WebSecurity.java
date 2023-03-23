package com.example.user_service.Security;

import com.example.user_service.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.Filter;

@Configuration // 설정 파일로서의 역할
@EnableWebSecurity // 시큐리티 필터 체인에 이 로직이 추가됨
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Environment env;

    public WebSecurity(Environment env, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.env = env;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 권한과 관련된 작업 -> h2 DB 접속 원할하게 하기 위함
    // 401 에러 고정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users").permitAll(); // 해당 요청은 허락해주세요
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll();

        http.authorizeRequests().antMatchers("/**")
                .hasIpAddress("localhost")
                .and()
                .addFilter(getAuthenticationFilter());

        http.headers().frameOptions().disable();

    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter
                = new AuthenticationFilter(authenticationManager());

        return authenticationFilter;
    }


    // 인증을 처리하는 메서드
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
        // 인증처리 누가 해줄래? loadUserByUsername 호출
    }
}








