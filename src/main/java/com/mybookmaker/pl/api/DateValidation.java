package com.mybookmaker.pl.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DateValidation {

	public static String getDateFromJson(String date){
		return date.substring(0, 10);
	}
	
	public static String getTimeFromJson(String date) {
	return date.substring(11, 19);
	}
	
	public static String getToday() {
		Date currentDate = new Date();
		return new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
	}
	
	public static String getTodayWithTime() {
		Date currentDate = new Date();
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
	}
	
	public static String getTodayWithAddOrSubstract(int addOrSubstractNumerOfDay) {
		Date currentDate = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE,addOrSubstractNumerOfDay);
		Date dateOfGregorianCalendar = calendar.getTime();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(dateOfGregorianCalendar);
		return modifiedDate;
	}
	
	
	
	

}