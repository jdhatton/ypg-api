package orig.com.ypg.models.rules;

import orig.com.ypg.models.User;
import orig.com.ypg.models.UserGame;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table (name = "selectedgamerules")
public class SelectedGameRule {

	  public Long userGameId;
	  public Long userId;
	  public Long ruleId;
	  public String status;
	  
	  @Transient
	  public User user;
	  
	  @Transient
	  public UserGame game;

}
