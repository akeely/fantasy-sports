package com.twoguysandadream.fantasy.auction;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@DirtiesContext
public class AuctionPlayersControllerConfigurationTest {

	@Configuration
	@ComponentScan("com.twoguysandadream.fantasy")
	static public class ControllerConfiguration {

	}
	
	@Autowired
	private AuctionPlayersController auctionPlayersController;
	
	@Test
	public void test() {
		assertNotNull("Failed to load AuctionPlayersController.", auctionPlayersController);
	}

}
