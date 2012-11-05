/**
 * 
 */
package com.twoguysandadream.fantasy.auction.model;

import javax.persistence.Entity;

/**
 * @author andrew_keely
 *
 */
@Entity
public class PlayerWon extends AbstractAuctionPlayer {

	public PlayerWon() {
		super();
	}
	
	public PlayerWon(AbstractAuctionPlayer player) {
		super(player);
	}
}
