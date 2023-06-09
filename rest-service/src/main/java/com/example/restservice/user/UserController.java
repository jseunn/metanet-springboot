package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> retrieveUser(@PathVariable int id){ // url의 데이터값을 뽑아와야 함 -> @PathVariable
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("all-users")); // 전체 목록을 볼 수 있는 url의 정보를, 메서드로 전달
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){ //JSON 데이터를 @RequestBody를 이용하여 Java - User 객체로 전환하여 받아옴
        service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(user.getId())
                                .toUri(); // 추가한 user의 URI를 만든다.

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        service.deleteById(id);
    }
}
