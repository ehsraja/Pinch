package com.rhl.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Report implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String name ;
	private List<String> header = new ArrayList<String>();
	private List<Map<String,Object>> rowList = new ArrayList <Map<String,Object>> (); ; 
	
	
	private Report (ReportBuilder builder) {
		this.name = builder.name ;
		this.header = builder.header ;
		
	}
	
	private Report () {
	}

	
	public static class ReportBuilder {
		String name ;
		List<String> header = new ArrayList<String>();
		
		public ReportBuilder (String name) {
			this.name = name ;
		//	return this ;
		}
		
		public ReportBuilder with(String ...headers) {
			for(String headerstr : headers) {
				this.header.add(headerstr);
			}
			return this ;
		}
		
		public ReportBuilder withHeader(List <String> header ) {
			this.header = header ;
			return this ;
		}
		
		public Report build () {
			return new Report (this);
		}
		
	}
	
	public Report(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void addRow(Map<String,Object> row) {
    	this.rowList.add(row);
    }
    
    public List<String> getheader (){
    	return header ;
    }
	
    public List<Map<String,Object>>  getAllRows (){
    	return  rowList;
    }
    

}
