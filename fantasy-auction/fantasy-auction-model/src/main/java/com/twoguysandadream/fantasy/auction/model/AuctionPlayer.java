package com.twoguysandadream.fantasy.auction.model;

/**
 * A player that is currently being auctioned.
 * 
 * @author akeely
 */
public class AuctionPlayer {

	/** The unique identifier for the player being auctioned. */
	private int playerId;
	/** The league that the player is being auctioned in. */
	private int leagueId;
	/** The fantasy team that is leading the bidding. */
	private String team;
	/** The time that the auction expires. */
	private String expirationTime;
	/** The current leading bid on the player. */
	private int bid;
	/** The full details of the player being auctioned. */
	private Player player;
	
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
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * @return the expirationTime
	 */
	public String getExpirationTime() {
		return expirationTime;
	}
	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(String expirationTime) {
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
