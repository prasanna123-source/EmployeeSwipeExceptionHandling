package com.prasanna.demo.ExceptionHandler;

import java.util.List;

public class ErrorResponse {
	String errorcode;
	List<String> errormessage;
	public ErrorResponse(String errorcode, List<String> details) {	
		this.errorcode = errorcode;
		this.errormessage = details;
	}

}
