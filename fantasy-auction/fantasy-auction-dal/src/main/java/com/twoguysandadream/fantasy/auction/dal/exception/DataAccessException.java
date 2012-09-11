/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal.exception;

/**
 * @author akeely
 *
 */
public class DataAccessException extends Exception {


	private static final long serialVersionUID = 8126896302617057075L;


	/**
	 * @param message
	 */
	public DataAccessException(String message) {
		super(message);
	}


	/**
	 * @param message
	 * @param cause
	 */
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
