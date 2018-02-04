package com.ypg.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_games")
public class UserGames {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long owner;
    private Long gameid;
    private Long customizationsid;
    private Date created_date;
    private Date last_updated;

    public UserGames(Long owner, Long gameid, Long customizationsid, Date created_date, Date last_updated) {
        this.owner = owner;
        this.gameid = gameid;
        this.customizationsid = customizationsid;
        this.created_date = created_date;
        this.last_updated = last_updated;
    }
}
