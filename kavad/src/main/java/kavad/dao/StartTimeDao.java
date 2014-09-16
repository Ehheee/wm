package kavad.dao;

import java.util.Date;
import java.util.List;

import kavad.dataobjects.StartTime;

import org.springframework.transaction.annotation.Transactional;
/**
 * Interface for manipulating persisted StartTimes of Programs
 * 
 * @author Kaur
 * @see StartTime
 */
@Transactional
public interface StartTimeDao {

	/**
	 * Persists given StartTime
	 * 
	 * @param startTime
	 * @return id of persisted StartTime
	 */
	public long save(StartTime startTime);
	
	/**
	 * Deletes given StartTime
	 * 
	 * @param startTime
	 */
	public void delete(StartTime startTime);
	
	/**
	 * Fetches StartTime by given Id
	 * 
	 * @param id
	 * @return StartTime
	 */
	public StartTime getById(long id);
	
	/**
	 * Fetches a list of StartTimes for all Programs on Channel with given name,
	 * between given Dates.
	 * List should be ordered by StartTimes
	 * 
	 * @see Channel
	 * @param channelName
	 * @param min Start of date period
	 * @param max End of date period
	 * @return List of StartTimes
	 */
	public List<StartTime> getByChannelBetweenDates(String channelName, Date min, Date max);
	
	/**
	 * Fetches a list of StartTimes for Program of given name,
	 * between given Dates.
	 * List should be ordered by StartTimes
	 * 
	 * @see Program
	 * @param programName
	 * @param min Start of date period
	 * @param max End of date period
	 * @return List of StartTimes
	 */
	public List<StartTime> getByProgramBetweenDates(String programName, Date min, Date max);
	
	/**
	 * Fetches a list of StartTimes for given Tag,
	 * between given Dates.
	 * List should be ordered by StartTimes
	 * 
	 * @see Tag
	 * @param tagName
	 * @param min Start of date period
	 * @param max End of date period
	 * @return List of StartTimes
	 */
	public List<StartTime> getByTagBetweenDates(String tagName, Date min, Date max);
}
