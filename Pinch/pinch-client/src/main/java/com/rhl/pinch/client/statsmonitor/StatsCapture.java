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
	
	int mb = 1024*1024;
	
	public AppStats capture () {
		Runtime runtime = Runtime.getRuntime();
		 double processCPU =0 , systemCPU = 0 ;
		
		  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		 Method method;
		 
		try {
			method = operatingSystemMXBean.getClass().getMethod("getProcessCpuLoad");
			 method.setAccessible(true);
			   processCPU =  ( (Double) method.invoke(operatingSystemMXBean)) * 100; 
			  
			  
			  method = operatingSystemMXBean.getClass().getMethod("getSystemCpuLoad");
				 method.setAccessible(true);
				   systemCPU =  (Double) method.invoke(operatingSystemMXBean) *100; 
			  
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long TotaMemory = runtime.totalMemory() / mb ;
		long usedMeomry =  TotaMemory - (runtime.freeMemory()/mb) ;
		String serviceName = System.getProperty("serviceName","ABC");
		AppStats appStats = new AppStats("ABC",usedMeomry, TotaMemory,processCPU,systemCPU,LocalDateTime.now());
		return appStats ;
	}

}
