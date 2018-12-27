package com.rhl.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class cpu {
	
	public static void main(String[] args) throws InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int mb = 1024*1024;
		
	/*	OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
	            .getOperatingSystemMXBean();*/
		
		  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
	//	  operatingSystemMXBean.g
		  
	/*	  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
		    method.setAccessible(true);
		    if (method.getName().startsWith("get")
		        && Modifier.isPublic(method.getModifiers())) {
		            Object value;
		        try {
		            value = method.invoke(operatingSystemMXBean);
		        } catch (Exception e) {
		            value = e;
		        } // try
		        System.out.println(method.getName() + " = " + value);
		    } // if
		  } // for */
	
		 Method method =   operatingSystemMXBean.getClass().getMethod("getProcessCpuLoad");
		 method.setAccessible(true);
		  double value =  (Double) method.invoke(operatingSystemMXBean);
			System.out.println("getProcessCpuLoad = " + value/mb);
		 
		 
			//Getting the runtime reference from system
			Runtime runtime = Runtime.getRuntime();
			
			System.out.println("##### Heap utilization statistics [MB] #####");
			
			//Print used memory
			System.out.println("Used Memory:" 
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);

			//Print free memory
			System.out.println("Free Memory:" 
				+ runtime.freeMemory() / mb);
			
			//Print total available memory
			System.out.println("Total Memory:" + runtime.totalMemory() / mb);

			//Print Maximum available memory
			System.out.println("Max Memory:" + runtime.maxMemory() / mb);
		}
		  
		  
	}


