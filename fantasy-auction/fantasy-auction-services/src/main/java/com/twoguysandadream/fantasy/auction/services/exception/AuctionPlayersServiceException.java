package com.twoguysandadream.fantasy.auction.services.exception;

import com.twoguysandadream.fantasy.auction.services.AuctionPlayersService;

/**
 * A General exception for all errors related to the {@link AuctionPlayersService}.
 * 
 * @author akeely
 */
public class AuctionPlayersServiceException extends Exception {

    /** Generated UID. */
    private static final long serialVersionUID = 8406893194290382525L;

    /**
     * @see Exception#Exception(String)
     */
    public AuctionPlayersServiceException(String message) {

        super(message);
    }

    /**
     * @see Exception#Exception(String, Throwable)
     */
    public AuctionPlayersServiceException(String message, Throwable cause) {

        super(message, cause);
    }

}
