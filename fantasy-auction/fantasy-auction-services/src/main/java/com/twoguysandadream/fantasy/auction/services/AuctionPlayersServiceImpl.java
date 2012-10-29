package com.twoguysandadream.fantasy.auction.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.twoguysandadream.fantasy.auction.dal.AuctionPlayerDao;
import com.twoguysandadream.fantasy.auction.dal.LeagueDao;
import com.twoguysandadream.fantasy.auction.dal.PlayersWonDao;
import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;
import com.twoguysandadream.fantasy.auction.model.League;
import com.twoguysandadream.fantasy.auction.services.exception.AuctionExpiredException;
import com.twoguysandadream.fantasy.auction.services.exception.AuctionPlayersServiceException;
import com.twoguysandadream.fantasy.auction.services.exception.InsufficientBidException;
import com.twoguysandadream.fantasy.auction.services.exception.InsufficientFundsException;
import com.twoguysandadream.fantasy.auction.services.exception.PlayerAlreadyAddedException;
import com.twoguysandadream.fantasy.auction.services.exception.PlayerAlreadyWonException;
import com.twoguysandadream.fantasy.auction.services.exception.RosterFullException;

/**
 * @see AuctionPlayersService
 * @author akeely
 */
@Component
public class AuctionPlayersServiceImpl implements AuctionPlayersService {

    /** Used to access the current players in the auction. */
    private final AuctionPlayerDao auctionPlayerDao;
    /** Used to access players that have been won for the league. */
    private final PlayersWonDao playersWonDao;
    /** Used to access information about the league. */
    private final LeagueDao leagueDao;

    /**
     * Load the DAL dependencies needs to manage the auction.
     * 
     * @param auctionPlayerDao
     * @param playersWonDao
     * @param leagueDao
     */
    @Inject
    public AuctionPlayersServiceImpl(AuctionPlayerDao auctionPlayerDao,
            PlayersWonDao playersWonDao, LeagueDao leagueDao) {

        this.auctionPlayerDao = auctionPlayerDao;
        this.playersWonDao = playersWonDao;
        this.leagueDao = leagueDao;
    }

    /**
     * @see AuctionPlayersService#addAuctionPlayer(int, int, int, int)
     * @throws PlayerAlreadyAddedException if the player is already in the auction.
     * @throws PlayerAlreadyWonException if the player has already been won.
     */
    @Override
    public synchronized void addAuctionPlayer(int leagueId, int playerId, int teamId, int bid)
            throws AuctionPlayersServiceException {

        checkForPlayerWon(leagueId, playerId);

        AuctionPlayer player = getPlayerToAdd(leagueId, playerId, teamId, bid);

        addAuctionPlayer(player);

    }

    /**
     * @see AuctionPlayersService#getAuctionPlayers(int)
     */
    @Override
    public List<AuctionPlayer> getAuctionPlayers(int leagueId)
            throws AuctionPlayersServiceException {

        return getAuctionPlayersInternal(leagueId);
    }

    /**
     * @see AuctionPlayersService#updateBid(int, int, int, int)
     */
    @Override
    public synchronized void updateBid(int leagueId, int playerId, int teamId, int bid)
            throws AuctionPlayersServiceException {

        AuctionPlayer auctionPlayer = getAuctionPlayer(leagueId, playerId);

        League league = leagueDao.findOne(leagueId);

        checkBid(auctionPlayer, leagueId, teamId, bid, league);

        auctionPlayer.setBid(bid);
        auctionPlayer.setTeamId(teamId);
        auctionPlayer.setExpirationTime(getUpdatedExpirationTime(auctionPlayer.getExpirationTime(),
                league));

        auctionPlayerDao.save(auctionPlayer);

    }

