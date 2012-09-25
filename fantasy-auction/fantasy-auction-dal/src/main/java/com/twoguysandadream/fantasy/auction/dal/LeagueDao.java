/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twoguysandadream.fantasy.auction.model.League;

/**
 * Access information about leagues.
 * 
 * @author akeely
 */
@Repository
public interface LeagueDao extends CrudRepository<League, Integer> {
    
    /**
     * Not implementation needed - use {@link CrudRepository} methods. 
     */
}
