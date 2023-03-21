package com.example.restservice.user;

//2xx => OK
//4xx => client error
//5xx => server error
public class UserNotFoundException extends RuntimeException{
    // 예외클래스 생성

    public UserNotFoundException(String message){
        super(message);
    }
}