    /**
     * Get the list of players available to bid on. Does NOT populate the player metadata.
     * 
     * @param leagueId The league of the auction to get players for.
     * @return The players available to bid on WITHOUT the player metadata.
     * @throws AuctionPlayersServiceException if the players cannot be retrieved.
     */
    private synchronized List<AuctionPlayer> getAuctionPlayersInternal(int leagueId)
            throws AuctionPlayersServiceException {

        List<AuctionPlayer> players = auctionPlayerDao.findByLeagueId(leagueId);

        for (AuctionPlayer player : players) {
            if (checkForExpiredBid(player)) {
                players.remove(player);
            }
        }
        return players;
    }

    /**
     * Add a new player to the auction.
     * 
     * @param player The player to add.
     * @throws PlayerAlreadyAddedException if the player is already in the auction.
     */
    private synchronized void addAuctionPlayer(AuctionPlayer player)
            throws PlayerAlreadyAddedException {

        AuctionPlayer dbPlayer = auctionPlayerDao.findByLeagueIdAndPlayerId(player.getLeagueId(),
                player.getPlayerId());

        if (dbPlayer != null) {
            throw new PlayerAlreadyAddedException(player.getPlayerId());
        }

        auctionPlayerDao.save(player);
    }

    /**
     * Get the player to add to the auction.
     * 
     * @param leagueId The league to add the player for.
     * @param playerId The identifier of the player to add.
     * @param teamId The team with the leading bid on the player.
     * @param bid The current bid on the player.
     * @return The player to add.
     * @throws AuctionPlayersServiceException
     */
    private AuctionPlayer getPlayerToAdd(int leagueId, int playerId, int teamId, int bid)
            throws AuctionPlayersServiceException {

        League settings = leagueDao.findOne(leagueId);

        AuctionPlayer player = new AuctionPlayer();
        player.setBid(bid);
        player.setLeagueId(leagueId);
        player.setPlayerId(playerId);
        player.setTeamId(teamId);
        player.setBid(bid);
        player.setExpirationTime(System.currentTimeMillis() + settings.getAuctionLengthMillis());

        return player;
    }

    /**
     * Ensure that a player has not already been won.
     * 
     * @param leagueId The league to check.
     * @param playerId The player to check.
     * @throws AuctionPlayersServiceException if the player cannot be retrieved.
     * @throws PlayerAlreadyWonException if the player has been won.
     */
    private void checkForPlayerWon(int leagueId, int playerId)
            throws AuctionPlayersServiceException, PlayerAlreadyWonException {

        AuctionPlayer playerWon = playersWonDao.findByLeagueIdAndPlayerId(leagueId, playerId);

        if (playerWon != null) {
            throw new PlayerAlreadyWonException("Player " + playerId + " has already been won.");
        }
    }

    /**
     * Get the expiration time for an auction with a new bid.
     * 
     * @param currentExpirationTime The current expiration time of the auction.
     * @param leagueSettings The league settings determining the extension time and buffer.
     * @return The updated expiration time.
     */
    private long getUpdatedExpirationTime(long currentExpirationTime, League leagueSettings) {

        long currentTime = System.currentTimeMillis();

        if (currentExpirationTime > currentTime + leagueSettings.getBidTimeBufferMillis()) {
            return currentExpirationTime;
        }

        return currentTime + leagueSettings.getBidTimeExtensionMillis();
    }

    /**
     * Check whether a bid is legitimate.
     * 
     * @param auctionPlayer The player being bid on.
     * @param leagueId The league the bid is being made in.
     * @param teamId The team making the bid.
     * @param bid The bid to check.
     * @param league The league settings to determine roster size and minimum bids.
     * @throws InsufficientBidException if the bid is not greater than the previous bid.
     * @throws InsufficientFundsException if the team cannot afford the bid.
     * @throws RosterFullException if the team does not have roster space available for the bid.
     * @throws AuctionPlayersServiceException if a data access error occurs.
     */
    private void checkBid(AuctionPlayer auctionPlayer, int leagueId, int teamId, int bid,
            League league) throws AuctionPlayersServiceException {

        if (bid <= auctionPlayer.getBid()) {
            throw new InsufficientBidException(auctionPlayer.getBid(), bid);
        }

        List<AuctionPlayer> outstandingPlayers = getOutstandingPlayers(leagueId, teamId);

        int maxRosterSpace = league.getRosterSize();
        int maxBid = getMaxBid(outstandingPlayers, league);
        if (auctionPlayer.getTeamId() == teamId) {
            maxBid += auctionPlayer.getBid() - 1;
            maxRosterSpace += 1;
        }

        if (bid > maxBid) {
            throw new InsufficientFundsException(maxBid, bid);
        }

        if (outstandingPlayers.size() >= maxRosterSpace) {
            throw new RosterFullException("Outstanding bids exceed available roster space.");
        }
    }

