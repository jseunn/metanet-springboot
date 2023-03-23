package com.example.user_service.vo;

import lombok.Data;

// 회원가입 했을 때 전달되는 데이터를 가진 객체
@Data
public class RequestUser {
    private String email;
    private String name;
    private String pwd;

}
