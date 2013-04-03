package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * An error condition when a team tries to add a player to the auction, but does not have adds available.
 * @author andrew_keely
 *
 */
public class NoAddsAvailableException extends AuctionPlayersServiceException {

	/** Generated UID. */
	private static final long serialVersionUID = 736886763288643133L;

	public NoAddsAvailableException(String message) {
		super(message);
	}

}
