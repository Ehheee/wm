package kavad.web.client;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import kavad.dataobjects.Channel;
import kavad.dataobjects.StartTime;
import kavad.web.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController extends BaseController{

	@RequestMapping(method = RequestMethod.GET)
	public String showMain(Model model){
		List<Channel> channels = channelDao.getAll();
		model.addAttribute("channels", channels);
		model.addAttribute("jspContent", "channels.jsp");
		return "client/main";
	}
	
	@RequestMapping(value = "/{cName}", method = RequestMethod.GET)
	public String showChannel(@RequestParam(value = "start", required = false) Date min,
								@RequestParam(value = "end", required = false) Date max,
								@PathVariable("cName") String channelName,
								Model model){
		List<StartTime> startTimes;
		Channel channel = channelDao.getByName(channelName);
		TreeMap<Date, String> week = dateService.createWeekMap();
		model.addAttribute("week", week);
		if(min == null && max == null){
			Calendar calendar = Calendar.getInstance();
			min = calendar.getTime();
			calendar.add(Calendar.DATE, 1);
			max = calendar.getTime();
		}else if(min != null && max == null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(min);
			calendar.add(Calendar.DATE, 1);
			max = calendar.getTime();
		}
		startTimes = startTimeDao.getByChannelBetweenDates(channelName, min, max);
		model.addAttribute("channel", channel);
		model.addAttribute("startTimes", startTimes);
		model.addAttribute("jspContent", "channel.jsp");
		return "client/main";
	}
	
}
