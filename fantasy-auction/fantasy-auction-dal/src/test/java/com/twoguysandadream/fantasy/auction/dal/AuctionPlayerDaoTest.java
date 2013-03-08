package com.twoguysandadream.fantasy.auction.dal;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.twoguysandadream.fantasy.auction.model.AuctionPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/auction-dal_context.xml")
@DirtiesContext
//@ActiveProfiles("dev")
public class AuctionPlayerDaoTest {
    
    @Autowired
    private AuctionPlayerDao auctionPlayerDao;

    
    @Test
    public void testBean() {
        
        Assert.assertNotNull("Failed to load AuctionPlayerDao.", auctionPlayerDao);
        
        AuctionPlayer player = new AuctionPlayer();
        player.setBid(1);
        player.setLeagueId(0);
        player.setPlayerId(0);
        player.setExpirationTime(System.currentTimeMillis()+100000);
        player.setTeamId(2);
        
        auctionPlayerDao.save(player);
    }
}
