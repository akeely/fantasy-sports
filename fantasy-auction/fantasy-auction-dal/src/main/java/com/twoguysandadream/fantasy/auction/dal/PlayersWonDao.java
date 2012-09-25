package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;

/**
 * Access the players that have already been won in an auction.
 * 
 * @author akeely
 */
public interface PlayersWonDao extends CrudRepository<AuctionPlayer, Integer>{

    /**
     * Get the players that have been won by a given team.
     * 
     * @param teamId The team to get players won for.
     * @return The players won by the team.
     */
    public List<AuctionPlayer> findByTeamId(int teamId);
    
    /**
     * Get a player that has already been won.
     * 
     * @param leagueId The league to get the player for.
     * @param playerId The player to get.
     * @return The player that has been won, or null if the player has not been won.
     */
    public AuctionPlayer findByLeagueIdAndPlayerId(int leagueId, int playerId);
}
