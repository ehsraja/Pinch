package com.rhl.model;

import java.util.LinkedList;
import java.util.List;

public class AppService {
	
	private String serviceName ; 	
	private List <String> header ;
	private List <List<Object>> Content ;
	
	
	public AppService(String serviceName) {
		super();
		this.serviceName = serviceName;
		this.Content = new LinkedList<List<Object>>();
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public List<String> getHeader() {
		return header;
	}


	public void setHeader(List<String> header) {
		this.header = header;
	}


	public List<List<Object>> getContent() {
		return Content;
	}


	public void setContent(List<List<Object>> content) {
		Content = content;
	}
	
	public void addcontent(List<Object> obj) {
		Content.add(obj);
	}

}
