package kavad.dao;

import java.util.List;

import kavad.dataobjects.Program;

import org.springframework.transaction.annotation.Transactional;

/**
 * Interface for manipulating tv-programs
 * 
 * @author Kaur
 * @see Program
 */
@Transactional
public interface ProgramDao {

	/**
	 * Persists the given program
	 * 
	 * @param program
	 * @return id of persisted Program
	 */
	public long save(Program program);
	
	/**
	 * Deletes Program with given Id
	 * 
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 * Fetches Program with given Id
	 * 
	 * @param id
	 * @return Program
	 */
	public Program getById(long id);
	
	/**
	 * Fetches Program with given name
	 * 
	 * @param name
	 * @return Program
	 */
	public Program getByName(String name);
	
	/**
	 * Fetches List of all Programs
	 * 
	 * @return List of all Programs
	 */
	public List<Program> getAll();
}
