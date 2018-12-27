package com.rhl.pinch.client.statsmonitor;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rhl.model.AppStats;
import com.rhl.pinch.client.WebsocketClientEndpoint;

@Resource
public class StatsSender implements Runnable {
	 
	private  WebsocketClientEndpoint clientEndPoint ;
	 ObjectMapper objectMapper = new ObjectMapper();

	StatsCapture satatCapture = new StatsCapture();
	 
	public StatsSender() {
		 try {
			 this.objectMapper = new ObjectMapper();
				objectMapper.registerModules(new JavaTimeModule());
				 objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
				clientEndPoint = new WebsocketClientEndpoint(new URI("ws://localhost:8080/name"));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	

	
	
	public void run () {
		
		try {		
			System.out.println("Sending messege");
		    AppStats appStat = satatCapture.capture();
	        String jsonStat = null ;  
		
		    jsonStat = objectMapper.writeValueAsString(appStat);			   	
	        System.out.println("Sending messege " + jsonStat);
	        clientEndPoint.sendMessage(jsonStat);

	    } catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			System.err.println("Exception: " + e);
		}	
	}
}
