/**
 * 
 */
package com.ronaldo.xyinc.model;

/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
public class DetailError {

	private Long status;
	private String message;
	private Long timestamp;
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
