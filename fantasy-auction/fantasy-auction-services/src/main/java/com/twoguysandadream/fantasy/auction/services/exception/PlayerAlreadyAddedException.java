/**
 * 
 */
package com.twoguysandadream.fantasy.auction.services.exception;

/**
 * @author akeely
 *
 */
public class PlayerAlreadyAddedException extends AuctionPlayersServiceException {

	/**
	 * @param message
	 */
	public PlayerAlreadyAddedException(int playerId) {
		super("Player " + playerId + " already exists in the auction.");
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PlayerAlreadyAddedException(int playerId, Throwable cause) {
		super("Player " + playerId + " already exists in the auction.", cause);
	}

}
