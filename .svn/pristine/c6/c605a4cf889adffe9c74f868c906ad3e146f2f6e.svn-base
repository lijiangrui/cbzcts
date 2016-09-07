package com.jbl.util;

import java.text.SimpleDateFormat;

public class JBLLog {
	public static void logging(Class loggingClass,String log){
		loggingClass.getName();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		String time = sdf.format(System.currentTimeMillis());
		System.out.println(time+":"+loggingClass.getName()+":"+log);
	}
}
