package com.ypg.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "game_details")
public class GameDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long game_id;
    private String game_rules;
    private String game_criteria;
    private String game_status;
    private Date game_begins;
    private Date game_ends;

    public GameDetails(Long game_id, String game_rules, String game_criteria, String game_status, Date game_begins, Date game_ends) {
        this.game_id = game_id;
        this.game_rules = game_rules;
        this.game_criteria = game_criteria;
        this.game_status = game_status;
        this.game_begins = game_begins;
        this.game_ends = game_ends;
    }
}
