package orig.com.ypg.models.rules;

import orig.com.ypg.models.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "gamerules")
public class GameRule {

	  public String name;
	  public String description;
	  public String status;
	  public Long gameid;
	  @Temporal (TemporalType.TIMESTAMP)
	  public Date creationDate;
	  
	  @Transient
	  public User user;
 
	  
}
