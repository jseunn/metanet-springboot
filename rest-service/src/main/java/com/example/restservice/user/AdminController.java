package com.example.restservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
//    private UserService service;
//
//    public AdminController(UserService service){
//        this.service = service;
//    } // 2. 이렇게 생성자를 만들어도 자동 주입이 된다.
//
//    @GetMapping("/users")
//    public MappingJacksonValue retrieveAllUsers(){
//        List<User> users = service.findAll();
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .filterOutAllExcept("id", "name", "joinDate", "ssn", "password");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
//
//        MappingJacksonValue mapping = new MappingJacksonValue(users);
//        mapping.setFilters(filters);
//        return mapping;
//    }
//
//    @GetMapping("/users/{id}")
//    public MappingJacksonValue retrieveUser(@PathVariable int id){ // url의 데이터값을 뽑아와야 함 -> @PathVariable
//        User user = service.findOne(id);
//
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//                .filterOutAllExcept("id", "name", "joinDate", "ssn");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
//
//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        mapping.setFilters(filters);
//        return mapping;
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity createUser(@Valid @RequestBody User user){ //JSON 데이터를 @RequestBody를 이용하여 Java - User 객체로 전환하여 받아옴
//        User savedUser = service.save(user);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri(); // 추가한 user의 URI를 만든다.
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id){
//        User user = service.deleteById(id);
//
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//    }
}
