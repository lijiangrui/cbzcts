package com.jbl.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Role;
import com.jbl.service.RoleService;
import com.jbl.util.JBLConstants;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/role")
@Action(value="roleAction")
public class RoleAction extends BaseAction implements ModelDriven<Role>{

	private static final Logger logger = Logger.getLogger(DeptAction.class);
	
	private static final long serialVersionUID = 1L;
	Role role = new Role();
	@Override
	public Role getModel() {
		return role;
	}
	
	private RoleService roleService;
	public RoleService getRoleService() {
		return roleService;
	}
	
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@Action(value="showroles",results={
			@Result(name="success",location="/WEB-INF/pages/role/show_roles_page.jsp")
	})
	public String showRoles(){
		try {
			List<Role> roleList = roleService.getAllRoles();
			selectHtml(roleList, "id", "name", "roleId", "rHTML", null, null);
			display(roleList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	@Action(value="save",results={
			@Result(name="success",location="/WEB-INF/pages/role/show_roles_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String save(){
		try {
			roleService.save(role);
		} catch (Exception e) {
			e.printStackTrace();
			getRequest().setAttribute("msg", JBLConstants.SHOW_COMPANY_FAIL);
			return "fail";
		}
		return showRoles();
	}
	
	@Action(value="showmodifypage",results={@Result(name="success",location="/WEB-INF/pages/role/show_modifyrole_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showModifyPage(){
		int id = Integer.parseInt(getRequest().getParameter("id"));
		Role role ;
		try {
			role = roleService.getRoleById(id);
			getRequest().setAttribute("role", role);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SHOW_COMPANY_FAIL);
			return "fail";
		}
		
		return SUCCESS;
	}
	
	@Action(value="modify",results={@Result(name="success",location="/sub_success.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String modify(){
		try {
			roleService.update(role);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.MODIFY_FAIL);
			return "fail";
		}
		setMsg(JBLConstants.MODIFY_SUCCESS);
		return SUCCESS;
	}

}
