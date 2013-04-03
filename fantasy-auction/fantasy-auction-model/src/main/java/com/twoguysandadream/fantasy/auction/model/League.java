package com.twoguysandadream.fantasy.auction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The settings for a league.
 * 
 * @author akeely
 */
@Entity
public class League {

    /** A unique identifier for the league. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer leagueId;
    /** A human-readable name for the league. */
    private String name;
    /** The individual team salary cap in dollars. */
    private int salaryCap;
    /** The number of players on each team. */
    private int rosterSize;
    /** The minimum bid for a player. */
    private int minimumBid;
    /** Extend the auction if a bid is placed with less than this time remaining. */
    private long bidTimeBufferMillis;
    /** Set the auction length to this time when extending the auction. */
    private long bidTimeExtensionMillis;
    /** The initial length of the auction. */
    private long auctionLengthMillis;
    /** The sport of the league. */
    private Sports sport;
    
    /**
     * @return the leagueId
     */
    public Integer getLeagueId() {
    
        return leagueId;
    }

    
    /**
     * @param leagueId the leagueId to set
     */
    public void setLeagueId(int leagueId) {
    
        this.leagueId = leagueId;
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
     * @return the salaryCap
     */
    public int getSalaryCap() {

        return salaryCap;
    }

    /**
     * @param salaryCap the salaryCap to set
     */
    public void setSalaryCap(int salaryCap) {

        this.salaryCap = salaryCap;
    }

    /**
     * @return the rosterSize
     */
    public int getRosterSize() {

        return rosterSize;
    }

    /**
     * @param rosterSize the rosterSize to set
     */
    public void setRosterSize(int rosterSize) {

        this.rosterSize = rosterSize;
    }

    /**
     * @return the bidTimeBufferMillis
     */
    public long getBidTimeBufferMillis() {

        return bidTimeBufferMillis;
    }

    /**
     * @param bidTimeBufferMillis the bidTimeBufferMillis to set
     */
    public void setBidTimeBufferMillis(long bidTimeBufferMillis) {

        this.bidTimeBufferMillis = bidTimeBufferMillis;
    }

    /**
     * @return the bidTimeExtensionMillis
     */
    public long getBidTimeExtensionMillis() {

        return bidTimeExtensionMillis;
    }

    /**
     * @param bidTimeExtensionMillis the bidTimeExtensionMillis to set
     */
    public void setBidTimeExtensionMillis(long bidTimeExtensionMillis) {

        this.bidTimeExtensionMillis = bidTimeExtensionMillis;
    }

    /**
     * @param auctionLengthMillis the auctionLengthMillis to set
     */
    public void setAuctionLengthMillis(long auctionLengthMillis) {

        this.auctionLengthMillis = auctionLengthMillis;
    }

    /**
     * @return the auctionLengthMillis
     */
    public long getAuctionLengthMillis() {

        return auctionLengthMillis;
    }

    /**
     * @param minimumBid the minimumBid to set
     */
    public void setMinimumBid(int minimumBid) {

        this.minimumBid = minimumBid;
    }

    /**
     * @return the minimumBid
     */
    public int getMinimumBid() {

        return minimumBid;
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
}
