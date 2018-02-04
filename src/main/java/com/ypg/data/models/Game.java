package com.ypg.data.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String descr;
    private String status;
    private Long game_type_id;
    private boolean world_game;
    private String platforms;
    private String duration;
    private String wager;
    private Long game_details_id;
    private Date created_date;


    public Game(String name, String descr, String status, Long game_type_id, boolean world_game, String platforms, String duration, String wager, Long game_details_id, Date created_date) {
        this.name = name;
        this.descr = descr;
        this.status = status;
        this.game_type_id = game_type_id;
        this.world_game = world_game;
        this.platforms = platforms;
        this.duration = duration;
        this.wager = wager;
        this.game_details_id = game_details_id;
        this.created_date = created_date;
    }
}
