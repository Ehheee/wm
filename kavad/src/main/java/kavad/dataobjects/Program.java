package kavad.dataobjects;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 * Class representing a tv-program 
 * 
 * @author Kaur
 *
 */
@Entity
@Table(name = "programs")
public class Program implements Serializable{

	private long id;
	private String name;
	private Set<Tag> tags;
	private Channel channel;
	private SortedSet<StartTime> startTimes;
	private int length;
	private boolean enabled;
	
	public Program(){
		
	}
	
	public Program(long id, String name, Set<Tag> tags, Channel channel,
			SortedSet<StartTime> startTimes, int length, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.tags = tags;
		this.channel = channel;
		this.startTimes = startTimes;
		this.length = length;
		this.enabled = enabled;
	}
	
	@Id @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "program_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "tags_programs",
            joinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	@ManyToOne
	@JoinColumn(name = "channel_id")
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	@OneToMany(mappedBy="program", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@Sort(type = SortType.NATURAL)
	public SortedSet<StartTime> getStartTimes() {
		return startTimes;
	}
	public void setStartTimes(SortedSet<StartTime> startTimes) {
		this.startTimes = startTimes;
	}
	
	
	@Column(name = "program_length")
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	@Column(name = "program_enabled")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
