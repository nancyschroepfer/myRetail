package com.myretail.myretail_restful_service.data;

public class DataException extends Exception {

	public DataException (String message, Exception exception) {
		super(message, exception);
	}
	
	public DataException (String message) {
		super(message);
	}
}
