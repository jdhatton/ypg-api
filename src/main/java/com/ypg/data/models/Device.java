package com.ypg.data.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String platform;
    private String device;
    private String deviceToken;
    private Long userid;
    private boolean enabled;
    private boolean valid;
    private Date last_updated;

    public Device(String platform, String device, String deviceToken, Long userid, boolean enabled, boolean valid, Date last_updated) {
        this.platform = platform;
        this.device = device;
        this.deviceToken = deviceToken;
        this.userid = userid;
        this.enabled = enabled;
        this.valid = valid;
        this.last_updated = last_updated;
    }
}
