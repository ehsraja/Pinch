package com.rhl.utility;

import java.io.Serializable;

public class AgGridHeader implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String headerName ; 
	private final String field ;
	
	private  AgGridHeader(String headerName, String field) {
		this.headerName = headerName;
		this.field = field;
	}

	
	
    public static AgGridHeader buildHeader(String header) {
    	return new AgGridHeader(header,header);
    	
    }



	public String getHeaderName() {
		return headerName;
	}



	public String getField() {
		return field;
	}
	

}
