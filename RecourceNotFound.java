package org.sid.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RecourceNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String resourcename ; 
	private String fieldname ; 
	private int fieldvalue ;
	
	
	public RecourceNotFound(String resourcename, String fieldname, int fieldvalue) {
		super(String.format("%s not found with %s : '%s'", resourcename , fieldname , fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public int getFieldvalue() {
		return fieldvalue;
	} 
	
	
	
}
