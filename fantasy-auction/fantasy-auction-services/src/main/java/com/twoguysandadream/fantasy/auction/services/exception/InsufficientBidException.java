package com.twoguysandadream.fantasy.auction.services.exception;

public class InsufficientBidException extends AuctionPlayersServiceException {

	public InsufficientBidException(int currentBid, int attemptedBid) {
		super("Bid ($" + attemptedBid + ") must be greater than current leading bid of $" + currentBid);
	}


}
