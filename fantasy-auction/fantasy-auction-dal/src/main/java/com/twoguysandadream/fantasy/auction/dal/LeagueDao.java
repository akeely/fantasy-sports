/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal;

import com.twoguysandadream.fantasy.auction.dal.exception.DataAccessException;
import com.twoguysandadream.fantasy.auction.model.LeagueSettings;

/**
 * @author akeely
 *
 */
public interface LeagueDao {

	public LeagueSettings getLeagueSettings(int leagueId) throws DataAccessException;
}
