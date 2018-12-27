package com.rhl.service.webSocket;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rhl.model.AppStats;
import com.rhl.service.MonitoringService;



@Component
public class TesxtMessageHandler  extends TextWebSocketHandler  { // implements ApplicationContextAware {
	
//	private static ApplicationContext context;

    /*@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;   
    }

    public static ApplicationContext getContext() {
        return context;
    }*/
	
	@Autowired
    @Qualifier("monitoringService")
	MonitoringService monitoringService ;
	
	ObjectMapper objectMapper ;
	
	/*public TesxtMessageHandler() {
		super();
		 
	}*/
	
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		   
		String payload = message.getPayload();
		this.objectMapper = new ObjectMapper();
		objectMapper.registerModules(new JavaTimeModule());
		 objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		AppStats appStatus = objectMapper.readValue(payload, AppStats.class);
	//	MonitoringService monitoringService = context.getBean(MonitoringService.class);
		monitoringService.addStats(appStatus);
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		System.out.println("Opened new session in instance " + this);
	}

	

}
