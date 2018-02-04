package com.ypg.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_game")
public class UserGame {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long gameid;
    private Long owner;
    private Long customizationsid;
    private Date date_created;
    private Date last_updated;

    public UserGame(Long gameid, Long owner, Long customizationsid, Date date_created, Date last_updated) {
        this.gameid = gameid;
        this.owner = owner;
        this.customizationsid = customizationsid;
        this.date_created = date_created;
        this.last_updated = last_updated;
    }
}
