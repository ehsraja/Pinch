package com.rhl.pinch.client.statsmonitor;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhl.model.AppStats;

public class StateMonitor {
	
	private String serviceName;
	private int delaySeconds ; 
	private boolean sendsUpdate ;
	private StatsSender statsSender ;
	private String serverAddress ; 
	
	public StateMonitor(String serviceName) {
		
		this(serviceName,30,true,"localhost");
	}
	
	
public StateMonitor(String serviceName,String serverAddress) {
		
		this(serviceName,30,true,serverAddress);
	}
	
	public StateMonitor(String serviceName, int delaySeconds,String address) {
		this(serviceName,delaySeconds,true,address);
	}

	
	public StateMonitor(String serviceName, int delaySeconds, boolean sendsUpdate,String address) {
		super();
		this.serviceName = serviceName;
		this.delaySeconds = delaySeconds;
		this.sendsUpdate = sendsUpdate;
		this.statsSender = new StatsSender(serviceName,address);
		this.serverAddress = address ;
	}	
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getDelaySeconds() {
		return delaySeconds;
	}

	public void setDelaySeconds(int delaySeconds) {
		this.delaySeconds = delaySeconds;
	}

	public boolean isSendsUpdate() {
		return sendsUpdate;
	}

	public void setSendsUpdate(boolean sendsUpdate) {
		this.sendsUpdate = sendsUpdate;
	}


	

//	@Inject
//	StatsSender statsSender = new StatsSender(serviceName);
	ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
	
	public void start(){
		
		 scheduledThreadPool.scheduleAtFixedRate(statsSender, 1, 5, TimeUnit.SECONDS);
	
	}

}