    /**
     * Get the list of players a team has the leading bid on and has won.
     * 
     * @param leagueId The league to get the players for.
     * @param teamId The team to get the players for.
     * @return The list of players the team has won and is leading.
     * @throws AuctionPlayersServiceException if the players cannot be retrieved.
     */
    private List<AuctionPlayer> getOutstandingPlayers(int leagueId, int teamId)
            throws AuctionPlayersServiceException {

        List<AuctionPlayer> outstandingPlayers = auctionPlayerDao.findByTeamId(teamId);

        List<AuctionPlayer> playersWon = playersWonDao.findByTeamId(teamId);

        outstandingPlayers.addAll(playersWon);

        return outstandingPlayers;
    }

    /**
     * Get the maximum bid a team can make.
     * 
     * @param outstandingPlayers The players the team is already winning.
     * @param leagueSettings The settings containing the salary cap and roster size.
     * @return The maximum bid the team can make.
     */
    private int getMaxBid(List<AuctionPlayer> outstandingPlayers, League leagueSettings) {

        int totalBids = 0;
        for (AuctionPlayer outstandingPlayer : outstandingPlayers) {
            totalBids += outstandingPlayer.getBid();
        }

        int openSpots = leagueSettings.getRosterSize() - outstandingPlayers.size() - 1;

        return leagueSettings.getSalaryCap() - totalBids
                - (openSpots * leagueSettings.getMinimumBid());
    }

    /**
     * Get a player currently being auctioned.
     * 
     * @param leagueId The league to get the player for.
     * @param playerId The player to get.
     * @return The player from the auction. This cannot be null.
     * @throws AuctionExpiredException if the auction has already expired.
     * @throws AuctionPlayersServiceException if the player cannot be retrieved.
     */
    private synchronized AuctionPlayer getAuctionPlayer(int leagueId, int playerId)
            throws AuctionPlayersServiceException {

        AuctionPlayer auctionPlayer = auctionPlayerDao
                .findByLeagueIdAndPlayerId(leagueId, playerId);

        if (auctionPlayer == null || checkForExpiredBid(auctionPlayer)) {
            throw new AuctionExpiredException("Auction has expired for player " + playerId);
        }

        return auctionPlayer;
    }

    /**
     * Check if an auction has expired. If it has, mark the player as won.
     * 
     * @param auctionPlayer The player to check.
     * @return True if the auction has expired, or false otherwise.
     * @throws AuctionPlayersServiceException if the player has been won and cannot be updated.
     */
    private boolean checkForExpiredBid(AuctionPlayer auctionPlayer)
            throws AuctionPlayersServiceException {

        if (System.currentTimeMillis() < auctionPlayer.getExpirationTime()) {
            return false;
        }

        updatePlayerWon(auctionPlayer);

        return true;
    }

    /**
     * Mark a player as won and remove them from the auction.
     * 
     * @param auctionPlayer The player that has been won.
     * @throws AuctionPlayersServiceException if the player cannot be updated.
     */
    private synchronized void updatePlayerWon(AuctionPlayer auctionPlayer)
            throws AuctionPlayersServiceException {

        playersWonDao.save(auctionPlayer);

        auctionPlayerDao.delete(auctionPlayer.getId());
    }
}
