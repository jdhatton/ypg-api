package com.ypg.data.models;

import javax.persistence.*;

@Entity
@Table(name = "game_status")
public class GameStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String descr;

    public GameStatus(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }
}
