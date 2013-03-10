/**
 * 
 */
package com.twoguysandadream.fantasy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.twoguysandadream.fantasy.auction.services.exception.AuctionPlayersServiceException;


/**
 * @author andrew_keely
 *
 */
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AuctionPlayersServiceException.class)
	public @ResponseBody ResponseEntity<String> handleServiceException(AuctionPlayersServiceException e, WebRequest webRequest) {
		
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
