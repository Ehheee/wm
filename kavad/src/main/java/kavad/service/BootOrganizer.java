package kavad.service;

import java.util.List;

import kavad.dao.KavadUserDao;
import kavad.dataobjects.KavadUser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Class containing Method(s) that help to set up the application
 * 
 * @author Kaur
 *
 */

public class BootOrganizer {
	
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * Method that secures the database by adding a random salt value to users.
	 * Also encodes users passwords with given salt
	 * 
	 */
	public void secureDatabase(){
		List<KavadUser> users = kavadUserDao.getAll();
		for(int i = 0; i < users.size(); i++){
			KavadUser user = users.get(i);
			double d  = Math.random()*1000000;
			String salt = String.valueOf(d);
			user.setSalt(salt);
			kavadUserDao.save(user);
			String encodedPassword = passwordEncoder.encodePassword(user.getPassword(), salt);
			
			user.setPassword(encodedPassword);
			kavadUserDao.save(user);
			
		}
	}


	@Autowired
	private KavadUserDao kavadUserDao;
	public KavadUserDao getKavadUserDao() {
		return kavadUserDao;
	}
	public void setKavadUserDao(KavadUserDao kavadUserDao) {
		this.kavadUserDao = kavadUserDao;
	}
	
	private PasswordEncoder passwordEncoder;
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
	
	
	private SaltSource saltSource;
	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}
	public SaltSource getSaltSource() {
		return saltSource;
	}
	
	private UserDetailsService userService;
	public void setUserService(UserDetailsService userService) {
		this.userService = userService;
	}
	public UserDetailsService getUserService() {
		return userService;
	}
	
}
