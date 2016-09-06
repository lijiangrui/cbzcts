package com.jbl.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jbl.model.Tcharge;
import com.jbl.model.Tpatrol;
import com.jbl.model.Tsupplier;
import com.jbl.pagemodel.Area;
import com.jbl.pagemodel.Company;
import com.jbl.pagemodel.Dept;
import com.jbl.pagemodel.Patrol;
import com.jbl.pagemodel.Role;
import com.jbl.pagemodel.Supplier;
import com.jbl.pagemodel.User;
import com.jbl.service.AreaService;
import com.jbl.service.SupplierService;
import com.jbl.util.DownloadFileHelper;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/supplier")
@Action(value="supplierAction")
@Results({
	@Result(name="success",location="/WEB-INF/pages/supplier/add_supplier_page.jsp"),
	@Result(name="fail",location="/msg.jsp")
	
})
/**
 * 企业Action
 * @author Administrator
 *
 */
public class SupplierAction extends BaseAction implements ModelDriven<Supplier>{

	private Supplier supplier = new Supplier();
	@Override
	public Supplier getModel() {
		return supplier;
	}
	
	private SupplierService sprService;
	
	private AreaService areaService;
	
	public SupplierService getSprService() {
		return sprService;
	}
	@Autowired
	public void setSprService(SupplierService sprService) {
		this.sprService = sprService;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@Action(value="showsupplierpage",results={@Result(name="success",location="/WEB-INF/pages/supplier/show_supplier_page.jsp")})
	public String showSupplierPage(){
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
	
	@Action(value="showsupplierlist",results={
			@Result(name="success",location="/WEB-INF/pages/supplier/show_suppliers_list.jsp"),
			@Result(name="fail",location="/msg.jsp")})
	public String showSupplierList(){
		int areaId = Integer.parseInt(getRequest().getParameter("areaId"));
		List<Supplier> sprList;
		try {
			sprList = sprService.getSuppliersByAreaId(areaId);
			display(sprList);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="searchsupplierlist",results={
			@Result(name="success",location="/WEB-INF/pages/supplier/show_suppliers_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchSupplierList(){
		try {
			List<Supplier> supplierList = sprService.getSupplierByVal(supplier.getSearchVal());
			display(supplierList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}
	
	private void areaHTML(List<Area> areaList, String key, String value,String id,String htmlName, String changeMethodName) {
		selectHtml(areaList, key, value, id, htmlName, "", changeMethodName);
	}
	@Action(value="save",results={
			@Result(name="success",location="/savesuccess.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String save(){
		try {
			sprService.save(supplier);
			operateRecord(Messages.SAVE_SUPPLIER+supplier.getName(), JBLConstants.ADD);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SAVE_FAIL);
			return "fail";
		}
		setUrl("showsupplierpage!showSupplierPage.action");
		return SUCCESS;
	}

	@Action(value="showimportpage",results={
			@Result(name="success",location="/WEB-INF/pages/supplier/import_supplier_page.jsp")
	})
	public String showImportPage(){
		
		return SUCCESS;
	}
	
	@Action(value="downloadtemplate")
	public void downloadTemplate(){
		String alertMsg = "<script type='text/javascript'>alert('下载文件');</script>"; 
		try {
			String absoluteFileName = path();
			DownloadFileHelper helper = new DownloadFileHelper(absoluteFileName);
			helper.download("企业档案导入模板.xls", "bin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String path() {
		String path = getRealPath();
		path += "templates/template_supplier.xls";
		return path;
	}
	
	public void saveTemplate(){
		try {
			String templateName = getRequest().getParameter("templateName");
			User user = getCurrentUser();
			sprService.saveTemplate(user.getId(),templateName,supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Action(value="showmodifypage",results={@Result(name="success",location="/WEB-INF/pages/supplier/show_modifysupplier_page.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String showModifyPage(){
		try {
			Supplier u = sprService.getSupplierById(supplier.getId());
			areaHTML(u.getAreaId()+"",null);
			getRequest().setAttribute("supplier", u);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SHOW_COMPANY_FAIL);
			return "fail";
		}
		return SUCCESS;
	}

	private void areaHTML(String selectedId,String changeMethodName) throws Exception{
		List<Area> aList = areaService.getAreasByPid(JBLConstants.BZ);
		selectHtml(aList, "id", "name", "areaId","areaHTML",selectedId,changeMethodName);
	}

	@Action(value="modify",results={@Result(name="success",location="/sub_success.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String modify(){
		try {
			
			sprService.update(supplier);
			operateRecord(Messages.MODIFY_SUPPLIER+supplier.getName(), JBLConstants.MODIFY);
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
			sprService.delete(supplier);
			operateRecord(Messages.DELETE_SUPPLIER+supplier.getName(), JBLConstants.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL1);
			return "fail";
		}
		setMsg(JBLConstants.DELETE_SUCCESS);
		return SUCCESS;
	} 
	
	public void isExist(){
		String no = getRequest().getParameter("no");
		JSONObject obj = new JSONObject();
		try {
			obj.put("isExist", sprService.isExist(no));
			getResponse().getWriter().print(obj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Action(value="searchsupplierpage",results={
			@Result(name="success",location="/WEB-INF/pages/supplier/search_supplier_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchSupplierPage(){
		return SUCCESS;
	}
	
	@Action(value="searchlist",results={
			@Result(name="success",location="/WEB-INF/pages/supplier/search_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchList(){
		Map<String,Object> params = new HashMap<String,Object>();
		cookParams(params);
		try {
			List<Supplier> suList = sprService.getSupplierByParams(params);
			display(suList);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	private void cookParams(Map params) {
		String name = supplier.getName();
		String code = supplier.getCode();
		String license = supplier.getLicense();
		String legalPerson = supplier.getLegalPerson();
		String idNo = supplier.getIdNo();
		cookItem(params,"name",name);
		cookItem(params,"code",code);
		cookItem(params,"license",license);
		cookItem(params, "legalPerson",legalPerson);
		cookItem(params, "idNo",idNo);
	}
	private void cookItem(Map params,String key,Object value) {
		if(CommonUtils.isNotNull(value)){
			params.put(key, value);
		}
	}
	
	@Action(value="showsupplier",results={
			@Result(name="success",location="/WEB-INF/pages/supplier/show_supplier.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showSupplier(){
		try {
			int id = Integer.parseInt(getRequest().getParameter("id"));
			Supplier supplier = sprService.getSupplierById(id);
			getRequest().setAttribute("supplier", supplier);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	private void iteratorSet(Set<Tcharge> tcSet) {
		List<String> serialNoList = new ArrayList<String>();
		Iterator it = tcSet.iterator();
		while(it.hasNext()){
			Tcharge c = (Tcharge) it.next();
			serialNoList.add(c.getSerialNo());
		}
	getRequest().setAttribute("cList", serialNoList);
	}
	private void iteratorSet1(Set<Tpatrol> tpSet) {
		List<String> serialNoList = new ArrayList<String>();
		Iterator it = tpSet.iterator();
		while(it.hasNext()){
			Tpatrol p = (Tpatrol) it.next();
			serialNoList.add(p.getSerialNo());
		}
	getRequest().setAttribute("pList", serialNoList);
	}
}
