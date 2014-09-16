package kavad.service;

import java.util.Collection;

import kavad.dataobjects.KavadUser;

import org.springframework.security.core.GrantedAuthority;

/**
 * Class extending Spring Security User. Meant for authentication 
 * 
 * @author Kaur
 * @see User
 */

public class SecurityUser extends org.springframework.security.core.userdetails.User {
	
	private KavadUser user;
	private String salt;
	
	public KavadUser getUser(){
		return user;
	}
	
	public void setUser(KavadUser user){
		this.user = user;
	}

	public SecurityUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String salt) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.setSalt(salt);
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

}
