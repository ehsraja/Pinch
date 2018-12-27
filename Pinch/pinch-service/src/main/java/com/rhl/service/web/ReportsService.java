package com.rhl.service.web;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhl.model.Report;
import com.rhl.service.ReportService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ReportsService {
	
	@Autowired
	private ReportService reportService ; 
	
	@RequestMapping("/list")
	public List<Report> reportService() {
		List<Report> report = new LinkedList<Report>();
		Report report1 = new Report("RCS-Ticker-Calculation");
		Report report2 = new Report("RCS-Trade-Calculation");
		report.add(report1);
		report.add(report2);
		
		return report ;
	}

}
