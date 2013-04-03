package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twoguysandadream.fantasy.auction.model.PlayerWon;

/**
 * Access the players that have already been won in an auction.
 * 
 * @author akeely
 */
@Repository
public interface PlayersWonDao extends CrudRepository<PlayerWon, Integer>{

    /**
     * Get the players that have been won by a given team.
     * 
     * @param teamId The team to get players won for.
     * @return The players won by the team.
     */
    public List<PlayerWon> findByTeamId(int teamId);
    
    /**
     * Get the full list of players won in a league.
     * 
     * @param leagueId The league to get the players won for.
     * @return The players that have been won in the league.
     */
    public List<PlayerWon> findByLeagueId(int leagueId);
    
    /**
     * Get a player that has already been won.
     * 
     * @param leagueId The league to get the player for.
     * @param playerId The player to get.
     * @return The player that has been won, or null if the player has not been won.
     */
    public PlayerWon findByLeagueIdAndPlayerId(int leagueId, int playerId);
}
