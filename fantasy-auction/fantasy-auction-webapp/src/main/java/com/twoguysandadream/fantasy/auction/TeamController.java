package com.twoguysandadream.fantasy.auction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoguysandadream.fantasy.auction.model.Team;
import com.twoguysandadream.fantasy.auction.services.FantasyTeamService;

@Controller
public class TeamController {

	@Autowired
	private FantasyTeamService fantasyTeamService;
	
	@RequestMapping(value="team", method=RequestMethod.GET)
	public @ResponseBody List<Team> getTeams() {
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(user == null) {
			throw new IllegalStateException("No user available to retrieve teams.");
		}
		
		return fantasyTeamService.getTeamsByUser(user.getUsername());
	}
	
	@RequestMapping(value="/league/{leagueId}/team", method=RequestMethod.GET)
	public @ResponseBody List<Team> getTeamsByLeague(@PathVariable int leagueId) {
		
		return fantasyTeamService.getTeamsByLeague(leagueId);
	}
}
