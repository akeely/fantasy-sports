/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal;

import com.twoguysandadream.fantasy.auction.dal.exception.DataAccessException;
import com.twoguysandadream.fantasy.auction.model.LeagueSettings;

/**
 * Access information about leagues.
 * 
 * @author akeely
 */
public interface LeagueDao {

    /**
     * Get the settings for a league.
     * 
     * @param leagueId The league to get the settings for.
     * @return The league settings.
     * @throws DataAccessException if the settings cannot be retrieved.
     */
    public LeagueSettings getLeagueSettings(int leagueId) throws DataAccessException;
}
