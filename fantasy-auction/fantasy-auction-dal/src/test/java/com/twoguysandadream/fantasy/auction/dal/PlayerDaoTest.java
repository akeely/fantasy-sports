package com.twoguysandadream.fantasy.auction.dal;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.twoguysandadream.fantasy.auction.model.Player;
import com.twoguysandadream.fantasy.auction.model.Sports;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/auction-dal_context.xml")
public class PlayerDaoTest {

    @Autowired
    private PlayerDao playerDao;
    
    @Test
    public void testContext() {
        
        Assert.assertNotNull("Failed to load playerDao.", playerDao);
    }
    
    @Test
    public void addPlayerTest() {
        
        Player player = new Player();
        player.setId(0);
        player.setName("Test Player");
        player.setSport(Sports.BASEBALL);
        
        playerDao.save(player);
        
        Player dbPlayer = playerDao.findOne(0);
        
        assertEquals(Sports.BASEBALL, dbPlayer.getSport());
        
    }
    
    @Test
    public void getMissingPlayerTest() {
        
        assertNull(playerDao.findOne(-1));
    }
}
