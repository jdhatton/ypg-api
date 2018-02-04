package com.ypg.data.models;

import javax.persistence.*;

@Entity
@Table(name = "user_cookie")
public class UserCookie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long userid;
    private String email;
    private String password;

    public UserCookie(Long userid, String email, String password) {
        this.userid = userid;
        this.email = email;
        this.password = password;
    }
}
