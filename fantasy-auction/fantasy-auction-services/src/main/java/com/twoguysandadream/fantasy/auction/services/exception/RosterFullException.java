package com.twoguysandadream.fantasy.auction.services.exception;

public class RosterFullException extends AuctionPlayersServiceException {

	public RosterFullException(String message) {
		super(message);
	}

	public RosterFullException(String message, Throwable cause) {
		super(message, cause);
	}

}
