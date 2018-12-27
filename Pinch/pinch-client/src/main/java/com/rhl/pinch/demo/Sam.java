package com.rhl.pinch.demo;

import com.rhl.pinch.client.statsmonitor.StateSchdular;

public class Sam {
	
	
public static void main(String[] args) throws InterruptedException {
		
		StateSchdular stateScheudar = new StateSchdular();
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
