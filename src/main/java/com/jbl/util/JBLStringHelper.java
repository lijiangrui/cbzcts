package com.jbl.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class JBLStringHelper extends CommonUtils{

	private static StringBuffer buf;
	private static long ext = 1;
	private static String companyType = "CS";
	/**
	 * 进行Md5加密
	 * @param plainText
	 * @return
	 */
	public static String Md5(String plainText) {		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(buf.toString());
		return buf.toString();// 32位的加密
	}
	
	 public static synchronized String makeOrderNumStr(String prefix) {
		  String str = new SimpleDateFormat("yyMMddHHmm")
		    .format(new java.util.Date());
		  long num = Long.parseLong((str)) * 10000;
		  long ret = num + ext;
		  ext ++;
		  return prefix+"_"+String.valueOf(ret);
		 }
	
	 public static synchronized String makeNo(String prefix,int ext){
		 StringBuffer no = new StringBuffer("JBL-");
		 String type = prefix.substring(prefix.length()-2,prefix.length());
		 if(companyType.equals(type.toUpperCase())){
			 no.append(type.toUpperCase());
		 }
		 if(ext <10){
			 no.append("-00"+ext);
		 }else if(ext <100){
			 no.append("-0"+ext);
		 }else{
			 no.append("-"+ext);
		 }
		 return no.toString();
	 }
	 
	 public static String GetIP(){
		 String ip = "";
		 String address = "";
		 InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			ip=addr.getHostAddress().toString();//获得本机IP
			address=addr.getHostName().toString();//获得本机名称
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		 return "["+address+"]:"+ip;
     }
         
}
