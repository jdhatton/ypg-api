package com.ypg.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "game_types")
public class GameTypes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String type;
    private String name;
    private String descr;
    private String status;
    private Date created_date;
    private Date last_updated;

    public GameTypes(String type, String name, String descr, String status, Date created_date, Date last_updated) {
        this.type = type;
        this.name = name;
        this.descr = descr;
        this.status = status;
        this.created_date = created_date;
        this.last_updated = last_updated;
    }
}
