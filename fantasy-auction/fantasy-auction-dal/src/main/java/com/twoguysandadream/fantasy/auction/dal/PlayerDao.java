package com.twoguysandadream.fantasy.auction.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twoguysandadream.fantasy.auction.model.Player;

/**
 * Access metadata relating to players.
 * 
 * @author akeely
 */
@Repository
public interface PlayerDao extends CrudRepository<Player, Integer> {

    /**
     * Not implementation needed - use {@link CrudRepository} methods.
     */
}
