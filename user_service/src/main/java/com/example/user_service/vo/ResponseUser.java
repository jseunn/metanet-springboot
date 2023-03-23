package com.example.user_service.vo;

import lombok.Data;

// 클라이언트가 볼 내용만 작성한 객체
@Data
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

}
