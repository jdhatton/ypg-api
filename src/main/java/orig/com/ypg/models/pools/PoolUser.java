package orig.com.ypg.models.pools;

import orig.com.ypg.models.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table (name = "poolusers")
public class PoolUser {

	  public String status;
	  public Long poolId;
	  public Long userId;
	  public String userName;
 
	  @Transient
	  public User user;
	  
	  @Transient
	  public Pool pool;
	  
	  public static synchronized List<User> getPlayers(Long poolId){
		  
		  List<User> players = null;
		  
		  //
		  // Query for the players in a pool.
		  //
		  
		  //
		  // Testing - debug - Remove.
		  //
//		  players = User.findAll();
		  
		  return players;
	  }
}
