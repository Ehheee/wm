package kavad.dataobjects;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Class representing a Tag that can be given to Channels and Programs
 * 
 * @author Kaur
 * @see Program
 * @see Channel
 */
@Entity
@Table(name = "tags")
public class Tag implements Serializable{

	private Long id;
	private String name;
	private Set<Channel> channels;
	private Set<Program> programs;
	
	public Tag(){
		
	}
	
	
	
	public Tag(Long id, String name, Set<Channel> channels,
			Set<Program> programs) {
		super();
		this.id = id;
		this.name = name;
		this.channels = channels;
		this.programs = programs;
	}



	@Id @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(name = "tag_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "tags_channels",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "id")
    )
	public Set<Channel> getChannels() {
		return channels;
	}
	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "tags_programs",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id")
    )
	public Set<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
	
	
}
