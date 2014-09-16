package kavad.dataobjects;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class representing a start time of a Tv-program
 * 
 * @author Kaur
 * @see Program
 */
@Entity
@Table(name = "starttimes")
public class StartTime implements Serializable, Comparable<StartTime>{
	
	private long id;
	private Date time;
	private boolean enabled;
	private Program program;
	
	public StartTime(){
		
	}
	
	public StartTime(long id, Date time, boolean enabled, Program program) {
		super();
		this.id = id;
		this.time = time;
		this.enabled = enabled;
		this.program = program;
	}
	@Id @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "time")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@ManyToOne
	@JoinColumn(name = "program_id")
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}

	public int compareTo(StartTime o) {
		return o.getTime().compareTo(this.time);
	}

}
