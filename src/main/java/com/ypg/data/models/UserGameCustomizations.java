package com.ypg.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_game_customizations")
public class UserGameCustomizations {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String rules;
    private String details;
    private String customs;
    private String other;
    private Date date_created;
    private Date last_updated;

    public UserGameCustomizations(String rules, String details, String customs, String other, Date date_created, Date last_updated) {
        this.rules = rules;
        this.details = details;
        this.customs = customs;
        this.other = other;
        this.date_created = date_created;
        this.last_updated = last_updated;
    }
}
