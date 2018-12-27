package com.rhl.model;

import java.io.Serializable;
import java.time.LocalDateTime;


public class MemoryStat implements Serializable {
	
	long totalmemory ;
	double freeMemory ;
    String timeCatureed ;
    
    public MemoryStat() {
    	
    }
	
	public MemoryStat(long totalmemory, double freeMemory, String timeCatureed) {
		super();
		this.totalmemory = totalmemory;
		this.freeMemory = freeMemory;
		this.timeCatureed = timeCatureed;
	}

	public long getTotalmemory() {
		return totalmemory;
	}

	public void setTotalmemory(long totalmemory) {
		this.totalmemory = totalmemory;
	}

	public double getFreeMemory() {
		return freeMemory;
	}

	public void setFreeMemory(double freeMemory) {
		this.freeMemory = freeMemory;
	}

	public String getTimeCatureed() {
		return timeCatureed;
	}

	public void setTimeCatureed(String timeCatureed) {
		this.timeCatureed = timeCatureed;
	}

}
