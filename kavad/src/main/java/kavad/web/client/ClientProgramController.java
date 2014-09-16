package kavad.web.client;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import kavad.dataobjects.Program;
import kavad.dataobjects.StartTime;
import kavad.web.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/programmid")
public class ClientProgramController extends BaseController{

	
	@RequestMapping(method = RequestMethod.GET)
	public String getPrograms(Model model){
		List<Program> programs = programDao.getAll();
		model.addAttribute("programs", programs);
		model.addAttribute("jspContent", "programs.jsp");
		return "client/main";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProgram(@PathVariable("id") long id,
								@RequestParam(value = "start", required = false) Date min,
								@RequestParam(value = "end", required = false) Date max,
								Model model){
		Program program = programDao.getById(id);
		Calendar calendar = Calendar.getInstance();
		List<StartTime> startTimes;
		if(min == null && max == null){
			min = calendar.getTime();
			calendar.add(Calendar.DATE, 7);
			max = calendar.getTime();
		}else if(min != null && max == null){
			calendar.setTime(min);
			calendar.add(Calendar.DATE, 7);
			max = calendar.getTime();
		}else if(min == null && max != null){
			calendar.setTime(max);
			calendar.add(Calendar.DATE, -7);
			min = calendar.getTime();
		}
		startTimes = startTimeDao.getByProgramBetweenDates(program.getName(), min, max);
		model.addAttribute("start", min);
		model.addAttribute("end", max);
		model.addAttribute("startTimes", startTimes);
		model.addAttribute("program", program);
		model.addAttribute("jspContent", "program.jsp");
		return "client/main";
	}
}
