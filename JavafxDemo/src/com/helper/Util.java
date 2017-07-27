package com.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
  
	private static final String PATTERN="dd.MM.yyyy";
	private static final DateTimeFormatter FORMATTER= DateTimeFormatter.ofPattern(PATTERN);
	
	
	public static String dateToString(LocalDate date){
		if(date==null)
		return null;
		else
			return FORMATTER.format(date);
		
	}
}
