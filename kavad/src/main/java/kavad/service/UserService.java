package kavad.service;

import java.util.ArrayList;
import java.util.List;

import kavad.dao.KavadUserDao;
import kavad.dataobjects.KavadUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Class necessary for Spring Security. 
 * 
 * @author Kaur
 * @see UserDetailsService
 */

public class UserService implements UserDetailsService {

	
	/**
	 * Method that has to be overriden. Loads user by Username, when user Logs in
	 * If user with given name is not found, throws UsernameNotFoundException
	 * 
	 * @param userName
	 * @return implementation of Spring Security userDetails
	 * @see UserDetails
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		KavadUser user = kavadUserDao.getByName(userName);
		if(user != null){
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority(user.getPrivilege()));
			SecurityUser securityUser = new SecurityUser(
					user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, roles, user.getSalt()
			);
			securityUser.setUser(user);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("No user with username '" + userName + "' found!");
		}
	}

	private KavadUserDao kavadUserDao;
	public KavadUserDao getKavadUserDao() {
		return kavadUserDao;
	}
	public void setKavadUserDao(KavadUserDao kavadUserDao) {
		this.kavadUserDao = kavadUserDao;
	}
}
