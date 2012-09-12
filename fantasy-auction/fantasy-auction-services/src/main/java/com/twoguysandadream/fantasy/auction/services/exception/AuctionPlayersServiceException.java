package com.twoguysandadream.fantasy.auction.services.exception;

public class AuctionPlayersServiceException extends Exception {

	private static final long serialVersionUID = 8406893194290382525L;

	public AuctionPlayersServiceException(String message) {

		super(message);
	}


	public AuctionPlayersServiceException(String message, Throwable cause) {
		
		super(message, cause);
	}

}
