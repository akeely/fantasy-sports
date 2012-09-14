/**
 * 
 */
package com.twoguysandadream.fantasy.auction.model;

/**
 * Metadata relating to a player.
 * 
 * @author akeely
 */
public class Player {

    /** The unique identifier of the player. */
    private int id;
    /** The full name of the player. */
    private String name;
    /** The sport that the player plays. */
    private Sports sport;
    /** The position(s) that the player plays. */
    private String position;
    /** The team that the player plays for. */
    private String team;
    /** The rank of the player. */
    private int rank;
    /** Whether the player is still active. */
    private boolean active;
    /** The player's rank according to Yahoo. */
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
