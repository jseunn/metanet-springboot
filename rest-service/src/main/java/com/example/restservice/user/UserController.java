package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

//    @Autowired // 1. 이렇게 autowired로 가져올 수도 있음
    private UserService service;

    public UserController(UserService service){
        this.service = service;
    } // 2. 이렇게 생성자를 만들어도 자동 주입이 된다.

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll(); // list로 return
    }

    @GetMapping("/users/{id}")
    public User retireveUser(@PathVariable int id){ // url의 데이터값을 뽑아와야 함 -> @PathVariable
        return service.findOne(id);
    }
}
