package com.twoguysandadream.fantasy.auction.dal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;
import com.twoguysandadream.fantasy.auction.model.League;
import com.twoguysandadream.fantasy.auction.model.Player;
import com.twoguysandadream.fantasy.auction.model.PlayerWon;
import com.twoguysandadream.fantasy.auction.model.Sports;
import com.twoguysandadream.fantasy.auction.model.Team;

@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("prod")
@ContextConfiguration("file:src/main/resources/auction-dal_context.xml")
public class MySqlConnectionTest {

    private static final int PLAYER_ID = 1;
    private static final String NAME = "Erik Woulfe";
    
    @Autowired
    private PlayerDao playerDao;
    
    @Autowired
    private LeagueDao leagueDao;
    
    @Autowired
    private PlayersWonDao playersWonDao;
    
    @Autowired
    private TeamDao teamDao;
    
    @Test
    public void testConnection() {
    	
        Player player = playerDao.findOne(PLAYER_ID);
        assertNotNull("Player should not be null.", player);
        assertEquals("Unexpected name of player with ID " + PLAYER_ID, NAME, player.getName());
        
        assertEquals("Unexpected sport for player with ID " + PLAYER_ID, Sports.BASEBALL, player.getSport());
    }
    
    @Test
    public void testPlayerWon() {
    	
    	PlayerWon player = playersWonDao.findByLeagueIdAndPlayerId(0, PLAYER_ID);
    	
    	assertNotNull("PlayerWon should not be null", player);
    	assertEquals("Unexpected name of player", NAME, player.getPlayer().getName());
    }
    
    @Test
    public void testLeague() {
    	
    	League league = leagueDao.findOne(0);
    	
    	assertNotNull(league);
    	assertEquals("Unit Test League", league.getName());
    }

    @Test
    public void testTeam() {
    	
    	Team team = teamDao.findOne(1);
    	
    	assertNotNull(team);
    	assertEquals("Salt Bandits", team.getTeamName());
    	assertEquals("Unit Test League", team.getLeague().getName());
    }
}
