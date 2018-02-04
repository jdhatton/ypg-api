package com.ypg.data.models;

import javax.persistence.*;

@Entity
@Table(name = "user_game_users")
public class UserGameUsers {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long userid;
    private Long gameid;

    public UserGameUsers(Long userid, Long gameid) {
        this.userid = userid;
        this.gameid = gameid;
    }
}
