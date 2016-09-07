package com.jbl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.apache.struts2.ServletActionContext;

public class DownloadFileHelper {
	
	private String absoluteFileName;
	
	public DownloadFileHelper(String absoluteFileName){
		this.absoluteFileName = absoluteFileName;
	}
	/**
	 * 用户下载附件
	 * @param downloadName 自定义下载文件名称
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException 
	 */
	public void download(String downloadName,String contentType) throws FileNotFoundException, UnsupportedEncodingException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		// 下载本地文件
        //String fileName = "Operator.doc".toString(); // 文件的默认保存名
        // 读到流中
        
        InputStream inStream = new FileInputStream(absoluteFileName);// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType(contentType);
        //String httpHeader="attachment;filename=export_"+absoluteFileName.substring(absoluteFileName.length()-11,absoluteFileName.length());
        String httpHeader="attachment;filename="+new String(downloadName.getBytes("UTF-8"),"iso-8859-1");
        response.addHeader("Content-Disposition", httpHeader);
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void downloadPDF() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		// 下载本地文件
        //String fileName = "Operator.doc".toString(); // 文件的默认保存名
        // 读到流中
        String aaa = "D:\\Java\\apache-tomcat-7.0.47\\webapps\\byfms\\upload\\2015-02-21\\GBT17678.1-1999.swf";
        FileInputStream in = new FileInputStream(aaa);// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("application/swf");
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[512];
		while((in.read(b)) != -1){
			out.write(b);
		}
		out.flush();
		in.close();
		out.close();
	}
}