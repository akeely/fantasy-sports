package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An error to indicate that a bid is not high enough.
 * 
 * @author akeely
 */
public class InsufficientBidException extends AuctionPlayersServiceException {

    /** Generated UID. */
    private static final long serialVersionUID = 7457067217489127358L;

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String)
     * @param currentBid The current leading bid on the player.
     * @param attemptedBid The attempted bid that is not high enough.
     */
    public InsufficientBidException(int currentBid, int attemptedBid) {

        super("Bid ($" + attemptedBid + ") must be greater than current leading bid of $"
                + currentBid);
    }

}
