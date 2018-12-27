package com.rhl.pinch.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.rhl.model.Report;

public class ReportManger  {
	
	Report report ;
	
	public ReportManger (Report report) {
		this.report = report ;
		this.addReport(this.report);
	}
	
	public ReportManger () {
	
	}

	public  void addReport(String ReportName, Object... obj) {
	//	this.reportName = ReportName ;
		List<Object> objHeader = Arrays.asList(obj);
		List<String> stringsheader = objHeader.stream().map(object -> Objects.toString(object, null))
				   .collect(Collectors.toList());
	
		HttpHelper.addNewReport(ReportName, stringsheader);
	}
	
	public  void addReport(Report report) {
		HttpHelper.addNewReport(report);
	}
	
	public void capture( Object... obj) {
		Map <String,Object> reportValues = new HashMap <String,Object>();
		int index = 0 ;
	   for(String headerStr :report.getheader() ) {
		   reportValues.put(headerStr, obj[index++]);
	   }
	//	report.addRow(reportValues);
		
	   HttpHelper.publishReport(this.report, reportValues);
	}

	public void capture(Report report, Object... obj) {
		Map <String,Object> reportValues = new HashMap <String,Object>();
		int index = 0 ;
	   for(String headerStr :report.getheader() ) {
		   reportValues.put(headerStr, String.valueOf(obj[index++]));
	   }
	   HttpHelper.publishReport(this.report, reportValues);
	}

}
