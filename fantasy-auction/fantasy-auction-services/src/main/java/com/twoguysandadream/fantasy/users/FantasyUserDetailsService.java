/**
 * 
 */
package com.twoguysandadream.fantasy.users;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twoguysandadream.fantasy.users.dal.FantasyUserDetailsDao;
import com.twoguysandadream.fantasy.users.model.FantasyAuthorities;
import com.twoguysandadream.fantasy.users.model.FantasyUserDetails;

/**
 * @author andrew_keely
 *
 */
@Component
public class FantasyUserDetailsService implements UserDetailsService {

	private final FantasyUserDetailsDao fantasyUserDetailsDao;
	
	@Inject
	public FantasyUserDetailsService(FantasyUserDetailsDao fantasyUserDetailsDao) {
		this.fantasyUserDetailsDao=fantasyUserDetailsDao;
	}
	
	/**
	 * @see UserDetailsService#loadUserByUsername(String)
	 */
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		UserDetails userDetails = fantasyUserDetailsDao.findByUserName(userName);
		if(userDetails == null) {
			userDetails = createNewUser(userName);
		}
		
		// TODO: This is necessary because of lazy init. Figure out a better way.
		Collection<? extends GrantedAuthority> auth = userDetails.getAuthorities();
		System.out.println(userDetails.getUsername() + " has " + auth.size() + " authorities.");
		
		
		return userDetails;
	}

	private UserDetails createNewUser(String userName) {
		
		FantasyUserDetails newUserDetails = new FantasyUserDetails();
		newUserDetails.setUserName(userName);
		newUserDetails.getAuthorities().add(FantasyAuthorities.ROLE_USER);
		
		return fantasyUserDetailsDao.save(newUserDetails);
	}

}
