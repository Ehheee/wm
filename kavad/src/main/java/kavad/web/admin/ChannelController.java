package kavad.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kavad.dataobjects.Channel;
import kavad.web.BaseController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/channels")
public class ChannelController extends BaseController{

	@RequestMapping(method = RequestMethod.GET)
	public String getChannels(Model model){
		List<Channel> channels = channelDao.getAll();
		model.addAttribute("channels", channels);
		model.addAttribute("jspContent", "channels.jsp");
		return "admin/main";
	}
	
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String getChannelEdit(@PathVariable("id") long id, 
									Model model,
									HttpSession session,
									HttpServletRequest request){
		model.addAttribute("jspContent", "channelform.jsp");
		if(id == 0){
			return "admin/main";
		}else{
			Channel channel = channelDao.getById(id);
			model.addAttribute("channel", channel);
			return "admin/main";
		}
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String postChannelEdit(@ModelAttribute("channel") Channel channel,
									@PathVariable("id") long id,
									HttpSession session,
									Model model){
		if(id == 0){
			id = channelDao.save(channel);
			return "redirect:/admin/channels/" + id + "/edit";
		}else{
			channelDao.save(channel);
			model.addAttribute("jspContent", "channelform.jsp");
			model.addAttribute("channel", channelDao.getById(id));
			
			return "admin/main";
		}
		
	}
	
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteChannel(@PathVariable("id") long id){
		channelDao.delete(id);
		return "redirect:/admin/channels";
	}
}
