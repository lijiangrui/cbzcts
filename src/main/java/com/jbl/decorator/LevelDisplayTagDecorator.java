package com.jbl.decorator;

import org.apache.struts2.ServletActionContext;
import org.displaytag.decorator.TableDecorator;

import com.jbl.pagemodel.Files;
import com.jbl.pagemodel.User;

public class LevelDisplayTagDecorator extends TableDecorator{

	public String getName() throws UnsupportedOperationException{
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentuser");
		Files files = (Files)getCurrentRowObject();
		if(user.getRoleid() == 2 || user.getRoleid() == 3){
			return "<a href='showswfinb!showSwfInB.action?id="+files.getId()+"' target='_blank'>"+files.getName()+"</a>";
		}else{
			return files.getName();
		}
	}
	
	public String getLevel() throws UnsupportedOperationException{
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentuser");
		Files files = (Files)getCurrentRowObject();
		if(user.getRoleid() ==3 || user.getRoleid() == 4)
			return "<input type='button' value='申请' onclick='applyfile("+files.getId()+");' />";
		else if(user.getRoleid() == 1){
			return "<a href='fileAction!downloadFile.action?id="+files.getId()+"' >下载</a>";
		}
		return null;
	}
}
