/**
 * 
 */
package com.ronaldo.xyinc.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ronaldo.xyinc.model.DetailError;
import com.ronaldo.xyinc.service.exception.CoordinateInvalidException;


/**
 * @author Ronaldo L. Vieira
 *
 * 17 de dez de 2017
 */
@ControllerAdvice
public class XyIncExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){		
		List<Error> errors = createListErrors(ex.getBindingResult());		
		return  handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	/*TRATA EX - DADOS NAO ENCONTRADOS*/
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		String message = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
		List<Error> erros = Arrays.asList(new Error(message));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(CoordinateInvalidException.class)
	public ResponseEntity<DetailError> handleCoordinateInvalidException
							(CoordinateInvalidException e, HttpServletRequest request) {		
		DetailError erro = new DetailError();
		erro.setStatus(403l);
		erro.setMessage(messageSource.getMessage("coordinate-invalid", null, LocaleContextHolder.getLocale()));
		erro.setTimestamp(System.currentTimeMillis());		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}
	
	private List<Error> createListErrors(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();
        
        for(FieldError fieldError : bindingResult.getFieldErrors()) {
        	String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
        	errors.add(new Error(message));
        }
		return errors;
	}
	
	public static class Error {

		private String message;

		public Error(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

	}

}
