/**
 * 
 */
package com.twoguysandadream.fantasy.auction.services.configuration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.twoguysandadream.fantasy.auction.dal.AuctionPlayerDao;
import com.twoguysandadream.fantasy.auction.dal.LeagueDao;
import com.twoguysandadream.fantasy.auction.dal.PlayerDao;
import com.twoguysandadream.fantasy.auction.dal.PlayersWonDao;
import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;
import com.twoguysandadream.fantasy.auction.model.League;
import com.twoguysandadream.fantasy.auction.model.PlayerWon;
import com.twoguysandadream.fantasy.auction.services.AuctionPlayersService;
import com.twoguysandadream.fantasy.auction.services.AuctionPlayersServiceImpl;
import com.twoguysandadream.fantasy.auction.services.exception.AuctionExpiredException;
import com.twoguysandadream.fantasy.auction.services.exception.AuctionPlayersServiceException;
import com.twoguysandadream.fantasy.auction.services.exception.InsufficientBidException;
import com.twoguysandadream.fantasy.auction.services.exception.InsufficientFundsException;
import com.twoguysandadream.fantasy.auction.services.exception.PlayerAlreadyAddedException;
import com.twoguysandadream.fantasy.auction.services.exception.PlayerAlreadyWonException;
import com.twoguysandadream.fantasy.auction.services.exception.RosterFullException;

/**
 * @author andrew_keely
 *
 */
public class AuctionPlayersServiceTest {

	private static int LEAGUE_ID = 1;
	private static int PLAYER_WON_ID = 1;
	private static int PLAYER_TO_ADD_ID = 2;
	private static int PLAYER_IN_AUCTION_ID = 3;
	/** The winning bid of the player that has been won. */
	private static int PLAYER_WON_BID = 10;
	/** The current bid of the player in the auction. */
	private static int PLAYER_IN_AUCTION_BID = 10;
	/** A team that won a player and is leading bidding on a player. */
	private static int TEAM_ID = 1;
	/** A team that has not won or bid on any players. */
	private static int EMPTY_TEAM_ID = 2;
	
	@Mock
	private AuctionPlayerDao auctionPlayerDao;
	@Mock
	private PlayersWonDao playersWonDao;
	@Mock
	private LeagueDao leagueDao;
	@Mock
	private PlayerDao playerDao;
	private AuctionPlayersService auctionPlayersService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		auctionPlayersService = new AuctionPlayersServiceImpl(auctionPlayerDao, playersWonDao, leagueDao, playerDao);
		
		PlayerWon playerWon = new PlayerWon(PLAYER_WON_ID, LEAGUE_ID, TEAM_ID, 0, PLAYER_WON_BID, null);
		
		when(playersWonDao.findByLeagueIdAndPlayerId(LEAGUE_ID, PLAYER_WON_ID)).thenReturn(playerWon);
		when(playersWonDao.findByTeamId(TEAM_ID)).thenReturn(Collections.singletonList(playerWon));
		when(playersWonDao.findByTeamId(EMPTY_TEAM_ID)).thenReturn(Collections.EMPTY_LIST);
		
		League league = new League();
		league.setLeagueId(LEAGUE_ID);
		league.setRosterSize(3);
		league.setSalaryCap(25);
		
		when(leagueDao.findOne(LEAGUE_ID)).thenReturn(league);
		
