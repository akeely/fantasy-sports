package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import com.twoguysandadream.fantasy.auction.dal.exception.DataAccessException;
import com.twoguysandadream.fantasy.auction.dal.exception.PlayerAlreadyExistsException;
import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;

/**
 * Access the players that have already been won in an auction.
 * 
 * @author akeely
 */
public interface PlayersWonDao {

    /**
     * Add a new player that has been won in the auction.
     * 
     * @param auctionPlayer The player to add.
     * @throws PlayerAlreadyExistsException if the player has already been won.
     * @throws DataAccessException if the player cannot be added.
     */
    public void addPlayerWon(AuctionPlayer auctionPlayer) throws DataAccessException;

    /**
     * Get a player that has already been won.
     * 
     * @param leagueId The league to get the player from.
     * @param playerId The player to get.
     * @return The player that has been won, or null if the player has not been won.
     * @throws DataAccessException if the player cannot be retrieved.
     */
    public AuctionPlayer getPlayerWon(int leagueId, int playerId) throws DataAccessException;

    /**
     * Get all of the players a given team has won.
     * 
     * @param leagueId The league to get the players from.
     * @param teamId The team to get the players for.
     * @return The list of players the team has won.
     * @throws DataAccessException if the players cannot be retrieved.
     */
    public List<AuctionPlayer> getPlayersWonByTeam(int leagueId, int teamId)
            throws DataAccessException;
}
