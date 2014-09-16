package kavad.web.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kavad.dataobjects.Channel;
import kavad.web.BaseController;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMain(Model model){
		List<Channel> channels = channelDao.getAll();
		model.addAttribute("channels", channels);
		model.addAttribute("jspContent", "channels.jsp");
		return "admin/main";
	}
}
