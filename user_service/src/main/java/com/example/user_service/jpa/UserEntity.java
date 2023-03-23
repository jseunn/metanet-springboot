package com.example.user_service.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users2")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String encrypedPwd;
}








