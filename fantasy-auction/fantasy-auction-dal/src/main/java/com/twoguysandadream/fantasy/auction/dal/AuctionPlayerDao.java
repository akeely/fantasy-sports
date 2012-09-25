package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;

/**
 * Access players that are currently up for auction.
 * 
 * @author akeely
 */
@Repository
public interface AuctionPlayerDao extends CrudRepository<AuctionPlayer, Integer> {

    /**
     * Get a list of players currently being auctioned for a given league.
     * 
     * @param leagueId The league to get the players for.
     * @return The players currently being auctioned.
     */
    public List<AuctionPlayer> findByLeagueId(int leagueId);

    /**
     * Get the list of players that a team is currently winning.
     * 
     * @param teamId The team to get the players for.
     * @return The players that the team is currently winning.
     */
    public List<AuctionPlayer> findByTeamId(int teamId);

    /**
     * Get a player currently being auctioned.
     * 
     * @param leagueId The league of the auction to get the player for.
     * @param playerId The player to get.
     * @return The player being auctioned.
     */
    public AuctionPlayer findByLeagueIdAndPlayerId(int leagueId, int playerId);

}
