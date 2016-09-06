package com.jbl.action;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jbl.pagemodel.Files;
import com.jbl.pagemodel.Record;
import com.jbl.pagemodel.Supplier;
import com.jbl.pagemodel.User;
import com.jbl.service.OperateRecordService;
import com.jbl.util.Constants;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLSelectHelper;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private OperateRecordService orService;
	
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	public HttpSession getSession(){
		return getRequest().getSession();
	}

	public String getRealPath() {
		return ServletActionContext.getServletContext().getRealPath("/");
	}
	
	/**
	 * 操作记录
	 * @param something
	 * @throws Exception
	 */
	public void operateRecord(String something,int type) throws Exception {
		User user = getCurrentUser();
		Record record = new Record(user.getId(),user.getName(),something,type);
		record.setIp(CommonUtils.getNetAddr());
		orService.record(record);
	}

	public OperateRecordService getOrService() {
		return orService;
	}
	@Autowired
	public void setOrService(OperateRecordService orService) {
		this.orService = orService;
	}
	
	public User getCurrentUser(){
		return (User) getSession().getAttribute("currentuser");
	}
	
	public void display(List filesList) {
		int count = 0;
		if(CommonUtils.isNotNull(filesList)){
			count = filesList.size();
		}
		getRequest().setAttribute("total", count);
		getRequest().setAttribute("resultList", filesList);
		getRequest().setAttribute("pagesize", Constants.PAGESIZE);
	}
	
	public void setMsg(String msg){
		getRequest().setAttribute("msg", msg);
	}
	public void setUrl(String url) {
		getRequest().setAttribute("url", url);
	}
	
	public void selectHtml(List list,String key,String value,String selectTagId,String htmlName,String selectedId,String changeMethodName){
		JBLSelectHelper selHelper = new JBLSelectHelper(list, key, value, selectTagId);
		String html = selHelper.html(selectedId,changeMethodName);
		getRequest().setAttribute(htmlName, html);
	}
	public void print2json(List<Supplier> list) throws IOException {
		JSONObject obj1 = new JSONObject();
		JSONArray arr1 = new JSONArray();
		selectHtml(list, "id", "name", "sid", "supplierHTML", "", "checkSelected(this.id,'span2')");
		String supplierHTML = (String) getRequest().getAttribute("supplierHTML");
		obj1.put("supplierHTML", supplierHTML);
		JSONObject obj = new JSONObject();
		JSONArray arr = new JSONArray();
		if(CommonUtils.isNotNull(list)){
			for(Supplier su : list ){
				arr.add(su.getName());
			}
		}
		obj.put("tags", arr);
		arr1.add(obj1);
		arr1.add(obj);
		getResponse().getWriter().print(arr1.toJSONString());
	}
}