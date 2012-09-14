/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal.exception;

/**
 * An error to indicate that a player cannot be added to the auction because the player is already
 * in the auction.
 * 
 * @author akeely
 */
public class PlayerAlreadyExistsException extends DataAccessException {

    /** Generated UID. */
    private static final long serialVersionUID = 6567062164229730524L;

    /**
     * @see DataAccessException#DataAccessException(String)
     */
    public PlayerAlreadyExistsException(String message) {

        super(message);
    }

    /**
     * @see DataAccessException#DataAccessException(String, Throwable)
     */
    public PlayerAlreadyExistsException(String message, Throwable cause) {

        super(message, cause);
    }

}
