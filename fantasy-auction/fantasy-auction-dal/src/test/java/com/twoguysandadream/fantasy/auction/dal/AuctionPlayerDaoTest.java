package com.twoguysandadream.fantasy.auction.dal;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/auction-dal_context.xml")
//@ActiveProfiles("dev")
public class AuctionPlayerDaoTest {
    
    @Autowired
    private AuctionPlayerDao auctionPlayerDao;

    
    @Test
    public void testBean() {
        
        Assert.assertNotNull("Failed to load AuctionPlayerDao.", auctionPlayerDao);
    }

}
