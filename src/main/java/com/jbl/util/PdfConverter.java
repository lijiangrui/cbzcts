package com.jbl.util;
import java.io.BufferedInputStream;  
	import java.io.File;  
	import java.io.IOException;  
	import java.io.InputStream;  
	  
/**
	import com.artofsolving.jodconverter.DocumentConverter;  
	import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;  
	import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;  
	import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;  
	  */
	/** 
	 * pdf格式转换 
	 */  
	public class PdfConverter {  
	    private static final int environment = 1;// 环境 1：windows 2:linux  
	    private String fileString;// (只涉及pdf2swf路径问题)  
	    private String outputPath = "";// 输入路径 ，如果不设置就输出在默认的位置  
	    private String fileName;  
	    private File pdfFile;  
	    private File swfFile;  
	      
	    public PdfConverter(String fileString) {  
	        ini(fileString);  
	    }  
	  
	    /** 
	     * 重新设置file 
	     *  
	     * @param fileString 
	     */  
	    public void setFile(String fileString) {  
	        ini(fileString);  
	    }  
	  
	    /** 
	     * 初始化 
	     *  
	     * @param fileString 
	     */  
	    private void ini(String fileString) {  
	        this.fileString = fileString;  
	        fileName = fileString.substring(0, fileString.lastIndexOf("."));  
	        pdfFile = new File(fileName + ".pdf");  
	        swfFile = new File(fileName + ".swf");  
	    }  
	    /** 
	     * 转换成 swf 
	     */  
	    @SuppressWarnings("unused")  
	    private void pdf2swf() throws Exception {  
	        Runtime r = Runtime.getRuntime();  
	        if (!swfFile.exists()) {  
	        	if (pdfFile.exists()) {  
	                if (environment == 1) {// windows环境处理  
	                    try {  
	                    	System.out.println("C:/Program Files (x86)/SWFTools/pdf2swf.exe "+ pdfFile.getPath() + " -o "+ swfFile.getPath() + " -T 9");
	                        Process p = r.exec("C:/Program Files (x86)/SWFTools/pdf2swf.exe "+ pdfFile.getPath() + " -o "+ swfFile.getPath() + " -T 9");  
	                        //System.out.print(loadStream(p.getInputStream()));  
	                        //System.err.print(loadStream(p.getErrorStream()));  
	                       // System.out.print(loadStream(p.getInputStream()));  
	                        System.err.println("****swf转换成功，文件输出："  
	                                + swfFile.getPath() + "****");  
	  
	                    } catch (IOException e) {  
	                        e.printStackTrace();  
	                        throw e;  
	                    }  
	                } else if (environment == 2) {// linux环境处理  
	                    try {  
	                        Process p = r.exec("pdf2swf " + pdfFile.getPath()  
	                                + " -o " + swfFile.getPath() + " -T 9");  
	                        System.out.print(loadStream(p.getInputStream()));  
	                        System.err.print(loadStream(p.getErrorStream()));  
	                        System.err.println("****swf转换成功，文件输出："  
	                                + swfFile.getPath() + "****");  
	                        if (pdfFile.exists()) {  
	                            pdfFile.delete();  
	                        }  
	                    } catch (Exception e) {  
	                        e.printStackTrace();  
	                        throw e;  
	                    }  
	                }  
	            } else {  
	                System.out.println("****pdf不存在,无法转换****");  
	            }  
	        } else {  
	            System.out.println("****swf已经存在不需要转换****");  
	        }  
	    }  
	  
	    static String loadStream(InputStream in) throws IOException {  
	  
	        int ptr = 0;  
	        in = new BufferedInputStream(in);  
	        StringBuffer buffer = new StringBuffer();  
	  
        while ((ptr = in.read()) != -1) {  
	            buffer.append((char) ptr);  
	        }  
	  
	        return buffer.toString();  
	    }  
	    /** 
	     * 转换主方法 
	     */  
	    @SuppressWarnings("unused")  
	    public boolean conver() {  
	  
	        if (swfFile.exists()) {  
	            System.out.println("****swf转换器开始工作，该文件已经转换为swf****");  
	            return true;  
	        }  
	  
	        if (environment == 1) {  
	            System.out.println("****swf转换器开始工作，当前设置运行环境windows****");  
	        } else {  
	            System.out.println("****swf转换器开始工作，当前设置运行环境linux****");  
	        }  
	        try {  
	            pdf2swf();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return false;  
	        }  
	  
	        if (swfFile.exists()) {  
	            return true;  
	        } else {  
	            return false;  
	        }  
	    }  
	  
	    /** 
	     * 返回文件路径 
	     *  
	     * @param s 
	     */  
	    public String getswfPath() {  
	        if (swfFile.exists()) {  
	            String tempString = swfFile.getPath();  
	            tempString = tempString.replaceAll("\\\\", "/");  
	            return tempString;  
	        } else {  
	            return "";  
	        }  
	  
	    }  
	    /** 
	     * 设置输出路径 
	     */  
	    public void setOutputPath(String outputPath) {  
	        this.outputPath = outputPath;  
	        if (!outputPath.equals("")) {  
	            String realName = fileName.substring(fileName.lastIndexOf("/"),  
	                    fileName.lastIndexOf("."));  
	            if (outputPath.charAt(outputPath.length()) == '/') {  
	                swfFile = new File(outputPath + realName + ".swf");  
	            } else {  
             swfFile = new File(outputPath + realName + ".swf");  
	            }  
	        }  
	    }  
	  
}

