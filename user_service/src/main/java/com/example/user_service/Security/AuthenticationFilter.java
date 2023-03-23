package com.example.user_service.Security;

import com.example.user_service.vo.RequestLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager){
        super.setAuthenticationManager(authenticationManager);
    }

    //인증되기 전에 사전에 해야 할 작업들을 호출하는 역할
    // 로그인 요청 되면 여기로 넘어옴
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            RequestLogin creds = new ObjectMapper().readValue(request.getInputStream(),
                    RequestLogin.class); // RequestLogin 값으로 변환

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken( // 토큰으로 만들어서 authenticate 객체로 만들어짐
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>()
                    )
            );

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

    }
}