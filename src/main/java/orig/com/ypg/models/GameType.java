package orig.com.ypg.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table (name = "gametypes")
public class GameType {

	  public String name;
	  public String description;
	  public String status;
	  public Long catId;
	  @Temporal (TemporalType.TIMESTAMP)
	  public Date creationDate;


}
