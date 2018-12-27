package com.rhl.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.rhl.model.AppStats;
import com.rhl.model.CPUStat;
import com.rhl.model.MemoryStat;

@Service("monitoringService")
public class MonitoringService {
	
	Map<String,List<CPUStat>> servicesCpuMap = new HashMap <String,List<CPUStat>> ();
	Map<String,List<MemoryStat>> servicesMemoryMap = new HashMap <String,List<MemoryStat>> () ;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public void addStats(AppStats stats){
		
		CPUStat cpuStat = new CPUStat(stats.getProcesCpuUsage(),stats.getSystemCpuUsage(),stats.getTime().format(formatter));
		 MemoryStat memoryStat = new MemoryStat(stats.getTotalMemory(),stats.getUsedMemory(),stats.getTime().format(formatter));
		 if(servicesCpuMap.containsKey(stats.getServiceName())) {
			 servicesCpuMap.get(stats.getServiceName()).add(cpuStat);
			 servicesMemoryMap.get(stats.getServiceName()).add(memoryStat);
			 
		 }
		 else {
			 List <MemoryStat> memoryList = new LinkedList <MemoryStat> ();
			 memoryList.add(memoryStat);
			 servicesMemoryMap.put(stats.getServiceName(), memoryList);
			 List <CPUStat> cpuList = new LinkedList <CPUStat> ();
			 cpuList.add(cpuStat);
			 servicesCpuMap.put(stats.getServiceName(), cpuList);
		 }
	}
	
	
	public List<MemoryStat> getmemoryStat(String serviceName){
		return servicesMemoryMap.get(serviceName) ;
	}
	

	public List<CPUStat> getCPUStat(String serviceName){
		return servicesCpuMap.get(serviceName) ;
	}
	
	
	public Set<String>  getServiceNames() {
		return this.servicesCpuMap.keySet();
	}
	

}
