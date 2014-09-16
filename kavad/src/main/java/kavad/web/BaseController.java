package kavad.web;

import javax.servlet.http.HttpServletRequest;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import kavad.dao.ChannelDao;
import kavad.dao.KavadUserDao;
import kavad.dao.ProgramDao;
import kavad.dao.StartTimeDao;
import kavad.dao.TagDao;
import kavad.dataobjects.Channel;
import kavad.dataobjects.Program;
import kavad.dataobjects.Tag;
import kavad.service.DateService;
/**
 * Base class for all Controllers.
 * Contains all the setters for necessary Data Access Objects.
 * 
 * @author Kaur
 *
 */
public class BaseController {

	protected Log logger = LogFactory.getLog(getClass());
	
	
	
	/**
	 * Method to register different Editors to the given Databinder.
	 * Editors convert Strings coming from HTML Forms to necessary classes
	 * 
	 * @param request HttpServletRequest
	 * @param binder ServletRequestDataBinder
	 * @see ServletRequestDataBinder
	 */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		binder.registerCustomEditor(Set.class, "tags", new PropertyEditorSupport(){
			public void setAsText(String text){
				Set<Tag> tags = new HashSet<Tag>();
				StringTokenizer st = new StringTokenizer(text, " \t\n\r\f.,;");
				while(st.hasMoreTokens()){
					String token = st.nextToken();
					Tag tag = tagDao.getByName(token);
					if(tag != null){
						tags.add(tag);
					}else{
						tag = new Tag();
						tag.setName(token);
						tagDao.save(tag);
						tags.add(tag);
					}
				}
				setValue(tags);
			}
		});
		binder.registerCustomEditor(Channel.class, "channel", new PropertyEditorSupport(){
			public void setAsText(String text){
				Channel channel = channelDao.getById(Long.valueOf(text));
				setValue(channel);
			}
		});
		binder.registerCustomEditor(Program.class, "program", new PropertyEditorSupport(){
			public void setAsText(String text){
				Program program = programDao.getById(Long.valueOf(text));
				setValue(program);
			}
		});
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		dateFormat.setLenient(true);
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);

	}
	
	@Autowired
	protected ChannelDao channelDao;
	public ChannelDao getChannelDao() {
		return channelDao;
	}
	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	
	@Autowired
	protected KavadUserDao kavadUserDao;
	public KavadUserDao getKavadUserDao() {
		return kavadUserDao;
	}
	public void setKavadUserDao(KavadUserDao kavadUserDao) {
		this.kavadUserDao = kavadUserDao;
	}
	
	@Autowired
	protected ProgramDao programDao;
	public ProgramDao getProgramDao() {
		return programDao;
	}
	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
	@Autowired
	protected StartTimeDao startTimeDao;
	public StartTimeDao getStartTimeDao() {
		return startTimeDao;
	}
	public void setStartTimeDao(StartTimeDao startTimeDao) {
		this.startTimeDao = startTimeDao;
	}

	@Autowired
	protected TagDao tagDao;
	public TagDao getTagDao() {
		return tagDao;
	}
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	
	@Autowired
	protected DateService dateService;
	public DateService getDateService() {
		return dateService;
	}
	public void setDateService(DateService dateService) {
		this.dateService = dateService;
	}
}
