package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An error that a player cannot be added because the player has already been won.
 * 
 * @author akeely
 */
public class PlayerAlreadyWonException extends AuctionPlayersServiceException {

    /** Generated UID. */
    private static final long serialVersionUID = 7694892099327938047L;

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String)
     */
    public PlayerAlreadyWonException(String message) {

        super(message);
    }

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String, Throwable)
     */
    public PlayerAlreadyWonException(String message, Throwable cause) {

        super(message, cause);
    }

}
