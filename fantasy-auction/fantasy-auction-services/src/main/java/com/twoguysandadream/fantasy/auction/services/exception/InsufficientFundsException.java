package com.twoguysandadream.fantasy.auction.services.exception;

public class InsufficientFundsException extends AuctionPlayersServiceException {

	public InsufficientFundsException(int maxBid, int attemptedBid) {
		super("Bid ($" + attemptedBid + ") is greated than maximum allowable bid of " + maxBid);
	}

}
