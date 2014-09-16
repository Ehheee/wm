package kavad.web.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kavad.dataobjects.Channel;
import kavad.dataobjects.Program;
import kavad.dataobjects.StartTime;
import kavad.web.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/programs")
public class ProgramController extends BaseController{

	@RequestMapping(method = RequestMethod.GET)
	public String getPrograms(Model model){
		List<Program> programs = programDao.getAll();
		model.addAttribute("programs", programs);
		model.addAttribute("jspContent", "programs.jsp");
		return "admin/main";
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String getProgramEdit(@PathVariable("id") long id,
									@RequestParam(value = "channelId", required = false) Long channelId,
									Model model, 
									HttpServletRequest servletRequest,
									HttpSession session){
		model.addAttribute("jspContent", "programform.jsp");
		List<Channel> channels= channelDao.getAll();
		if(id != 0){
			Program program = programDao.getById(id);
			model.addAttribute("program", program);

		}else{
			if(channelId != null){
				Channel channel = channelDao.getById(channelId);
				Program program = new Program();
				program.setChannel(channel);
				model.addAttribute("program", program);
			}
		}
		
		model.addAttribute("channels", channels);
		return "admin/main";
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String postProgramEdit(@ModelAttribute("program") Program program, 
								@PathVariable("id") long id,
								Model model,
								HttpSession session){
		if(id == 0){
			id = programDao.save(program);
			return "redirect:/admin/programs/" + id + "/edit";
		}else{
			programDao.save(program);
			model.addAttribute("program", programDao.getById(id));
			model.addAttribute("jspContent", "programform.jsp");
			return "admin/main";
		}

	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteProgram(@PathVariable("id") long id){
		programDao.delete(id);
		
		return "redirect:/admin/programs";
	}
	
	@RequestMapping(value="/{pid}/starttime/{sid}", method = RequestMethod.GET)
	public String getStartTimeEdit(@PathVariable("pid") long pid, 
									@PathVariable("sid") long sid, 
									Model model){
		if(sid != 0){
			StartTime startTime = startTimeDao.getById(sid);
			model.addAttribute("startTime", startTime);
		}else{
			StartTime startTime = new StartTime();
			Program program = programDao.getById(pid);
			startTime.setProgram(program);
			model.addAttribute("startTime", startTime);
		}
		
		model.addAttribute("jspContent", "starttimeform.jsp");
		return "admin/main";
	}
	
	@RequestMapping(value="/{pid}/starttime/{sid}", method = RequestMethod.POST)
	public String postStartTimeEdit(@ModelAttribute("startTime") StartTime startTime,
										@PathVariable("pid") long pid,
										@PathVariable("sid") long sid,
										Model model){
		if(sid == 0){
			sid = startTimeDao.save(startTime);
			return "redirect:/admin/programs/" + pid + "/starttime/" + sid;
		}else{
			startTimeDao.save(startTime);
			model.addAttribute("startTime", startTimeDao.getById(sid));
			model.addAttribute("jspContent", "starttimeform.jsp");
			return "admin/main";
		}
	}
	
	@RequestMapping(value="/{id}/starttime/{sid}/delete", method = RequestMethod.GET)
	public String deleteStartTime(@PathVariable("sid") long sid,
									@PathVariable("id") long id){
		Program program = programDao.getById(id);
		StartTime startTime = startTimeDao.getById(sid);
		program.getStartTimes().remove(startTime);
		startTimeDao.delete(startTime);
		return "redirect:/admin/programs/" + id + "/edit";
	}
}
