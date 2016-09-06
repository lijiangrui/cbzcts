package com.jbl.decorator;

import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.Dept;
import com.jbl.util.CommonUtils;

public class DeptDisplayTagDecorator extends TableDecorator{

	public String getCompanyName() throws UnsupportedOperationException{
		Dept dept = (Dept)getCurrentRowObject();
		if(CommonUtils.isNotNull(dept.getCompanyName())){
			return dept.getCompanyName();
		}
		else{
			return "无";
		}
	}
	
	public String getDeptName() throws UnsupportedOperationException{
		Dept dept = (Dept)getCurrentRowObject();
		if(CommonUtils.isNotNull(dept.getDeptName())){
			return dept.getDeptName();
		}
		else{
			return "无";
		}
	}
}
