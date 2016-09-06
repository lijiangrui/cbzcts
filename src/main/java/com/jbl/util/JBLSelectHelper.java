package com.jbl.util;

import java.lang.reflect.Method;
import java.util.List;

public class JBLSelectHelper extends CommonUtils{
	
	private List list;
	private String key;
	private String value;
	private String selectId;
	private String changeMethodName = "";
	private String selectedOptKey = "";
	
	public JBLSelectHelper(List list, String key, String value,
			String selectId) {
		this.list = list;
		this.key = key;
		this.value = value;
		this.selectId = selectId;
	}


	/**
	 * 生成一个下拉选框
	 * @param list 源list
	 * @param key 作为key的字段名
	 * @param value 作为value的字段名
	 * @param selectName select的id、name
	 * @param type option的类型，0：<option id> 1:<option value>
	 * @return <select>..</select>
	 */
	public String make() {
		StringBuffer select = new StringBuffer("<select id='"+selectId+"' name='"+selectId+"'");
		if("".equals(changeMethodName)){
			select.append(">");
		}else{
			select.append(" onchange=\""+changeMethodName+";\">");
		}
		select.append("<option value='0'>请选择</option>");
		if(list == null || list.isEmpty()){
			select.append("</select>");
			return select.toString();	
		}
		try{
			String keyMethodName = "get"+key.substring(0, 1).toUpperCase()+key.substring(1,key.length());
			String valueMethodName = "get"+value.substring(0, 1).toUpperCase()+value.substring(1,value.length());
			for (Object object : list) {
				Method keyMethod=object.getClass().getMethod(keyMethodName, null);
				Method valueMethod=object.getClass().getMethod(valueMethodName, null);
				String keyStr ="";
				if(String.class == keyMethod.getReturnType()){
					keyStr = (String)keyMethod.invoke(object,null);
				}else if(Integer.class == keyMethod.getReturnType()){
					keyStr = (Integer)keyMethod.invoke(object,null) +"";
				}
				String valueStr = (String)valueMethod.invoke(object,null);
				if(selectedOptKey.equals(keyStr)){
					select.append("<option value='"+keyStr+"' selected='selected'>"+valueStr+"</option>");
				}else
				    select.append("<option value='"+keyStr+"'>"+valueStr+"</option>");
			}
			select.append("</select>");
		}catch(Exception e){
			e.printStackTrace();
		}
		return select.toString();
	}
	
	/**
	 * 给select标签加上onchange事件，注意方法名不能以数字开头，
	 * 不能包含特殊字符和空格,由于未做验证，填错后果自负。
	 * 格式：method(parm)
	 * @param changeMethodName 
	 */
	public void setChangeMethodName(String changeMethodName) {
		this.changeMethodName = changeMethodName;
	}

	/**
	 * 给option标签加上selected属性
	 * @param selectedOptKey
	 */
	public void setSelectedOption(String selectedOptKey) {
		this.selectedOptKey = selectedOptKey;
	}
	
	public String html(String selectedId,String changeMethodName){
		if(CommonUtils.isNotNull(selectedId)){
			setSelectedOption(selectedId);
		}
		if(CommonUtils.isNotNull(changeMethodName)){
			setChangeMethodName(changeMethodName);
		}
		return make();
	}
}
