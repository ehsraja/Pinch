package com.rhl.pinch.client.statsmonitor;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import com.rhl.model.AppStats;



@Resource
public class StatsCapture  {
	
	private String serviceName ; 
	int mb = 1024*1024;
	
	public StatsCapture(String serviceName ) {
		this.serviceName = serviceName ;
	}
	
	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public AppStats capture () {
		Runtime runtime = Runtime.getRuntime();
		 double processCPU =0 , systemCPU = 0 ;
		
		//  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		 
		 OperatingSystemMXBean operatingSystemMXBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
		            .getOperatingSystemMXBean();
			
		 Method method;
		 
		try {
			
			  
			  method = operatingSystemMXBean.getClass().getMethod("getSystemCpuLoad");
				 method.setAccessible(true);
				   systemCPU =  (Double) method.invoke(operatingSystemMXBean) *100; 
				   
				   method = operatingSystemMXBean.getClass().getMethod("getProcessCpuLoad");
					 method.setAccessible(true);
					   processCPU =  ( (Double) method.invoke(operatingSystemMXBean)) * 100; 
			  
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long TotaMemory = runtime.totalMemory() / mb ;
		long usedMeomry =  TotaMemory - (runtime.freeMemory()/mb) ;
	//	String serviceName = System.getProperty("serviceName","ABC");
		System.out.println("service name :" + this.serviceName );
		AppStats appStats = new AppStats(serviceName,usedMeomry, TotaMemory,processCPU,systemCPU,LocalDateTime.now());
		return appStats ;
	}

}
