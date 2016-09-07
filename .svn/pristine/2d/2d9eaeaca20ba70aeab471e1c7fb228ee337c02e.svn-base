package com.jbl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class UpFileHelper {
	
	private File upFile;
	
	private String upFileRealName;
	
	private String path ="upload/";
	
	private String timeName;

	public String getTimeName() {
		return timeName;
	}

	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}

	public UpFileHelper(File upFile,String upFileRealName) {
		this.upFile = upFile;
		this.upFileRealName = upFileRealName;
		
		//this.path ="upload/"+dateFolder+"/";
	}
	
	/**
	 * 保存到本地默认路径
	 * @return
	 * @throws Exception
	 */
	public void saveFile2Local() throws Exception{
		saveFile2Local(path);
	}
	/**
	 * 保存到本地指定路径
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public void saveFile2Local(String path1) throws Exception{
		
		InputStream in = new FileInputStream(upFile);
		Calendar cal = Calendar.getInstance();
		String preName = String.valueOf(cal.getTimeInMillis());
		timeName = preName+upFileRealName.substring(
				upFileRealName.indexOf('.'),upFileRealName.length());
		
		//服务器中的项目路径
		String realpath = PropertiesHelper.getProperty("uploadPath");
		//日期文件夹
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateFolder = sdf.format(new Date());
		
		path = path1;
		path = path + dateFolder+"/" ;
		File filepath = new File(realpath+path);
		
		if(!filepath.exists()){
			filepath.mkdirs();
		}
		
		File file = new File(realpath+path+timeName);
		OutputStream out = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count = 0;
		while((count = in.read(buffer))>0){
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}

	public String getPath() {
		return path;
	}
	
}
