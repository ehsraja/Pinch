package com.rhl.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeLocal {
	public static void main(String[] args) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		  System.out.println(LocalTime.now().format(formatter));
		
		  System.out.println(LocalDate.now());
		  System.out.println(LocalTime.now());
		  
	}

}
