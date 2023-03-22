package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity // 자동으로 Post 테이블 생성됨
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

//    @Id
//    @GeneratedValue
    private Integer Id;

    private String description;

//    @ManyToOne(fetch = FetchType.LAZY) // Post 입장에서는 N:1, User 입장에서는 1:N
//    @JsonIgnore
//    private User user; // 필요한 시점에 user를 가져올 것이다. JPA에서 사용한 것임
    private int user_id;

}
