/**
 * 
 */
package com.ronaldo.xyinc.service.exception;

/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
public class CoordinateInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CoordinateInvalidException(String message) {
		super(message);
	}
	
	public CoordinateInvalidException(String message, Throwable cases) {
		super(message, cases);
	}
}
