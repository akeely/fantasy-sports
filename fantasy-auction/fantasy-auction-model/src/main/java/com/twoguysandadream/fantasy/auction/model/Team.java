package com.twoguysandadream.fantasy.auction.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {

	/** A unique identifier for this team. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer teamId;
	/** The team name. */
	private String teamName;
	/** The league that the team is in. */
	private int leagueId;
	/** The owner of the team. */
	private int userId;
	/** The number of players the team can add to the auction. */
	private int adds;
	/** The roster of the team. */
	@Transient
	private List<PlayerWon> playersWon = new ArrayList<PlayerWon>();
	
	/**
	 * @return the teamId
	 */
	public Integer getTeamId() {
		return teamId;
	}
	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the adds
	 */
	public int getAdds() {
		return adds;
	}
	/**
	 * @param adds the adds to set
	 */
	public void setAdds(int adds) {
		this.adds = adds;
	}
	/**
	 * @return the playersWon
	 */
	public List<PlayerWon> getPlayersWon() {
		return playersWon;
	}
	/**
	 * @param playersWon the playersWon to set
	 */
	public void setPlayersWon(List<PlayerWon> playersWon) {
		this.playersWon = playersWon;
	}	
}
