package com.rhl.service.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhl.model.CPUStat;
import com.rhl.model.MemoryStat;
import com.rhl.service.MonitoringService;
import com.rhl.service.ReportService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/graph")
public class GraphService {
	
	@Autowired
    @Qualifier("monitoringService")
	private MonitoringService monitoringService ; 
	
	@RequestMapping("/memoryGraph/{serviceName}")
	public List<MemoryStat> getMomoreyState(@PathVariable String serviceName) {	
		System.out.println("In service :" +serviceName );
		return monitoringService.getmemoryStat("ABC");
	}
	
	@RequestMapping("/CPUGraph/{serviceName}")
	public List<CPUStat> getCPUState(@PathVariable String serviceName) {	
		System.out.println("In service :" +serviceName );
		return monitoringService.getCPUStat("ABC");
	}
	
	@RequestMapping("/apps")
	public Set<String> getServices() {	
		System.out.println("In service :"  );
		return monitoringService.getServiceNames();
	}

}
