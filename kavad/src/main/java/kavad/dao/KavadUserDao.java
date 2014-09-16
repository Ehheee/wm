package kavad.dao;

import java.util.List;

import kavad.dataobjects.KavadUser;

import org.springframework.transaction.annotation.Transactional;

/**
 * Interface for manipulating persisted Users of "kavad" application
 * 
 * @author Kaur
 * @see KavadUser
 */
@Transactional
public interface KavadUserDao {

	
	/**
	 * Fetches KavadUser with given Id
	 * 
	 * @param id
	 * @return KavadUser
	 */
	public KavadUser getById(long id);
	
	/**
	 * Fetches KavadUser with given name
	 * 
	 * @param name
	 * @return KavadUser
	 */
	public KavadUser getByName(String name);
	
	/**
	 * 
	 * Fetches list of all KavadUsers
	 * 
	 * @return list of all KavadUsers
	 */
	public List<KavadUser> getAll();
	
	/**
	 * Persists given KavadUser
	 * 
	 * @param kavadUser
	 */
	
	public void save(KavadUser kavadUser);
	
}
