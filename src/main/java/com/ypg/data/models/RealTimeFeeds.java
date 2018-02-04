package com.ypg.data.models;

import javax.persistence.*;

@Entity
@Table(name = "realtime_feeds")
public class RealTimeFeeds {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String game_type;
    private String name;
    private String connection;
    private String format;
    private String status;

    public RealTimeFeeds(String game_type, String name, String connection, String format, String status) {
        this.game_type = game_type;
        this.name = name;
        this.connection = connection;
        this.format = format;
        this.status = status;
    }
}
