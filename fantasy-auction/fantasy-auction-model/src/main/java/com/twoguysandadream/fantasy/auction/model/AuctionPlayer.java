package com.twoguysandadream.fantasy.auction.model;

import javax.persistence.Entity;

/**
 * A player that is currently being auctioned.
 * 
 * @author akeely
 */
@Entity
public class AuctionPlayer extends AbstractAuctionPlayer {
	
	public PlayerWon toPlayerWon() {
		return new PlayerWon(this);
	}
}
