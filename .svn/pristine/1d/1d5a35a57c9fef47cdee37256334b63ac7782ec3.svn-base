package com.jbl.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Record;
import com.jbl.pagemodel.User;
import com.jbl.service.OperateRecordService;
import com.jbl.service.UserService;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;

@ParentPackage("basePackage")
@Namespace("/record")
@Action(value="recordAction")
@Results(value={
		@Result(name="success",location="/WEB-INF/pages/common/recordlist.jsp")
})
public class RecordAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	private OperateRecordService orService;
	
	private UserService userService;
	public String recordList() throws Exception{
		
		List<Record> recordList = orService.getRecordList(0);
		int count = 0;
		if(!CommonUtils.isNull(recordList)){
			count = recordList.size();
		}
		getRequest().setAttribute("total", count);
		getRequest().setAttribute("resultList", recordList);
		getRequest().setAttribute("pagesize", JBLConstants.PAGESIZE);
		return SUCCESS;
	}
	
	public String record0List(){
		User user = getCurrentUser();
		try {
		List<Record> recordList = orService.getRecordList(user.getId());
		display(recordList);	} catch (Exception e) {
		e.printStackTrace();
	}
		return SUCCESS;
	}
	@Action(value="showuserrecordlist",results={
			@Result(name="success",location="/WEB-INF/pages/record/show_userrecord_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showUserRecordList(){
		User user = getCurrentUser();
		try {
			List<Record> recordList = orService.getRecordList(0);
			display(recordList);
			List<User> userList = userService.getUserList(user);
			selectHtml(userList, "id", "realname", "userId", "userListHtml", "", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value="searchuserrecordlist",results={
			@Result(name="success",location="/WEB-INF/pages/record/show_userrecord_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchUserRecordList(){
		try {
			User user = getCurrentUser();
			int operaterId = Integer.parseInt(getRequest().getParameter("userId"));
			int type = Integer.parseInt(getRequest().getParameter("type"));
			List<Record> recordList = orService.getRecordList(operaterId, type);
			display(recordList);
			List<User> userList = userService.getUserList(user);
			selectHtml(userList, "id", "realname", "userId", "userListHtml", operaterId+"", null);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	
	public OperateRecordService getOrService() {
		return orService;
	}
	@Autowired
	public void setOrService(OperateRecordService orService) {
		this.orService = orService;
	}

	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
