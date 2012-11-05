package com.twoguysandadream.fantasy.auction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractAuctionPlayer {

	/** A unique identifier for this player. */
	@Id
	private int id;
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

	public AbstractAuctionPlayer(AbstractAuctionPlayer player) {
		
		this.id=player.id;
		this.playerId=player.playerId;
		this.leagueId=player.leagueId;
		this.teamId=player.teamId;
		this.expirationTime=player.expirationTime;
		this.bid=player.bid;
		this.player=player.player;
	}

	public AbstractAuctionPlayer() {
		
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
	 * @return the id
	 */
	public int getId() {
	
	    return id;
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