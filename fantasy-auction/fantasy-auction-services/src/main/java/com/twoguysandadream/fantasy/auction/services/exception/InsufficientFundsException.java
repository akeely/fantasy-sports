package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An error indicating the bid cannot be submitted because the team does not have enough money
 * remaining.
 * 
 * @author akeely
 * 
 */
public class InsufficientFundsException extends AuctionPlayersServiceException {

    /** Generated UID. */
    private static final long serialVersionUID = 4105343532491720079L;

    /**
     * @see AuctionPlayersServiceException#AuctionPlayersServiceException(String)
     * 
     * @param maxBid
     *            The maximum bid the team can make.
     * @param attemptedBid
     *            The attempted bid by the team.
     */
    public InsufficientFundsException(int maxBid, int attemptedBid) {

        super("Bid ($" + attemptedBid + ") is greated than maximum allowable bid of " + maxBid);
    }

}
