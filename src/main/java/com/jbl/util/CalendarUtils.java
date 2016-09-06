package com.jbl.util;

import java.util.Calendar;

public class CalendarUtils {
	
	public static int getLastDay(String year, String month) {
		int lastDay = 0;
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year)-1990, Integer.parseInt(month)-1,1);
		lastDay =cal.getActualMaximum(cal.DAY_OF_MONTH);
		return lastDay;
	}
}
