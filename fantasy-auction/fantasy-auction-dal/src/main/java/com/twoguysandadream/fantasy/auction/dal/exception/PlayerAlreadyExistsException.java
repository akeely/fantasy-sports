/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal.exception;

/**
 * @author akeely
 *
 */
public class PlayerAlreadyExistsException extends DataAccessException {

	/**
	 * @param message
	 */
	public PlayerAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PlayerAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
