package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An error condition if a bid cannot be submitted because the team's roster is full.
 * 
 * @author akeely
 */
public class RosterFullException extends AuctionPlayersServiceException {

    /** Generated UID. */
    private static final long serialVersionUID = 926744991326434209L;

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String)
     */
    public RosterFullException(String message) {

        super(message);
    }

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String, Throwable)
     */
    public RosterFullException(String message, Throwable cause) {

        super(message, cause);
    }

}
