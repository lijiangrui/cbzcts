package com.jbl.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@SuppressWarnings("serial")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value="exitAction")
@Results({
	@Result(name="success",location="/firstpage.jsp")
})
public class ExitAction extends BaseAction {
	
	public String exit(){
		
		getSession().removeAttribute("currentuser");
		getSession().invalidate();
		return SUCCESS;
	}
	
}
