package com.example.user_service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 로그인한 정보를 갖는 객체
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestLogin {
    private String email;
    private String password;
}
