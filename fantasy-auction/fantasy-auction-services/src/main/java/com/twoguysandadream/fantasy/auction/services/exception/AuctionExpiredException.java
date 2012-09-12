package com.twoguysandadream.fantasy.auction.services.exception;

public class AuctionExpiredException extends AuctionPlayersServiceException {

	private static final long serialVersionUID = 2756047583800004485L;

	public AuctionExpiredException(String message) {
		super(message);
	}

	public AuctionExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

}
