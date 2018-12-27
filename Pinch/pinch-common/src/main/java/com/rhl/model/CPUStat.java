package com.rhl.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class CPUStat implements Serializable{
	
	
	
	double appCPU ;
	double systemCpu ;
	String timeCatureed ;
	
	
	public CPUStat(double appCPU, double systemCpu, String timecatureed) {
		super();
		this.appCPU = appCPU;
		this.systemCpu = systemCpu;
		this.timeCatureed = timecatureed;
	}
	public double getAppCPU() {
		return appCPU;
	}
	public void setAppCPU(double appCPU) {
		this.appCPU = appCPU;
	}
	public double getSystemCpu() {
		return systemCpu;
	}
	public void setSystemCpu(double systemCpu) {
		this.systemCpu = systemCpu;
	}
	public String getTimeCatureed() {
		return timeCatureed;
	}
	public void setTimeCatureed(String timecatureed) {
		this.timeCatureed = timecatureed;
	}

}
