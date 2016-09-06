package com.jbl.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.jbl.pagemodel.Area;
import com.jbl.service.AreaService;

@ParentPackage("basePackage")
@Namespace("/company")
@Action("companyAction")
public class CompanyAction extends BaseAction {

	private AreaService areaService;
	
	public AreaService getAreaService() {
		return areaService;
	}
	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	@Action(value="showcompanypage",results={@Result(name="success",location="/WEB-INF/pages/company/show_company_page.jsp")})
	public String showCompanyPage(){
		List<Area> areaList;
		try {
			areaList = areaService.getAreasByPid(1);
			areaHTML(areaList,"id","name","areaId","areaHTML","");
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="showcompanylist",results={@Result(name="success",location="/WEB-INF/pages/company/show_companys_list.jsp")})
	public String showCompanyList(){
		
		return SUCCESS;
	}
	private void areaHTML(List<Area> areaList, String key, String value,String id,String htmlName, String changeMethodName) {
		selectHtml(areaList, key, value, id, htmlName, "", changeMethodName);
	}
	
}
