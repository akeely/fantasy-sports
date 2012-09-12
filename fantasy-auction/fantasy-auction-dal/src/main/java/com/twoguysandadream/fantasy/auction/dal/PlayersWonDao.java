package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import com.twoguysandadream.fantasy.auction.dal.exception.DataAccessException;
import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;

public interface PlayersWonDao {

	public void addPlayerWon(AuctionPlayer auctionPlayer) throws DataAccessException;
	
	public AuctionPlayer getPlayerWon(int leagueId, int playerId) throws DataAccessException;
	
	public List<AuctionPlayer> getPlayersWonByTeam(int leagueId, int teamId) throws DataAccessException;
}
