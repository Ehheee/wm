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
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Class representing a Tv-Channel
 * 
 * @author Kaur
 *
 */
@Entity
@Table(name = "tv_channels")
public class Channel implements Serializable{
	
	private long id;
	private String name;
	private String description;
	private Set<Tag> tags;
	private Set<Program> programs;
	
	public Channel(){
		
	}
	
	
	public Channel(long id, String name, String description, Set<Tag> tags,
			Set<Program> programs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tags = tags;
		this.programs = programs;
	}
	
	@Id @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "channel_name", unique = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "channel_description", columnDefinition = "text")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
            name = "tags_channels",
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "id")
    )
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	@OneToMany(mappedBy="channel", fetch = FetchType.EAGER)
	public Set<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
	
	
}
