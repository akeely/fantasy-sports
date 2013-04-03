package com.twoguysandadream.fantasy.auction.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twoguysandadream.fantasy.auction.model.Player;
import com.twoguysandadream.fantasy.auction.model.Sports;

/**
 * Access metadata relating to players.
 * 
 * @author akeely
 */
@Repository
public interface PlayerDao extends CrudRepository<Player, Integer> {

    
	public List<Player> findBySportAndActiveAndPlayerIdNotIn(Sports sport, boolean isActive, List<Integer> playerIds);
	
}
