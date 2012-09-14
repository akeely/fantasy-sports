/**
 * 
 */
package com.twoguysandadream.fantasy.auction.dal.exception;

/**
 * General exception for all DAL errors.
 * 
 * @author akeely
 */
public class DataAccessException extends Exception {

    /** Generated UID. */
    private static final long serialVersionUID = 8126896302617057075L;

    /**
     * @see Exception#Exception(String)
     */
    public DataAccessException(String message) {

        super(message);
    }

    /**
     * @see Exception#Exception(String, Throwable)
     */
    public DataAccessException(String message, Throwable cause) {

        super(message, cause);
    }

}
