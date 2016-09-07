package com.jbl.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public abstract class CommonUtils {
	
	private static int i = 1;
	public static Date getCurrentTime(){
		return Calendar.getInstance().getTime();
	}
	
	public static boolean isNull(Object obj) {
		boolean r = (obj == null);
		if(obj instanceof String){
			r = r || "".equals(obj);
		}else
		if(obj instanceof List){
			r = r || ((List)obj).isEmpty();
		}else
		if(obj instanceof Map){
			r = r || ((Map)obj).isEmpty();
		}else
		if(obj instanceof Object[]){
			r = r || ((Object[])obj).length == 0;
		}
		return r;
	}

	public static boolean isNotNull(Object obj) {
		return false==isNull(obj);
	}
	
	public static String serialNo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String dateStr = sdf.format(new Date());
		String no = ("000"+i++);
		no = no.substring(no.length()-3,no.length());
		return dateStr+no;
	}
	
	public static String getNetAddr(){
		try {
			InetAddress ass = InetAddress.getLocalHost();
			return ass.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
