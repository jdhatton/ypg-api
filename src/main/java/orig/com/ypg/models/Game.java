package orig.com.ypg.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "games")
public class Game {

	  public String name;
	  public String description;
	  public String status;
	  public Long gameTypeId;
	  @Temporal (TemporalType.TIMESTAMP)
	  public Date creationDate;
	  
	  @Transient
	  public User user;
	  
	  @Transient
	  public Long gameId;
	  
	  @Transient
	  public List<String> players;


	
		public String toString(){
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
		}
}
