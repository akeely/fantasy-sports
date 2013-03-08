/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.twoguysandadream.fantasy.auction.model.Team;

/**
 * Add an retrieve teams from the database.
 * 
 * @author andrew_keely
 */
public interface TeamDao extends CrudRepository<Team, Integer> {

    /**
     * Use {@link CrudRepository} methods for basic implementation. 
     */
	
	/**
	 * Get the list of teams associated with a user.
	 * 
	 * @param userId The user to get teams for.
	 * @return The teams associated with the user.
	 */
	public List<Team> findByUserId(int userId);
}
