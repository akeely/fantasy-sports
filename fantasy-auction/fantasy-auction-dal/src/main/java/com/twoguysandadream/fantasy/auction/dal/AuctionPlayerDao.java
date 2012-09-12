package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import com.twoguysandadream.fantasy.auction.dal.exception.DataAccessException;
import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;

public interface AuctionPlayerDao {

	/**
	 * Get a list of players currently being auctioned for a given league.
	 * 
	 * @param leagueId The league to get the players for.
	 * @return The players currently being auctioned.
	 */
	public List<AuctionPlayer> getPlayers(int leagueId) throws DataAccessException;

	public List<AuctionPlayer> getPlayersByTeam(int leagueId, int teamId) throws DataAccessException;
	
	/**
	 * Add a new player to be auctioned.
	 * 
	 * @param player The player to add.
	 * @throws if the player cannot be added or is already in the auction.
	 */
	public void addPlayer(AuctionPlayer player) throws DataAccessException;
	
	/**
	 * Update the winning bid team and amount and the expiration time for a player being auctioned.
	 * 
	 * @param player The player to update.
	 * @throws DataAccessException if the player cannot be updated or is not being auctioned.
	 */
	public void updatePlayer(AuctionPlayer player) throws DataAccessException;
	
	/**
	 * Get a player that is being auctioned.
	 * 
	 * @param leagueId The league of the auction.
	 * @param playerId The player to retrieve.
	 * @return The player being auctioned, or null if the player is not being auctioned.
	 * @throws DataAccessException if the player cannot be retrieved.
	 */
	public AuctionPlayer getPlayer(int leagueId, int playerId) throws DataAccessException;
	
	/**
	 * Remove a player from the auction.
	 * 
	 * @param leagueId The league of the auction to remove the player from.
	 * @param playerId The player to remove.
	 * @throws DataAccessException if the player cannot be removed.
	 */
	public void deletePlayer(int leagueId, int playerId) throws DataAccessException;
}
