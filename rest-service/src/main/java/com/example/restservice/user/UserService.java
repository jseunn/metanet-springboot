package com.example.restservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static{
        users.add(new User(1, "kosa", new Date()));
        users.add(new User(2, "metanet", new Date()));
        users.add(new User(3, "naver", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
