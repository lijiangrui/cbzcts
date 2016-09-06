package com.jbl.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.jbl.util.JBLLog;

public class ExportExcel {
	
	private String fname;
	/**
	 * 工作簿
	 */
	private HSSFWorkbook workbook = new HSSFWorkbook();
	/**
	 * 指定文件输入流
	 */
	private OutputStream out;
	/**
	 * 列名
	 */
	public String[] headerArr = null;
	/**
	 * 每个分行的开始行
	 */
	private int rowIndex =0;
	
	public ExportExcel(String fname){
			this.fname = fname;
	}
//	/**
//	 *  创建第一个sheet页
//	 * @param resultMap
//	 * @param title
//	 * @throws IOException
//	 */
//	public void createSheet0(Map<String, VoucherOrderInfoBo> resultMap,String title) throws IOException {
//		HSSFSheet sheet = workbook.createSheet("印制清单");
//		createFirstLine(workbook, sheet, title,headerArr.length);
//		createSecondLine(sheet,headerArr);
//		Double[] tPriceAndtCount = createBody(resultMap, sheet,headerArr.length,2);
//		createFooter(resultMap.size()+2, sheet, tPriceAndtCount,headerArr.length);
//	}
//	
//	/**
//	 * 创建第二个sheet页
//	 * @param resultBankMap
//	 * @param fname
//	 * @param title
//	 * @param headerArr
//	 */
//	public void createSheet1(Map<String, List<VoucherOrderInfoBo>> resultBankMap,String title) {
//		HSSFSheet sheet = workbook.createSheet("各分行送货清单");
//		createFirstLine(workbook, sheet, title,headerArr.length);
//		createSecondLine(sheet,headerArr);
//		if(resultBankMap != null&&!resultBankMap.isEmpty()){
//			Iterator it = resultBankMap.keySet().iterator();
//			rowIndex =0;
//			while(it.hasNext()){
//				String key = (String)it.next();
//				List<VoucherOrderInfoBo> itemList = resultBankMap.get(key);
//				rowIndex +=2;
//				createSubHeader(workbook, sheet,key,headerArr.length,rowIndex);
//				if(itemList != null && !itemList.isEmpty()){
//					rowIndex +=1;
//					Double[] tPriceAndtCount = createSubBody(itemList,sheet,headerArr.length,rowIndex);
//					rowIndex += itemList.size();
//					createSubFooter(rowIndex,sheet,tPriceAndtCount,headerArr.length);
//				}
//			}
//		}
//	}
//	
//
//	/**
//	 * 生成rowIndex2行抬头
//	 * @param workbook
//	 * @param sheet
//	 * @param key
//	 * @param length
//	 * @param rowIndex2
//	 */
//	private void createHeader(HSSFWorkbook workbook, HSSFSheet sheet,
//			String title, int mergedRegion, int rowIndex2) {
//		HSSFCell cell;
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, mergedRegion-1));//开始行 ，开始列， 结束行，结束列
//		HSSFCellStyle style = workbook.createCellStyle();
//		HSSFFont font = workbook.createFont();
//		font.setColor(HSSFColor.BLACK.index);
//		font.setFontHeightInPoints((short) 12);
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		style.setFont(font);
//		HSSFRow row = sheet.createRow(rowIndex2);
//		cell = row.createCell(0);
//		cell.setCellStyle(style);
//		cell.setCellValue(title);
//		for(int i=0;i<mergedRegion;i++){
//			sheet.setColumnWidth(i, 3000);//列数，列宽
//		}
//		
//	}
//	/**
//	 * 
//	 * @param voucherOrderInfoBo
//	 * @param sheet
//	 * @param columnCount
//	 * @param startRowIndex
//	 * @param tPriceAndtCount
//	 * @param no
//	 */
//	public void createSingleLine(VoucherOrderInfoBo voucherOrderInfoBo,HSSFSheet sheet,int columnCount,int startRowIndex,Double[] tPriceAndtCount,int no){
//		HSSFRow row;
//		int columncount = columnCount;
//		row = sheet.createRow(startRowIndex);
//		for(int j=0;j<columnCount;j++){
//			HSSFCell cell = row.createCell(j);
//		}
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getTotalPrice());
//		if(columnCount == 8){
//			row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getBankName());
//		}
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getVoucherUnit());
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getVoucherCount());
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getVoucherPrice());
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getVoucherStandard());
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getVoucherName());
//		row.getCell(--columnCount).setCellValue(voucherOrderInfoBo.getVoucherNo().substring(0,10));
//		row.getCell(--columnCount).setCellValue(no+1);
//		columnCount = columncount;
//		tPriceAndtCount[0] += voucherOrderInfoBo.getTotalPrice();;
//		tPriceAndtCount[1] += voucherOrderInfoBo.getVoucherCount();
//	}
//	
//	
//	/**
//	 * 生成sheet页第一行
//	 * @param workbook
//	 * @param sheet
//	 * @param title
//	 * @param mergedRegion
//	 * @return
//	 */
//	private void createFirstLine(HSSFWorkbook workbook,
//			HSSFSheet sheet, String title,int mergedRegion) {
//		createHeader(workbook, sheet, title, mergedRegion, 0);
//		
//	}
//	
//	
//	/**
//	 * 创建sheet页第二行
//	 */
//	private void createSecondLine(HSSFSheet sheet,String[] headerArr) {
//		HSSFCell cell;
//		HSSFRow row = sheet.createRow(1);
//		for(int i=0;i<headerArr.length;i++){
//			cell = row.createCell(i);
//			cell.setCellValue(headerArr[i]);
//		}
//	}
//	
//	/**
//	 * 创建sheet中间部分
//	 * @param resultMap
//	 * @param sheet
//	 * @param columnCount
//	 * @param startRowIndex 
//	 * @return
//	 */
//	
//	private Double[] createBody(
//		Object object, HSSFSheet sheet,int columnCount,int startRowIndex) {
//		Double[] tPriceAndtCount ={0.0,0.0};
//		int no=0;
//		if(object instanceof Map){
//			Map<String,VoucherOrderInfoBo> resultMap = (Map<String,VoucherOrderInfoBo>)object;
//			if(resultMap != null && !resultMap.isEmpty()){
//				Iterator it = resultMap.keySet().iterator();
//				while(it.hasNext()){
//					String key = (String)it.next();
//					VoucherOrderInfoBo voucherOrderInfoBo = resultMap.get(key);
//					createSingleLine(voucherOrderInfoBo, sheet, columnCount, startRowIndex, tPriceAndtCount,no);
//					no++;
//					startRowIndex++;
//				}
//			}
//		}
//		if(object instanceof List){
//			List<VoucherOrderInfoBo> itemList = (List<VoucherOrderInfoBo>)object;
//			for (VoucherOrderInfoBo voucherOrderInfoBo : itemList) {
//				createSingleLine(voucherOrderInfoBo, sheet, columnCount, startRowIndex, tPriceAndtCount,no);
//				no++;
//				startRowIndex++;
//			}
//		}
//		return tPriceAndtCount;
//	}
//	
//	/**
//	 * 创建sheet页结尾
//	 * @param startRowIndex
//	 * @param sheet
//	 * @param map
//	 * @param columnCount
//	 */
//	private void createFooter(int startRowIndex,
//			HSSFSheet sheet, Double[] tPriceAndtCount,int columnCount) {
//		
//		HSSFRow row;
//		double tPrice = tPriceAndtCount[0];
//		int tCount =  tPriceAndtCount[1].intValue();
//		row = sheet.createRow(startRowIndex);
//		for(int i=0;i<columnCount;i++){
//			HSSFCell cell = row.createCell(i);
//		}
//		row.getCell(0).setCellValue("总计");
//		//这里要改，但还不知道怎么改。
//		if(columnCount == 8){
//			row.getCell(columnCount-3).setCellValue(tCount);
//			row.getCell(columnCount-2).setCellValue("份");
//		}else if(columnCount ==9){
//			row.getCell(columnCount-4).setCellValue(tCount);
//			row.getCell(columnCount-3).setCellValue("份");
//		}
//		row.getCell(columnCount-1).setCellValue(tPrice);
//	}
//	
//	/**
//	 * 生成分行抬头
//	 * @param workbook
//	 * @param sheet
//	 * @param key
//	 * @param length
//	 * @param rowIndex2 
//	 */
//	private void createSubHeader(HSSFWorkbook workbook, HSSFSheet sheet,
//			String key, int length, int rowIndex2) {
//		createHeader(workbook,sheet,key,length,rowIndex2);
//	}
//	
//	/**
//	 * 创建sheet页分行中间部分
//	 * @param itemList
//	 * @param sheet
//	 * @param length
//	 * @return
//	 */
//	private Double[] createSubBody(List<VoucherOrderInfoBo> itemList, HSSFSheet sheet,
//			int columnCount,int startRowIndex) {
//		return createBody(itemList, sheet, columnCount, startRowIndex);
//	}
//	
//	/**
//	 * 生成分行结尾
//	 * @param startRowIndex
//	 * @param sheet
//	 * @param priceAndcount
//	 * @param length
//	 */
//	private void createSubFooter(int startRowIndex, HSSFSheet sheet,
//			Double[] tPriceAndtCount, int columnCount) {
//		createFooter(startRowIndex, sheet, tPriceAndtCount, columnCount);
//	}
//	
//	/**
//	 * 将工作簿写入文件
//	 * @param out
//	 * @param workbook
//	 * @throws IOException
//	 */
//	public void writeFile()
//			throws IOException {
//		JBLLog.logging(this.getClass(), "开始写入文件");
//		out = new FileOutputStream(fname);
//		workbook.write(out);
//		out.close();
//		JBLLog.logging(this.getClass(), "写入文件结束");
//	}

	public void export(HttpServletResponse response) throws FileNotFoundException{
		File file = new File(fname);
        InputStream inStream = new FileInputStream(file);// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=export.xls");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	file.delete();
        }
	}
	
