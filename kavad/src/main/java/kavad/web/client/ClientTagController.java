package kavad.web.client;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import kavad.dataobjects.Channel;
import kavad.dataobjects.Program;
import kavad.dataobjects.StartTime;
import kavad.dataobjects.Tag;
import kavad.web.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tags")
public class ClientTagController extends BaseController{

	@RequestMapping(method = RequestMethod.GET)
	public String getTags(Model model){
		List<Tag> tags = tagDao.getAll();
		
		model.addAttribute("tags", tags);
		model.addAttribute("jspContent", "tags.jsp");
		return "client/main";
	}
	
	@RequestMapping(value = "/{tagName}", method = RequestMethod.GET)
	public String getProgram(@PathVariable("tagName") String tagName,
								@RequestParam(value = "start", required = false) Date min,
								@RequestParam(value = "end", required = false) Date max,
								Model model){
		Tag tag = tagDao.getByName(tagName);
		Set<Channel> channels = tag.getChannels();
		Calendar calendar = Calendar.getInstance();
		
		Set<Program> programs = null;
		List<StartTime> startTimes = null;
		
		if(min == null && max == null){
			programs = tag.getPrograms();
		}else if(min != null && max == null){
			calendar.setTime(min);
			calendar.add(Calendar.DATE, 7);
			max = calendar.getTime();
			startTimes = startTimeDao.getByTagBetweenDates(tagName, min, max);
		}else if(min == null && max != null){
			calendar.setTime(max);
			calendar.add(Calendar.DATE, -7);
			min = calendar.getTime();
			startTimes = startTimeDao.getByTagBetweenDates(tagName, min, max);
		}else{
			startTimes = startTimeDao.getByTagBetweenDates(tagName, min, max);
		}
		model.addAttribute("tag", tag);
		model.addAttribute("startTimes", startTimes);
		model.addAttribute("channels", channels);
		model.addAttribute("programs", programs);
		model.addAttribute("jspContent", "tag.jsp");
		return "client/main";
	}
}
