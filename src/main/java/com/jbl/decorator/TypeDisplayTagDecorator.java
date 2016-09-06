package com.jbl.decorator;

import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.Type;
import com.jbl.util.CommonUtils;

public class TypeDisplayTagDecorator extends TableDecorator{

	public String getDeptName() throws UnsupportedOperationException{
		Type type = (Type)getCurrentRowObject();
		if(CommonUtils.isNotNull(type.getDeptName())){
			return type.getDeptName();
		}
		else{
			return "无";
		}
	}
}
