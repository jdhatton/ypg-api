package orig.com.ypg.models.pools;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table (name = "pools")
public class Pool {

	  public String name;
	  public String description;
	  public String status;
	  public Long creatorId;
	  @Temporal (TemporalType.TIMESTAMP)
	  public Date creationDate;

}
