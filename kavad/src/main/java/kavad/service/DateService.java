package kavad.service;

import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

/**
 * Class for different manipulations with Dates
 * 
 * @author Kaur
 *
 */
@Service("dateService")
public class DateService {

	/**
	 * Holds the Estonian names for weekDays
	 */
	private final String[] weekDays = 
	{"Pühapäev", "Esmaspäev", "Teisipäev", "Kolmapäev", "Neljapäev", "Reede", "Laupäev"};

	/**
	 * Creates an ordered map of Dates and corresponding Estonina weekday names.
	 * Starts with current Date
	 * 
	 * @return Map of Dates and weekday names
	 */
	public TreeMap<Date, String> createWeekMap(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		int now = calendar.get(Calendar.DAY_OF_WEEK) -1 ;
		TreeMap<Date, String> map = new TreeMap<Date, String>();
		for(int i = 0; i <= 7; i++){
			map.put(calendar.getTime(), weekDays[now]);
			calendar.add(Calendar.DATE, 1);
			now++;
			if(now > 6){
				now = 0;
			}
		}
		
		return map;
	}
}