//	public void exportExcel(Collection dataset, OutputStream out, String pattern) {
//  // 声明一个工作薄
//  HSSFWorkbook workbook = new HSSFWorkbook();
//  // 生成一个表格
//  HSSFSheet sheet = workbook.createSheet("export.xls");
//  // 设置表格默认列宽度为15个字节
//  //sheet.setDefaultColumnWidth((short) 15);
//  // 生成一个样式
//  HSSFCellStyle style = workbook.createCellStyle();
//  // 设置这些样式
//  style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//  style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//  style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//  style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//  style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//  style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//  style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//  // 生成一个字体
//  HSSFFont font = workbook.createFont();
//  font.setColor(HSSFColor.VIOLET.index);
//  font.setFontHeightInPoints((short) 12);
//  font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//  // 把字体应用到当前的样式
//  style.setFont(font);
//  // 生成并设置另一个样式
//  HSSFCellStyle style2 = workbook.createCellStyle();
//  style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
//  style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//  style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//  style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//  style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
//  style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
//  style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//  style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//  // 生成另一个字体
//  HSSFFont font2 = workbook.createFont();
//  font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
//  // 把字体应用到当前的样式
//  style2.setFont(font2);
//
//  // 声明一个画图的顶级管理器
//  // 设置注释内容
//  // 产生表格标题行
//  HSSFRow row = sheet.createRow(0);
//  for (short i = 0; i < headers.length; i++) {
//      HSSFCell cell = row.createCell(i);
//      cell.setCellStyle(style);
//      HSSFRichTextString text = new HSSFRichTextString(headers[i]);
//      cell.setCellValue(text);
//  }
//  try {
//      workbook.write(out);
//  } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//  }
//
//}
//

}
