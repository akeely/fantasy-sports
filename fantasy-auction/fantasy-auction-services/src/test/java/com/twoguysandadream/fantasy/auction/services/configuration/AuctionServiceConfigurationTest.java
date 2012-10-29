/**
 * 
 */
package com.twoguysandadream.fantasy.auction.services.configuration;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.twoguysandadream.fantasy.auction.services.AuctionPlayersService;
import com.twoguysandadream.fantasy.auction.services.AuctionPlayersServiceImpl;

/**
 * @author akeely
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/auction-services_context.xml")
@DirtiesContext
public class AuctionServiceConfigurationTest {

	@Autowired
	AuctionPlayersServiceImpl auctionPlayersService;
	
	@Test
	public void test() {
		assertNotNull(auctionPlayersService);
		assertTrue(auctionPlayersService instanceof AuctionPlayersServiceImpl);
	}

}
