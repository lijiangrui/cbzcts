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
import com.jbl.service.CompanyService;
import com.jbl.service.DeptService;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.codemodel.internal.JBlock;

@ParentPackage("basePackage")
@Namespace("/dept")
@Action(value="deptAction")
@Results({
	@Result(name="showdeptlist", location="/WEB-INF/pages/common/show_dept_list.jsp")
})
public class DeptAction extends BaseAction implements ModelDriven<Dept> {
	private static final long serialVersionUID = 1L;

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DeptAction.class);

	private DeptService deptService;
	
	private CompanyService cService;
	
	private Dept dept = new Dept();
	@Override
	public Dept getModel() {
		
		return dept;
	}
	
	public DeptService getDeptService() {
		return deptService;
	}
	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public CompanyService getcService() {
		return cService;
	}
	@Autowired
	public void setcService(CompanyService cService) {
		this.cService = cService;
	}
	public String showDeptList(){
		try{
			Map<String,Object> params = new HashMap<String,Object>();
			List<Dept> deptList = deptService.getDeptsByParams(params);
			int count = 0;
			if(CommonUtils.isNotNull(deptList)){
				count= deptList.size();
			}
			getRequest().setAttribute("total", count);
			getRequest().setAttribute("resultList", deptList);
			getRequest().setAttribute("pagesize", JBLConstants.PAGESIZE);
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		return "showdeptlist";
	}
	
	@Action(value="showdepts",results={@Result(name="success",location="/WEB-INF/pages/dept/show_depts_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showDepts() {
		try {
			List<Dept> dList = deptService.getAllDepts();
			List<Company> cList = cService.getAllCompanys();
			selectHtml(cList,"id","name","companyId", "cHtml", null, null);
			selectHtml(dList,"id","name","deptId", "dHtml", null, null);
			display(dList);
		} catch (Exception e) {
			e.printStackTrace();
			getRequest().setAttribute("msg", JBLConstants.SHOW_COMPANY_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="save",results={@Result(name="success",location="/WEB-INF/pages/dept/show_depts_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String save(){
		
		try {
			String no = makeNo();
			dept.setNo(no);
			deptService.save(dept);
			operateRecord(Messages.SAVE_DEPT+dept.getName(), JBLConstants.ADD);
		} catch (Exception e) {
			e.printStackTrace();
			getRequest().setAttribute("msg", JBLConstants.SAVE_FAIL);
			return "fail";
		}
		return showDepts();
	}
	
	private String makeNo() throws Exception {
		List<Dept> allList = deptService.getAllDepts();
		int num ;
		if(CommonUtils.isNull(allList))num = 1;
		else num = allList.size()+1;
		String no = "000"+num;
		no = no.substring(no.length()-4,no.length());
		return "BZ"+no;
	}

	@Action(value="showmodifypage",results={@Result(name="success",location="/WEB-INF/pages/dept/show_modifydept_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showModifyPage(){
		int id = Integer.parseInt(getRequest().getParameter("id"));
		Dept de;
		try {
			de = deptService.getDeptById(id);
			List<Company> cList = cService.getAllCompanys();
			List<Dept> dList = deptService.getAllDeptsExp(de.getId());
			selectHtml(cList,"id","name","companyId", "cHtml", de.getCompanyId()+"", null);
			selectHtml(dList,"id","name","deptId", "dHtml", de.getDeptId()+"", null);
			getRequest().setAttribute("dept", de);
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
			deptService.update(dept);
			operateRecord(Messages.MODIFY_DEPT+dept.getName(), JBLConstants.MODIFY);
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
			dept = deptService.getDeptById(dept.getId());
			deptService.delete(dept);
			operateRecord(Messages.DELETE_DEPT+dept.getName(), JBLConstants.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL1);
			return "fail";
		}
		setMsg(JBLConstants.DELETE_SUCCESS);
		return SUCCESS;
	} 
}
