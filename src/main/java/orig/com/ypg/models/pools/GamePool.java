package orig.com.ypg.models.pools;

import orig.com.ypg.models.Game;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table (name = "gamepools")
public class GamePool  {

	  public String status;
	  public Long poolId;
	  public Long gameId;

	  @Transient
	  public Game game;
	  
	  @Transient
	  public Pool pool;
}
