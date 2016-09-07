package com.jbl.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Company;
import com.jbl.pagemodel.Dept;
import com.jbl.pagemodel.Type;
import com.jbl.service.DeptService;
import com.jbl.service.TypeService;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/type")
@Action(value="typeAction")
@Results({
	@Result(name="showtypelist", location="/WEB-INF/pages/common/show_type_list.jsp")
})
public class TypeAction extends BaseAction implements ModelDriven<Type> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TypeAction.class);

	private Type type = new Type();
	@Override
	public Type getModel() {
		
		return type;
	}
	private TypeService typeService;
	
	public TypeService getTypeService() {
		return typeService;
	}
	@Autowired
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	private DeptService deptService;
	
	public DeptService getDeptService() {
		return deptService;
	}
	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	public String showTypeList(){
		try{
			Map<String,Object> params = new HashMap<String,Object>();
			List<Type> typeList = typeService.getTypesByParams(params);
			int count = 0;
			if(CommonUtils.isNotNull(typeList)){
				count= typeList.size();
			}
			getRequest().setAttribute("total", count);
			getRequest().setAttribute("resultList", typeList);
			getRequest().setAttribute("pagesize", JBLConstants.PAGESIZE);
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		return "showtypelist";
	}
	@Action(value="showtypes",results={@Result(name="success",location="/WEB-INF/pages/type/show_types_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showTypes(){
		String type = getRequest().getParameter("type");
		getRequest().setAttribute("type", type);
		try{
			List<Type> typeList = typeService.getAllTypes(type);
			List<Dept> deptList = deptService.getAllDepts();
			selectHtml(typeList, "id", "name", "typeId", "tHtml", null, null);
			selectHtml(deptList, "id", "name", "deptId", "dHtml", null, null);
			display(typeList);
		}catch(Exception e){
			getRequest().setAttribute("msg", JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	@Action(value="save",results={@Result(name="success",location="/WEB-INF/pages/type/show_types_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String save(){
		
		try {
			typeService.save(type);
			operateRecord(Messages.SAVE_TYPE+type.getName(), JBLConstants.ADD);
		} catch (Exception e) {
			e.printStackTrace();
			getRequest().setAttribute("msg", JBLConstants.SAVE_FAIL);
			return "fail";
		}
		return showTypes();
	}
	
	@Action(value="showmodifypage",results={@Result(name="success",location="/WEB-INF/pages/type/show_modifytype_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showModifyPage(){
		int id = Integer.parseInt(getRequest().getParameter("id"));
		Type t;
		try {
			t = typeService.getTypeById(id);
			List<Dept> dList = deptService.getAllDepts();
			selectHtml(dList,"id","name","deptId", "dHtml", t.getDeptId()+"", null);
			getRequest().setAttribute("type", t);
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
			typeService.update(type);
			operateRecord(Messages.MODIFY_TYPE+type.getName(), JBLConstants.MODIFY);
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
			typeService.delete(type);
			operateRecord(Messages.DELETE_TYPE+type.getName(), JBLConstants.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL1);
			return "fail";
		}
		setMsg(JBLConstants.DELETE_SUCCESS);
		return SUCCESS;
	} 
	
}
