/**
 * 
 */
package com.twoguysandadream.fantasy.auction.model;

/**
 * 
 * 
 * @author akeely
 */
public class Player {

	
	private int id;
	private String name;
	private Sports sport;
	private String position;
	private String team;
	private int rank;
	private boolean active;
	private int yahooRank;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the sport
	 */
	public Sports getSport() {
		return sport;
	}
	/**
	 * @param sport the sport to set
	 */
	public void setSport(Sports sport) {
		this.sport = sport;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
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
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the yahooRank
	 */
	public int getYahooRank() {
		return yahooRank;
	}
	/**
	 * @param yahooRank the yahooRank to set
	 */
	public void setYahooRank(int yahooRank) {
		this.yahooRank = yahooRank;
	}
}
