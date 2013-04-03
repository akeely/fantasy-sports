/**
 * 
 */
package com.twoguysandadream.fantasy.auction.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.twoguysandadream.fantasy.auction.dal.TeamDao;
import com.twoguysandadream.fantasy.auction.model.Team;
import com.twoguysandadream.fantasy.users.dal.FantasyUserDetailsDao;

/**
 * Test suite for {@link FantasyTeamService}.
 * 
 * @author andrew_keely
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/auction-services_context.xml")
@DirtiesContext
public class FantasyTeamServiceTest {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private FantasyUserDetailsDao userDetailsDao;
	/** The service under test. */
	private FantasyTeamService fantasyTeamService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		
		fantasyTeamService = new FantasyTeamService(teamDao, userDetailsDao);
	}

	/**
	 * Test method for {@link FantasyTeamService#getTeamsByUser(java.lang.String)}.
	 */
	@Test
	public void testGetTeamsByUser() {
		
		List<Team> teams = fantasyTeamService.getTeamsByUser("");
		assertEquals(0,teams.size());
	}

	/**
	 * Test method for {@link com.twoguysandadream.fantasy.auction.services.FantasyTeamService#getTeamsByLeague(int)}.
	 */
	@Test
	public void testGetTeamsByLeague() {
		
		List<Team> teams = fantasyTeamService.getTeamsByLeague(0);
		assertEquals(1,teams.size());
	}

}
