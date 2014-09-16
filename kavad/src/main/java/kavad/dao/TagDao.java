package kavad.dao;

import java.util.List;

import kavad.dataobjects.Tag;

import org.springframework.transaction.annotation.Transactional;
/**
 * Interface for manipulating Tags given to Programs and Channels
 * 
 * @author Kaur
 * @see Tag
 * @see Program
 * @see Channel
 */

@Transactional
public interface TagDao {
	
	/**
	 * Persist given Tag
	 * 
	 * @param tag
	 */
	public void save(Tag tag);
	
	/**
	 * Fetches Tag by given Id
	 * 
	 * @param id
	 * @return Tag
	 */
	public Tag getById(long id);
	
	/**
	 * Fetches Lis of all Tags
	 * 
	 * @return List of all Tags
	 */
	public List<Tag> getAll();
	
	/**
	 * Fetches Tag with given name
	 * 
	 * @param name
	 * @return Tag
	 */
	public Tag getByName(String name);

}
