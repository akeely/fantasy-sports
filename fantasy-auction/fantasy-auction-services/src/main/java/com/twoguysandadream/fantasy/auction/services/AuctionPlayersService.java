package com.twoguysandadream.fantasy.auction.services;

import java.util.List;

import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;
import com.twoguysandadream.fantasy.auction.model.Player;
import com.twoguysandadream.fantasy.auction.services.exception.AuctionPlayersServiceException;
import com.twoguysandadream.fantasy.auction.services.exception.InsufficientBidException;
import com.twoguysandadream.fantasy.auction.services.exception.InsufficientFundsException;
import com.twoguysandadream.fantasy.auction.services.exception.RosterFullException;

/**
 * Manage the players available in an ongoing auction.
 * 
 * @author akeely
 */
public interface AuctionPlayersService {

    /**
     * Get the list of players currently available to bid on.
     * 
     * @param leagueId The league to get the players for.
     * @return The players available to bid on.
     * @throws AuctionPlayersServiceException if the players cannot be retrieved.
     */
    public List<AuctionPlayer> getAuctionPlayers(int leagueId)
            throws AuctionPlayersServiceException;

    /**
     * Get the list of players that can be added to the auction.
     * 
     * @param leagueId The league to get the players for.
     * @return The players available to add to the auction.
     * @throws AuctionPlayersServiceException
     */
    public List<Player> getAvailablePlayers(int leagueId) throws AuctionPlayersServiceException;
    
    /**
     * Submit a new bid for a player.
     * 
     * @param leagueId The league to submit the bid for.
     * @param playerId The player to bid on.
     * @param teamId The team submitting the bid.
     * @param bid The bid amount.
     * @throws InsufficientBidException if the bid is not greater than the previous bid.
     * @throws InsufficientFundsException if the bidding team cannot afford the bid.
     * @throws RosterFullException if the bidding team does not have available roster space.
     * @throws AuctionPlayersServiceException if the bid cannot be submitted, or is invalid.
     */
    public void updateBid(int leagueId, int playerId, int teamId, int bid)
            throws AuctionPlayersServiceException;

    /**
     * Add a new player to the auction.
     * 
     * @param leagueId The league of the auction to add the player to.
     * @param playerId The player to add to the auction.
     * @param teamId The team submitting the initial bid on the player.
     * @param bid The initial bid on the player.
     * @throws AuctionPlayersServiceException if the player could not be added.
     */
    public void addAuctionPlayer(int leagueId, int playerId, int teamId, int bid)
            throws AuctionPlayersServiceException;
}
