package com.rhl.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class AppStats  implements Serializable {
	
	private String serviceName ; 
	private long usedMemory ;
	private long totalMemory ;
	private double procesCpuUsage ;
	private double systemCpuUsage ;
	private LocalDateTime time ; 
	
	public AppStats() {
		
	}
	
	public AppStats(String serviceName, long usedMemory, long totalMemory, double procesCpuUsage, double systemCpuUsage, LocalDateTime time) {
		super();
		this.serviceName = serviceName ;
		this.usedMemory = usedMemory;
		this.totalMemory = totalMemory;
		this.procesCpuUsage = procesCpuUsage;
		this.systemCpuUsage = systemCpuUsage;
		this.time = time ;
	}
	
	
	public long getUsedMemory() {
		return usedMemory;
	}
	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}
	public long getTotalMemory() {
		return totalMemory;
	}
	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}
	public double getProcesCpuUsage() {
		return procesCpuUsage;
	}
	public void setProcesCpuUsage(double procesCpuUsage) {
		this.procesCpuUsage = procesCpuUsage;
	}
	public double getSystemCpuUsage() {
		return systemCpuUsage;
	}
	public void setSystemCpuUsage(double systemCpuUsage) {
		this.systemCpuUsage = systemCpuUsage;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public LocalDateTime getTime() {
		return time;
	}


	public void setTime(LocalDateTime time) {
		this.time = time;
	} 

}
