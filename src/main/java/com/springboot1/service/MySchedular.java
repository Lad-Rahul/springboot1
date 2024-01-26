package com.springboot1.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MySchedular {
	
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void everyMinuteSchedular() {
		System.out.println("every minute schedular : " + new Date());
	}
	
	@Scheduled(cron = "0 0 12 1/1 * ?")
	public void everyDayAtTwelveSchedular() {
		System.out.println("everyday schedular : " + new Date());
	}
}
