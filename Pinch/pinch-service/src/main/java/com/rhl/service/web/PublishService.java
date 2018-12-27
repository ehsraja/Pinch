package com.rhl.service.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.rhl.model.AppService;
import com.rhl.model.Report;
import com.rhl.service.RegisterService;
import com.rhl.service.ReportService;
import com.rhl.utility.AgGridHeader;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reports")
public class PublishService {

	
	@Autowired
	private ReportService reportService ; 
	
		@RequestMapping("/dummuyContent/{serviceName}")
		public String getDummyHeaderContent(String serviceName) throws JSONException {
		
			List<Map <String,Object>> list = new LinkedList <Map <String,Object>>() ;
			String objectMapper = "";
			Map <String,Object> map = new HashMap <String,Object>();
			map.put("ID", 1235);
			map.put("TimeIN", "1235");
			map.put("TimeOut", "12356");
			list.add(map);
			try {
			
				 objectMapper = new ObjectMapper().writeValueAsString(list);
				log("\nMethod-3: Using ObjectMapper().writeValueAsString() ==> " + objectMapper);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		   return objectMapper ;
		
		}
		
		
		@RequestMapping("/dummyHeader")
		public List getDummyHeaders() {	
			String [] arrey =  {"ID","TimeIN","TimeOut"};
		   return Arrays.asList(arrey);
		}
		
		@RequestMapping("/headers/{reportName}")
		public List getHeaders(@PathVariable String reportName) {	
			return reportService.getReportHeader(reportName);
		}
		
		
		@RequestMapping("/header/{reportName}")
		public List <AgGridHeader> getHeader(@PathVariable String reportName) {	
			List <String> headerList =   reportService.getReportHeader(reportName);
		//	final Map <String,String> headerMap = new HashMap<String,String> ();
			List <AgGridHeader> agheader = new ArrayList <AgGridHeader>();
			headerList.forEach(str -> agheader.add(AgGridHeader.buildHeader(str)));
			return agheader ;
		}
		
		
		@RequestMapping("/content/{serviceName}")
		public List<Map<String,Object>> getContent(@PathVariable String serviceName) {
			  
			return	reportService.getReportRows(serviceName);
			
		}
		
		@RequestMapping("/list")
		public Set<String> reportService() {
		/*	List<Report> report = new LinkedList<Report>();
			Report report1 = new Report("RCS-Ticker-Calculation");
			Report report2 = new Report("RCS-Trade-Calculation");
			report.add(report1);
			report.add(report2);*/
			
			return reportService.getAllReports();
			
			
		}
		
		private static void log(Object print) {
			System.out.println(print);
	 
		}
		

	

}
