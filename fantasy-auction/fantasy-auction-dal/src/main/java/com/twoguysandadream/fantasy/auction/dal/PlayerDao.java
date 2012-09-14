package com.twoguysandadream.fantasy.auction.dal;

import com.twoguysandadream.fantasy.auction.dal.exception.DataAccessException;
import com.twoguysandadream.fantasy.auction.model.Player;

/**
 * Access metadata relating to players.
 * 
 * @author akeely
 */
public interface PlayerDao {

    /**
     * Get a player.
     * 
     * @param playerId The identifier of the player.
     * @return The player associated with the IDs.
     * @throws DataAccessException if the player cannot be retrieved.
     */
    public Player getPlayer(int playerId) throws DataAccessException;
}
