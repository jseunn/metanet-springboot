package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})
//@JsonFilter("UserInfo")
public class User {
    private Integer Id;

    @Size(min=2, message="Name은 두글자 이상 입력")
    private String name;
    private Date joinDate;

    //@JsonIgnore // 데이터값이 존재해도 노출시키지 않는다.
    private String password;
    private String ssn;
}
