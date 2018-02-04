package com.ypg.data.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user")
public class User {



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    private String status;
    private String username;
    private String gender;
    private String dob;
    private String other;
    private String wager;
    private String user_token;
    private String active;
    private Date created_date;
    private Date last_updateds;

    public User(String firstName, String lastName, String status, String username, String gender, String dob, String other, String wager, String user_token, String active, Date created_date, Date last_updateds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.username = username;
        this.gender = gender;
        this.dob = dob;
        this.other = other;
        this.wager = wager;
        this.user_token = user_token;
        this.active = active;
        this.created_date = created_date;
        this.last_updateds = last_updateds;
    }
}
