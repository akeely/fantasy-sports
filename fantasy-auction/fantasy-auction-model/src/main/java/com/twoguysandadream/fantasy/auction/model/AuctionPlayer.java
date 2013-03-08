package com.twoguysandadream.fantasy.auction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * A player that is currently being auctioned.
 * 
 * @author akeely
 */
@Entity
public class AuctionPlayer {
	
	/** A unique identifier for this player. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/** The unique identifier for the player being auctioned. */
	private int playerId;
	/** The league that the player is being auctioned in. */
	private int leagueId;
	/** The fantasy team that is leading the bidding. */
	private int teamId;
	/** The time that the auction expires. */
	private long expirationTime;
	/** The current leading bid on the player. */
	private int bid;
	/** The full details of the player being auctioned. */
	@ManyToOne
	@JoinColumn(name = "playerId", insertable = false, updatable = false)
	private Player player;
	/** The full details of the team leading the bidding. */
	@ManyToOne
	@JoinColumn(name = "teamId", insertable = false, updatable = false)
	private Team team;
	
	public PlayerWon toPlayerWon() {
		return new PlayerWon(this);
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
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(int playerId) {
	
	    this.playerId = playerId;
	}

	/**
	 * @return the leagueId
	 */
	public int getLeagueId() {
	
	    return leagueId;
	}

	/**
	 * @param leagueId the leagueId to set
	 */
	public void setLeagueId(int leagueId) {
	
	    this.leagueId = leagueId;
	}

	/**
	 * @return the teamId
	 */
	public int getTeamId() {
	
	    return teamId;
	}

	/**
	 * @param teamId the team to set
	 */
	public void setTeamId(int teamId) {
	
	    this.teamId = teamId;
	}

	/**
	 * @return the expirationTime
	 */
	public long getExpirationTime() {
	
	    return expirationTime;
	}

	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(long expirationTime) {
	
	    this.expirationTime = expirationTime;
	}

	/**
	 * @return the bid
	 */
	public int getBid() {
	
	    return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(int bid) {
	
	    this.bid = bid;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
	
	    return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
	
	    this.player = player;
	}
}
