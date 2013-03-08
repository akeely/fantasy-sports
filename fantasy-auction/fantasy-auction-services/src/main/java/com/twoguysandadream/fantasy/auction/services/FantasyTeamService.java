package com.twoguysandadream.fantasy.auction.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	public List<Team> getTeamsByUser(String username) {
		
		FantasyUserDetails user = userDetailsDao.findByUserName(username);
		
		if(user == null) {
			throw new IllegalStateException("No user associated with username " + username);
		}
		
		return teamDao.findByUserId(user.getUserId());
	}
}
