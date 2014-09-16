package kavad.dao;

import java.util.Date;
import java.util.List;

import kavad.dataobjects.Channel;

import org.springframework.transaction.annotation.Transactional;
/**
 * Interface for manipulating persisted Channels
 * 
 * @author Kaur
 * @see Channel
 */
@Transactional
public interface ChannelDao {

	/**
	 * Persists given Channel
	 * 
	 * @param channel to be saved
	 * @return the id of saved channel
	 * @see Channel
	 */
	public long save(Channel channel);
	
	/**
	 * Deletes Channel with given Id
	 * 
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 * Fetches Channel with given Id
	 * 
	 * @param id
	 * @return Channel
	 */
	public Channel getById(long id);
	
	/**
	 * Fetches Channel with given name
	 * 
	 * @param channelName
	 * @return
	 */
	public Channel getByName(String channelName);
	
	/**
	 * Fetches list with all Channels
	 * 
	 * @return List of all Channels
	 */
	public List<Channel> getAll();
}
