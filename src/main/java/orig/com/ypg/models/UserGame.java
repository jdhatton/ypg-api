package orig.com.ypg.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "usergames")
public class UserGame {

	  public String name;
	  public String status;
	  public Long gameId;
	  public Long gameTypeId;
	  public Long userId;
	  public Long selectedRulesId;
	  @Temporal (TemporalType.TIMESTAMP)
	  public Date creationDate;
	  
	  @Transient
	  public User user;
	  
	  @Transient
	  public Game game;
	  
	  @Transient
	  public String gameDescription;
	  

}
