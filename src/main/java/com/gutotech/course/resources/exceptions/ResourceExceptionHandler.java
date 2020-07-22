package com.gutotech.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gutotech.course.services.DatabaseException;
import com.gutotech.course.services.exceptions.ResourceNotFoundExeception;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExeception.class)
	public ResponseEntity<StandardError> resourceNotFound(
			ResourceNotFoundExeception e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError standardError = new StandardError(
				Instant.now(), status.value(), error, 
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(
			DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;

		StandardError standardError = new StandardError(
				Instant.now(), status.value(), error, 
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
}
