package com.jbl.decorator;

import org.apache.struts2.ServletActionContext;
import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.Files;
import com.jbl.pagemodel.User;

public class ApplyDisplayTagDecorator extends TableDecorator{

	public String getName() throws UnsupportedOperationException{
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentuser");
		Files files = (Files)getCurrentRowObject();
		if(files.getApplyStatus() == 1 && user.getRoleid() ==4){
			return "<a href='showswfinb!showFileInB.action?applyId="+files.getApplyId()+"' target='_blank'>"+files.getName()+"</a>";
		}else if(user.getRoleid() ==3){
			return "<a href='showswfinb!showFileInB.action?applyId="+files.getApplyId()+"' target='_blank'>"+files.getName()+"</a>";
		}
		else{
			return files.getName();
		}
	}
	public String getStatus() throws UnsupportedOperationException{
		Files files = (Files)getCurrentRowObject();
		if(files.getApplyStatus() == 1){
			return "审核通过";
		}else if(files.getApplyStatus() == 0){
			return "等待部门审核";
		}else if(files.getApplyStatus() == 2){
			return "审核未通过";
		}else if(files.getApplyStatus() == 3){
			return "等待办公室审核";
		}
		return "";
	}
}
