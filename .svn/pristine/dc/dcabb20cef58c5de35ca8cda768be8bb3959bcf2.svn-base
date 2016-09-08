package com.jbl.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.jbl.pagemodel.Company;
import com.jbl.pagemodel.Dept;
import com.jbl.pagemodel.Role;
import com.jbl.pagemodel.Supplier;
import com.jbl.pagemodel.Title;
import com.jbl.pagemodel.User;
import com.jbl.service.CompanyService;
import com.jbl.service.DeptService;
import com.jbl.service.RoleService;
import com.jbl.service.TitleService;
import com.jbl.service.UserService;
import com.jbl.util.Constants;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.JBLSelectHelper;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/user")
@Action(value="userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserAction.class);

	private UserService userService;
	
	private CompanyService cService;
	
	private DeptService dService;
	
	private RoleService rService;
	
	private TitleService tService;
	
	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public CompanyService getcService() {
		return cService;
	}
	@Autowired
	public void setcService(CompanyService cService) {
		this.cService = cService;
	}

	public DeptService getdService() {
		return dService;
	}
	@Autowired
	public void setdService(DeptService dService) {
		this.dService = dService;
	}

	public RoleService getrService() {
		return rService;
	}
	@Autowired
	public void setrService(RoleService rService) {
		this.rService = rService;
	}
	
	public TitleService gettService() {
		return tService;
	}
	@Autowired
	public void settService(TitleService tService) {
		this.tService = tService;
	}

	@Action(value="showuser",results={@Result(name="success",location="/WEB-INF/pages/user/showuser.jsp"),@Result(name="fail",location="/WEB-INF/pages/user/getusermsg.jsp")})
	public String showUser(){
		User u;
		try {
			u = userService.getUserById(user.getId());
			getRequest().setAttribute("edituser", u);
			List<Company> cList = cService.getAllCompanys();
			List<Dept> dList = dService.getAllDepts();
			List<Role> rList = rService.getAllRoles();
			JBLSelectHelper cHelper = new JBLSelectHelper(cList, "id", "name", "companyid");
			JBLSelectHelper dHelper = new JBLSelectHelper(dList, "id", "name", "deptid");
			JBLSelectHelper rHelper = new JBLSelectHelper(rList, "id", "name", "roleid");
			cHelper.setSelectedOption(u.getCompanyid()+"");
			dHelper.setSelectedOption(u.getDeptid()+"");
			rHelper.setSelectedOption(u.getRoleid()+"");
			String cHtml = cHelper.make();
			String dHtml = dHelper.make();
			String rHtml = rHelper.make();
			getRequest().setAttribute("cHtml", cHtml);
			getRequest().setAttribute("dHtml", dHtml);
			getRequest().setAttribute("rHtml", rHtml);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="edituser",results={@Result(name="success",location="/WEB-INF/pages/user/showuser.jsp")})
	public String editUser(){
		try {
			userService.update(user);
			operateRecord(Messages.MODIFY_USER+user.getName(), JBLConstants.MODIFY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value="adduser",results={@Result(name="success",location="/WEB-INF/pages/user/adduser.jsp")})
	public String addUser(){
		try{
			List<Company> cList = cService.getAllCompanys();
			List<Dept> dList = dService.getAllDepts();
			List<Role> rList = rService.getAllRoles();
			List<Title> tList = tService.getAllTitles();
			selectHtml(cList, "id", "name", "companyid", "cHtml", "", "");
			selectHtml(dList, "id", "name", "deptid", "dHtml", "", "");
			selectHtml(rList, "id", "name", "roleid", "rHtml", "", "");
			selectHtml(tList, "id", "name", "titleid", "tHtml", "", "");
			Set<Integer> checkedArr = checkedSet(user);
			checkBoxHtml("chargeDept",dList,checkedArr);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return SUCCESS;
	}
	
	private Set<Integer> checkedSet(User user2) {
		// TODO Auto-generated method stub
		if(CommonUtils.isNotNull(user2.getChargeDepts())){
			return string2Set(user2.getChargeDepts(),",");
		}
		return null;
	}

	private Set<Integer> string2Set(String string,String regex) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		String[] strArr = string.split(regex);
		for(String str :strArr){
			set.add(Integer.parseInt(str));
		}
		return set;
		
	}

	/**
	 * 生成一组checkbox的多选框
	 * @param name
	 * @param dList
	 * @param checkedArr
	 */
	private void checkBoxHtml(String name,List<Dept> dList,Set checkedArr) {
		// TODO Auto-generated method stub
		StringBuffer checkBoxHtml = new StringBuffer();
		int i = 1;
		if(CommonUtils.isNotNull(dList)){
			for(Dept dept : dList){
				if(CommonUtils.isNotNull(checkedArr)&&checkedArr.contains(dept.getId())){
					checkBoxHtml.append("<input type='checkbox' id='"+name+"' name='"+name+"' value='"+dept.getId()+"' checked='checked' onclick='mixVal(this.name)'>"+dept.getName()+"</input>");
				}else{
					checkBoxHtml.append("<input type='checkbox' id='"+name+"' name='"+name+"' value='"+dept.getId()+"' onclick='mixVal(this.name)'>"+dept.getName()+"</input>");
				}
				if(i++%10 == 0){
					checkBoxHtml.append("<br>");
				}
			}
		}
		getRequest().setAttribute(name+"Html", checkBoxHtml.toString());
	}

	@Action(value="saveuser",results={
			@Result(name="success",location="/savesuccess.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String saveUser(){
		try {
			userService.save(user);
			operateRecord(Messages.SAVE_USER+user.getName(), JBLConstants.ADD);
		} catch(DataIntegrityViolationException dive){
			dive.printStackTrace();
			setMsg(JBLConstants.DUPLICATEUSER);
			return "fail";
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SAVE_FAIL);
			return "fail";
		}
		setUrl("adduser!addUser.action");
		return SUCCESS;
	}
	@Action(value="showmodifypwd",results={@Result(name="success",location="/WEB-INF/pages/user/show_modifypwd_page.jsp")})
	public String showModifyPwdPage(){
		
		return SUCCESS;
	}
	@Action(value="modifypwd",results={@Result(name="success",location="/WEB-INF/pages/user/modify_success.jsp"),@Result(name="fail",location="/WEB-INF/pages/user/modify_msg.jsp")})
	public String modifyPwd(){
		try {
			userService.updatePwd(user);
			operateRecord(Messages.MODIFY_PWD+user.getName(), JBLConstants.MODIFY);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="showuserlist",results={@Result(name="success",location="/WEB-INF/pages/user/show_user_list.jsp")})
	public String showUserList(){
		try {
			List<User> userList = userService.getUserList(user);
			display(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value="searchuserlist",results={
			@Result(name="success",location="/WEB-INF/pages/user/show_user_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchUserList(){
		try {
			List<User> userList = userService.getUserByVal(user.getSearchVal());
			display(userList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}
	@Action(value="showmodifypage",results={@Result(name="success",location="/WEB-INF/pages/user/show_modifyuser_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showModifyPage(){
		try {
			User u = userService.getUserById(user.getId());
			companyHtml(u.getCompanyid()+"",null);
			deptHtml(u.getDeptid()+"",null);
			roleHtml(u.getRoleid()+"",null);
			titleHtml(u.getTitleId()+"",null);
			List<Dept> dList = dService.getAllDepts();
			Set<Integer> checkedArr = checkedSet(u);
			checkBoxHtml("chargeDept", dList, checkedArr);
			getRequest().setAttribute("user", u);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SHOW_COMPANY_FAIL);
			return "fail";
		}
		return SUCCESS;
	}

	private void titleHtml(String selectedId, String changeMethodName) throws Exception {
		List<Title> tList = tService.getAllTitles();
		selectHtml(tList, "id", "name", "titleId","tHtml",selectedId,changeMethodName);
	}

	private void roleHtml(String selectedId,String changeMethodName) throws Exception{
		List<Role> rList = rService.getAllRoles();
		selectHtml(rList, "id", "name", "roleid","rHtml",selectedId,changeMethodName);
	}

	private void deptHtml(String selectedId,String changeMethodName)  throws Exception{
		List<Dept> dList = dService.getAllDepts();
		selectHtml(dList, "id", "name", "deptid","dHtml",selectedId,changeMethodName);
		
	}

	private void companyHtml(String selectedId,String changeMethodName) throws Exception {
		List<Company> cList = cService.getAllCompanys();
		selectHtml(cList, "id", "name", "companyid","cHtml",selectedId,changeMethodName);
	}
	
	@Action(value="modify",results={
			@Result(name="success",location="/sub_success.jsp"),
			@Result(name="fail",location="/msg.jsp")})
	public String modify(){
		try {
			
			userService.update(user);
			operateRecord(Messages.MODIFY_USER+user.getName(), JBLConstants.MODIFY);
		} catch(DataIntegrityViolationException dive){
			dive.printStackTrace();
			setMsg(JBLConstants.DUPLICATEUSER);
			return "fail";
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.MODIFY_FAIL);
			return "fail";
		}
		setMsg(JBLConstants.MODIFY_SUCCESS);
		return SUCCESS;
	}
	
	@Action(value="delete",results={@Result(name="success",location="/sub_success.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String delete(){
		try {
			user = userService.getUserById(user.getId());
			userService.delete(user);
			operateRecord(Messages.DELETE_USER+user.getName(), JBLConstants.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL1);
			return "fail";
		}
		setMsg(JBLConstants.DELETE_SUCCESS);
		return SUCCESS;
	} 
}
