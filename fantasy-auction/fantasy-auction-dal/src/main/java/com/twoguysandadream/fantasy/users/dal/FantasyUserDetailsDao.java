/**
 * 
 */
package com.twoguysandadream.fantasy.users.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twoguysandadream.fantasy.users.model.FantasyUserDetails;

/**
 * Get the user details for login and access information.
 * 
 * @author andrew_keely
 */
@Repository
public interface FantasyUserDetailsDao extends CrudRepository<FantasyUserDetails, Integer> {

	/**
	 * Find a user by username.
	 * 
	 * @param userName The username of the user.
	 * @return The user.
	 */
	public FantasyUserDetails findByUserName(String userName);
}
