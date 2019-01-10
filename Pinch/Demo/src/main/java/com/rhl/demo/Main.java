package com.rhl.demo;

import com.rhl.pinch.client.statsmonitor.StateMonitor;

public class Main {
	
	
	public static void main(String k []) throws InterruptedException {
		
		
		StateMonitor stateScheudar = new StateMonitor("ABC3");
		stateScheudar.start();
		Demo demo = new Demo();
		for (int i=0; i<100; i++) {
			demo.demoMethod(10);
		}
		
		for (int i=0; i< 100; i++) {
			demo.demoMethod(10);
		}
	}

}
