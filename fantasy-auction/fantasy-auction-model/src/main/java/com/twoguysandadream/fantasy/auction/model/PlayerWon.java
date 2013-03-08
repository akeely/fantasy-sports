/**
 * 
 */
package com.twoguysandadream.fantasy.auction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author andrew_keely
 *
 */
@Entity
public class PlayerWon {

	/** A unique identifier for this player. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/** The unique identifier for the player that was won. */
	private int playerId;
	/** The league that the player was won in. */
	private int leagueId;
	/** The fantasy team that won the bidding. */
	private int teamId;
	/** The time that the auction expired. */
	private long expirationTime;
	/** The cost of the player. */
	private int cost;
	/** The full details of the player being auctioned. */
	@ManyToOne
	@JoinColumn(name = "playerId", insertable = false, updatable = false)
	private Player player;
	
	
	public PlayerWon() {
		
	}
	
	public PlayerWon(AuctionPlayer auctionPlayer) {
		
		playerId=auctionPlayer.getPlayerId();
		leagueId=auctionPlayer.getLeagueId();
		teamId=auctionPlayer.getTeamId();
		expirationTime=auctionPlayer.getExpirationTime();
		cost=auctionPlayer.getBid();
		player=auctionPlayer.getPlayer();
	}
	
	public PlayerWon(int playerId, int leagueId, int teamId, long expirationTime, int cost, Player player) {
		
		this.playerId=playerId;
		this.leagueId=leagueId;
		this.teamId=teamId;
		this.expirationTime=expirationTime;
		this.cost=cost;
		this.player=player;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
	
	    return id;
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @return the leagueId
	 */
	public int getLeagueId() {
		return leagueId;
	}

	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @return the expirationTime
	 */
	public long getExpirationTime() {
		return expirationTime;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
}