		AuctionPlayer auctionPlayer = new AuctionPlayer();
		auctionPlayer.setBid(PLAYER_IN_AUCTION_BID);
		auctionPlayer.setLeagueId(LEAGUE_ID);
		auctionPlayer.setPlayerId(PLAYER_IN_AUCTION_ID);
		auctionPlayer.setTeamId(TEAM_ID);
		auctionPlayer.setExpirationTime(System.currentTimeMillis() + 10000);
		when(auctionPlayerDao.findByLeagueId(LEAGUE_ID)).thenReturn(Collections.singletonList(auctionPlayer));
		when(auctionPlayerDao.findByLeagueIdAndPlayerId(LEAGUE_ID, PLAYER_IN_AUCTION_ID)).thenReturn(auctionPlayer);
		when(auctionPlayerDao.findByTeamId(TEAM_ID)).thenReturn(Collections.singletonList(auctionPlayer));
		when(auctionPlayerDao.findByTeamId(EMPTY_TEAM_ID)).thenReturn(Collections.EMPTY_LIST);
	}

	/**
	 * Test method for {@link com.twoguysandadream.fantasy.auction.services.AuctionPlayersServiceImpl#addAuctionPlayer(int, int, int, int)}.
	 * @throws AuctionPlayersServiceException 
	 */
	@Test
	public void testAddAuctionPlayer() throws AuctionPlayersServiceException {
		
		auctionPlayersService.addAuctionPlayer(LEAGUE_ID, PLAYER_TO_ADD_ID, TEAM_ID, 1);
		verify(auctionPlayerDao).save(any(AuctionPlayer.class));
	}

	@Test(expected=PlayerAlreadyWonException.class)
	public void testAddPlayerAlreadyWon() throws AuctionPlayersServiceException {
		
		auctionPlayersService.addAuctionPlayer(LEAGUE_ID, PLAYER_WON_ID, TEAM_ID, 1);
	}
	
	@Test(expected=PlayerAlreadyAddedException.class)
	public void testAddPlayerInAuction() throws AuctionPlayersServiceException {
		
		auctionPlayersService.addAuctionPlayer(LEAGUE_ID, PLAYER_IN_AUCTION_ID, TEAM_ID, 1);
	}
	
	@Test(expected=RosterFullException.class) 
	public void testAddPlayerRosterFull() throws AuctionPlayersServiceException {
		
		League league = new League();
		league.setSalaryCap(30);
		league.setRosterSize(2);
		when(leagueDao.findOne(LEAGUE_ID)).thenReturn(league);
		
		auctionPlayersService.addAuctionPlayer(LEAGUE_ID, PLAYER_TO_ADD_ID, TEAM_ID, 1);
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void testAddPlayerOutOfMoney() throws AuctionPlayersServiceException {
		
		auctionPlayersService.addAuctionPlayer(LEAGUE_ID, PLAYER_TO_ADD_ID, TEAM_ID, 10);
	}
	
	// TODO: Test DAL exceptions?
	
	/**
	 * Test method for {@link AuctionPlayersServiceImpl#getAuctionPlayers(int)}.
	 * @throws AuctionPlayersServiceException 
	 */
	@Test
	public void testGetAuctionPlayers() throws AuctionPlayersServiceException {
		
		List<AuctionPlayer> auctionPlayers = auctionPlayersService.getAuctionPlayers(LEAGUE_ID);
		
		assertEquals("Unexpected number of players up for auction.", 1, auctionPlayers.size());
		assertEquals("Unexpected player up for auction.", PLAYER_IN_AUCTION_ID, auctionPlayers.get(0).getPlayerId());
	}

	/**
	 * Test method for {@link AuctionPlayersServiceImpl#getAuctionPlayers(int)}.
	 * @throws AuctionPlayersServiceException 
	 */
	@Test
	public void testGetAuctionPlayersPlayerWon() throws AuctionPlayersServiceException {
		
		AuctionPlayer auctionPlayer = new AuctionPlayer();
		auctionPlayer.setBid(PLAYER_IN_AUCTION_BID);
		auctionPlayer.setLeagueId(LEAGUE_ID);
		auctionPlayer.setPlayerId(PLAYER_IN_AUCTION_ID);
		auctionPlayer.setTeamId(TEAM_ID);
		auctionPlayer.setExpirationTime(System.currentTimeMillis() - 10000);
		
		when(auctionPlayerDao.findByLeagueId(LEAGUE_ID)).thenReturn(Collections.singletonList(auctionPlayer));
		
		List<AuctionPlayer> auctionPlayers = auctionPlayersService.getAuctionPlayers(LEAGUE_ID);
		
		assertEquals("Unexpected number of players up for auction.", 0, auctionPlayers.size());
		verify(playersWonDao).save(any(PlayerWon.class));
	}
	
	/**
	 * Test method for {@link AuctionPlayersServiceImpl#updateBid(int, int, int, int)}.
	 * @throws AuctionPlayersServiceException 
	 */
	@Test
	public void testUpdateBid() throws AuctionPlayersServiceException {
		
		auctionPlayersService.updateBid(LEAGUE_ID, PLAYER_IN_AUCTION_ID, TEAM_ID, 14);
		verify(auctionPlayerDao).save(any(AuctionPlayer.class));
	}

	/**
	 * Test method for {@link AuctionPlayersServiceImpl#updateBid(int, int, int, int)}.
	 * @throws AuctionPlayersServiceException 
	 */
	@Test(expected=InsufficientFundsException.class)
	public void testUpdateBidInsufficientFunds() throws AuctionPlayersServiceException {
		
		auctionPlayersService.updateBid(LEAGUE_ID, PLAYER_IN_AUCTION_ID, TEAM_ID, 15);
	}
	
	@Test(expected=InsufficientBidException.class)
	public void testUpdateInsufficientBid() throws AuctionPlayersServiceException {
		
		auctionPlayersService.updateBid(LEAGUE_ID, PLAYER_IN_AUCTION_ID, EMPTY_TEAM_ID, 1);
	}
	
	@Test(expected=AuctionExpiredException.class)
	public void testUpdateBidAlreadyWon() throws AuctionPlayersServiceException {
		
		auctionPlayersService.updateBid(LEAGUE_ID, PLAYER_WON_ID, TEAM_ID, 1);
	}
}
