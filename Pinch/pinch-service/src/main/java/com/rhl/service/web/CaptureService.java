package com.rhl.service.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhl.model.Report;
import com.rhl.service.ReportService;

//@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping("/service")
public class CaptureService {
	
	@Autowired
	private ReportService reportService ; 
	
	@RequestMapping(value="/addNewReport",method = RequestMethod.POST)
	public void addReportwithParam( @RequestBody Map<String,Object> body) {
		String reportName = body.get("reportName").toString();
		String headerJson = body.get("headers").toString();
		List<String> header = null ;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			header  = objectMapper.readValue(headerJson, new TypeReference<List<String>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		reportService.addReport(reportName,header);
	}
	
	@RequestMapping(value="/addReport",method = RequestMethod.POST)
	public void addReport( @RequestBody Report report) {
		System.out.println("report" + report.toString());				
		reportService.addReport(report);
		
	}
	
	@RequestMapping(value="/addRow",method = RequestMethod.POST )
	public void addRow( @RequestBody Map<String,Object> reqBody) {
		System.out.println("report" + reqBody.toString());		
		String reportName = reqBody.get("reportName").toString();
		final Map <String,Object> reportRow = new HashMap<String,Object> () ; 
		reqBody.forEach((k,v)-> {
			if(!k.equals(reportName))
			reportRow.put(k, v);
		});
		
		reportService.updateReport(reportName, reportRow);
		
	}
	
	
	

}
