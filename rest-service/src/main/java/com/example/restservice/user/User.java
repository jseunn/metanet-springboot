package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})
//@JsonFilter("UserInfo")
//@Entity
public class User {
//    @Id
//    @GeneratedValue
    private Integer Id;

    @Size(min=2, message="Name은 두글자 이상 입력")
    private String name;
    private Date joinDate;

    //@JsonIgnore // 데이터값이 존재해도 노출시키지 않는다.
    private String password;
    private String ssn;

//    @OneToMany(mappedBy = "user") //Post에서의 User 변수명
    private List<Post> posts; // 1:N 관계에서 데이터 가져오기

    // 에러 -> List<Post> posts 변수가 추가되어 @AllArgsConstructor 사용했을 때
    // 해당 생성자 없음 오류.. 생성자 따로 지정해주었음
    
    public User(Integer id, String name, Date joinDate, String password, String ssn) {
        Id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }
}
