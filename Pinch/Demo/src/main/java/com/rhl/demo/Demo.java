package com.rhl.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rhl.model.Report;
import com.rhl.pinch.client.ReportManger;


public class Demo {
	  
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Report report = new Report.ReportBuilder("Sample").with("Ticker","TimeIN","Timeout","timetoCompute","Num of trades").build();
			ReportManger manger = new ReportManger(report);
			 			OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
			            .getOperatingSystemMXBean();
	
	@SuppressWarnings("restriction")
	public void demoMethod(int numofTrades) throws InterruptedException {
		
		Date timeIn = new Date ();
		System.out.println("complex task ");
		Thread.sleep(4000);
		Date timeout = new Date();
		
	//	manger.capture("TURKEY",sdf.format(timeIn),sdf.format(timeout),(timeout.getTime()-timeIn.getTime()),numofTrades);
	}

}
