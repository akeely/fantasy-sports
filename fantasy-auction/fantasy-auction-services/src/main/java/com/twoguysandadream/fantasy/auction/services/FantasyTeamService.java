package com.twoguysandadream.fantasy.auction.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.twoguysandadream.fantasy.auction.dal.PlayersWonDao;
import com.twoguysandadream.fantasy.auction.dal.TeamDao;
import com.twoguysandadream.fantasy.auction.model.Team;
import com.twoguysandadream.fantasy.users.dal.FantasyUserDetailsDao;
import com.twoguysandadream.fantasy.users.model.FantasyUserDetails;

@Component
public class FantasyTeamService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private FantasyUserDetailsDao userDetailsDao;
	@Autowired
	private PlayersWonDao playersWonDao;
	
	/*
	@Inject
	public FantasyTeamService(TeamDao teamDao, FantasyUserDetailsDao fantasyUserDetailsDao) {
		
		this.teamDao = teamDao;
		this.userDetailsDao = fantasyUserDetailsDao;
	}
	*/
	
	public List<Team> getTeamsByUser(String username) {
		
		FantasyUserDetails user = userDetailsDao.findByUserName(username);
		
		if(user == null) {
			throw new IllegalStateException("No user associated with username " + username);
		}
		
		return teamDao.findByUserId(user.getUserId());
	}
	
	@Transactional
	public List<Team> getTeamsByLeague(int leagueId) {
		
		List<Team> teams = teamDao.findByLeagueId(leagueId);
		for(Team team : teams) {
			team.setPlayersWon(playersWonDao.findByTeamId(team.getTeamId()));
		}
		return teams;
	}
}
