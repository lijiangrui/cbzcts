package com.jbl.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Area;
import com.jbl.pagemodel.User;
import com.jbl.service.AreaService;
import com.jbl.service.UserService;
import com.jbl.util.Constants;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="loginAction")
@Results({
	@Result(name="fail", location="/firstpage.jsp"),
	@Result(name="success", location="/adminpage.jsp"),
	@Result(name="usersuccess", location="/userpage.jsp"),
	@Result(name="error", location="/error.jsp")
})
public class LoginAction extends BaseAction implements ModelDriven<User> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	private UserService userService;
	
	private AreaService areaService;
	
	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String login(){
		
		try {
			User u = userService.login(user);
			if(u == null){
				getRequest().setAttribute("msg", Messages.LOGIN_FAIL);
				return "fail";
			}else if(u.getRoleid() != Constants.ROLE_ADMIN){
				init(u);
				operateRecord(Messages.LOGIN_SUCCESS,JBLConstants.LOGIN);
				
				return "usersuccess";
			}
			init(u);
			operateRecord(Messages.LOGIN_SUCCESS,JBLConstants.LOGIN);
			return SUCCESS;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return "error";
		}
		
		
	}

	private void init(User u) {
		getSession().setAttribute("currentuser", u);
		getSession().setAttribute("ip", CommonUtils.getNetAddr());
		try {
			List<Area> areaList = areaService.getAreasByPid(1);
			getSession().setAttribute("areaList", areaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AreaService getAreaService() {
		return areaService;
	}
	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

}
