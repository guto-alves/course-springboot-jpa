package com.gutotech.course.services.exceptions;

public class ResourceNotFoundExeception extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExeception(Object id) {
		super("Resource not found. Id: " + id);
	}
}
