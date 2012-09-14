package com.twoguysandadream.fantasy.auction.model;

/**
 * The sports that are supported.
 * 
 * @author akeely
 */
public enum Sports {

    /** Baseball */
    BASEBALL("baseball"),
    /** Football */
    FOOTBALL("football");

    /** A string representing the sport. */
    private final String value;

    /**
     * Private c-tor to associate a string with the sport.
     * 
     * @param value The string associated with the sport.
     */
    private Sports(String value) {

        this.value = value;
    }

    /**
     * Get the string associated with the sport.
     * 
     * @return The string associated with the sport.
     */
    public String getValue() {

        return value;
    }
}
