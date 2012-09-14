package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An {@link Exception} class to indicate that a bid cannot be submitted because the auction has
 * already completed.
 * 
 * @author akeely
 */
public class AuctionExpiredException extends AuctionPlayersServiceException {

    /** Generated UID. */
    private static final long serialVersionUID = 2756047583800004485L;

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String)
     */
    public AuctionExpiredException(String message) {

        super(message);
    }

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String, Throwable)
     */
    public AuctionExpiredException(String message, Throwable cause) {

        super(message, cause);
    }

}
