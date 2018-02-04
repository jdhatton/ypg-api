package orig.com.ypg.models;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.DateFormat;
import java.util.Date;



@Entity
@Table (name = "playablegames")

public class PlayableGame  {


	@Temporal (TemporalType.TIMESTAMP)

	public Date startTimeForPicks;
	@Temporal (TemporalType.TIMESTAMP)
	public Date endTimeForPicks;
	
	public String homeTeam;
	public String visitorTeam;
	public String description;
	public long gameInfoId;
	public String status;
	
	@Temporal (TemporalType.TIMESTAMP)
	public Date gameTime;
	@Temporal (TemporalType.TIMESTAMP)
	public Date creationDate;
	
	
	public String getDisplayGameTime() {
		return DateFormat.getInstance().format(gameTime);
		
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
