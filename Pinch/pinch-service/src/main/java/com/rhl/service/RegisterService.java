package com.rhl.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

import com.rhl.model.AppService;



@Service
public class RegisterService {
	
	private static Map<String,AppService> serviceMap = new HashMap <String,AppService> ();
	
	public static AppService  register(String servicename ) {
		AppService report = new AppService(servicename);
		serviceMap.put(servicename,report );
		return report ;
	}
	
	
	public Set<String>  getServiceList () {
		return serviceMap.keySet();
	}
	
	public AppService getService(String servicename) {
		return serviceMap.get(servicename);
	}
	
	

	
	
	
	
	

   
	
	

}

