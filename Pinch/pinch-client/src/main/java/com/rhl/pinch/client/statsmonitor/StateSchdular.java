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

public class StateSchdular {
	
	

	@Inject
	StatsSender statCature = new StatsSender();
	ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
	
	public void start(){
		
		 scheduledThreadPool.scheduleAtFixedRate(statCature, 1, 30, TimeUnit.SECONDS);
	
	}

}
