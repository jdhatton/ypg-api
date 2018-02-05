package com.ypg.data.models.games;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "playable_game_nfl")
public class PlayableGameNFL {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date game_time;
    private String home_team;
    private String visitor_team;
    private String descr;
    private String status;
    private Date created_date;

}
