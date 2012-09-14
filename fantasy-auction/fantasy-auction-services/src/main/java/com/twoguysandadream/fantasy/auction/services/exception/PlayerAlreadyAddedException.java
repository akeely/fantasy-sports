package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An error that a player cannot be added because the player had already been added.
 * 
 * @author akeely
 */
public class PlayerAlreadyAddedException extends AuctionPlayersServiceException {

    /** Generated UID. */
    private static final long serialVersionUID = 7197557744843046351L;

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String)
     * 
     * @param playerId
     *            The player that cannot be added.
     */
    public PlayerAlreadyAddedException(int playerId) {

        super("Player " + playerId + " already exists in the auction.");
    }

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String, Throwable)
     * 
     * @param playerId
     *            The player that cannot be added.
     * @param cause
     *            The cause of the error.
     */
    public PlayerAlreadyAddedException(int playerId, Throwable cause) {

        super("Player " + playerId + " already exists in the auction.", cause);
    }

}
