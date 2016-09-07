package com.jbl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jbl.pagemodel.Area;
import com.jbl.pagemodel.Charge;
import com.jbl.pagemodel.Dept;
import com.jbl.pagemodel.Patrol;
import com.jbl.pagemodel.Supplier;
import com.jbl.pagemodel.Type;
import com.jbl.pagemodel.User;
import com.jbl.service.AreaService;
import com.jbl.service.ChargeService;
import com.jbl.service.DeptService;
import com.jbl.service.PatrolService;
import com.jbl.service.SupplierService;
import com.jbl.service.TypeService;
import com.jbl.util.Constants;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.tools.internal.ws.processor.model.Message;

@ParentPackage("basePackage")
@Namespace("/charge")
@Action(value="chargeAction")
public class ChargeAction extends BaseAction implements ModelDriven<Charge>{

	private ChargeService chargeService;
	
	private SupplierService supService;
	
	private TypeService typeService;
	
	private AreaService areaService;
	
	private DeptService deptService;
	
	public ChargeService getChargeService() {
		return chargeService;
	}
	@Autowired
	public void setChargeService(ChargeService chargeService) {
		this.chargeService = chargeService;
	}
	public SupplierService getSupService() {
		return supService;
	}
	@Autowired
	public void setSupService(SupplierService supService) {
		this.supService = supService;
	}
 
	public TypeService getTypeService() {
		return typeService;
	}
	@Autowired
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	public AreaService getAreaService() {
		return areaService;
	}
	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	

	public DeptService getDeptService() {
		return deptService;

	}
	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}





	private Charge charge = new Charge();
	@Override
	public Charge getModel() {
		return charge;
	}
	
	@Action(value="showcharge",results={
			@Result(name="success",location="/WEB-INF/pages/charge/show_charge.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showCharge(){
		Integer id = Integer.parseInt(getRequest().getParameter("id"));
		Charge cha;
		try {
			cha = chargeService.getChargeById(id);
			getRequest().setAttribute("charge",cha);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	@Action(value="showchargepage",results={
			@Result(name="success",location="/WEB-INF/pages/charge/show_charge_page.jsp"),
			@Result(name="fail",location="/msg.jsp")})
	public String showChargePage(){
		try {
			User user = getCurrentUser();
			List<Type> typeList = typeService.getTypesByDeptId(user.getDeptid(),"charge");
			selectHtml(typeList, "id", "name", "tid", "tHtml", null, "checkSelected(this.id,'span6')");
			List<Area> areaList = areaService.getAreasByPid(JBLConstants.BZ);
			selectHtml(areaList, "id", "name", "aid", "areaHTML", "", "supplierList(this.value);checkSelected(this.id,'span1')");
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
	
	public void supplierList(){
		try {
			int areaId = Integer.parseInt(getRequest().getParameter("areaId"));
			List<Supplier> supplierList = supService.getSuppliersByAreaId(areaId);
			selectHtml(supplierList, "id", "name", "sid", "supplierHTML", "", "checkSelected(this.id,'span2')");
			String supplierHTML = (String) getRequest().getAttribute("supplierHTML");
			print2json(supplierList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void supplierJSON(){
		int areaId = Integer.parseInt(getRequest().getParameter("areaId"));
		try {
			List<Supplier> supplierList = supService.getSuppliersByAreaId(areaId);
			JSONArray jsonArray = new JSONArray();
			if(CommonUtils.isNotNull(supplierList)){
				for(Supplier su : supplierList){
					JSONObject obj = new JSONObject();
					obj.put("title", su.getName());
					obj.put("id", su.getId());
					jsonArray.add(obj);
				}
			}
			getResponse().getWriter().print(jsonArray.toJSONString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Action(value="save",results={
			@Result(name="success",location="/savesuccess.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String save(){
		try {
			User user = getCurrentUser();
			charge.setUserId(user.getId());
			charge.setSerialNo(JBLConstants.PREFIX_CHARGE+CommonUtils.serialNo());
			chargeService.save(charge);
			operateRecord(Messages.SAVE_CHARGE+charge.getSerialNo(), JBLConstants.ADD);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SAVE_FAIL);
			return "fail";
		}
		setUrl("showchargepage!showChargePage.action");
		return SUCCESS;
	}
	
	@Action(value="showchargelist",results={
			@Result(name="success",location="/WEB-INF/pages/charge/show_charge_list.jsp"),
			@Result(name="input_success",location="/WEB-INF/pages/charge/show_charge_list1.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showChargeList(){
		Map<String,Object> params = new HashMap<String,Object>();
		User user = getCurrentUser();
		List<Charge> calist;
		try {
			branche(user,params);
			calist = chargeService.getChargeByParams(params,user.getChargeDepts());
			display(calist);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
		}
		
		return swich(user);
	}
	private String swich(User user) {
		if(user.getChaRight())
			return "input_success";
		else
			return SUCCESS;
	}
	private void branche(User user, Map<String, Object> params) {
		int roleid = user.getRoleid();
		switch(roleid){
		case 1:
			break;
		case 2:
			break;
		case 3:
			params.put("ttype.tdept.id", user.getDeptid());
			break;
		case 4:
			params.put("tuser.id", user.getId());
			break;
		case 5:
			params.put("tuser.tdept.id", user.getDeptid());
			break;
		default:
			
		}
	}
	@Action(value="searchchargelist",results={
			@Result(name="success",location="/WEB-INF/pages/charge/show_charge_list.jsp"),
			@Result(name="input_success",location="/WEB-INF/pages/charge/show_charge_list1.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchChargeList(){
		User user = getCurrentUser();
		try {
			String add = branchRole(user);
			List<Charge> chargeList = chargeService.getChargeByVal(charge.getSearchVal(),add);
			display(chargeList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return swich(user);
	}
	private String branchRole(User user) {
		int roleId = user.getRoleid();
		String add = "";
		switch(roleId){
			case 1:
			case 2:
				break;
			case 3:
				add= "and pa.ttype.tdept.id = "+user.getDeptid();
				break;
			case 4:
				add = "and pa.userId = "+user.getId();
				break;
			case 5:
				add = "and pa.tdept.id = "+user.getDeptid();
				break;
		}
		return add;
	}
	
	@Action(value="showsearchpage",results={
			@Result(name="success",location="/WEB-INF/pages/charge/show_search_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showSearchPage(){
		
		return SUCCESS;
	}
	@Action(value="showsearchlist",results={
			@Result(name="success",location="/WEB-INF/pages/patrol/show_search_list.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showSearchList(){
		
		return SUCCESS;
	}
	
	@Action(value="showmodifypage",results={
			@Result(name="success",location="/WEB-INF/pages/charge/show_modifycharge_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showModifyPage(){
		int id = Integer.parseInt(getRequest().getParameter("id"));
		User user = getCurrentUser();
		try {
			Charge charge = chargeService.getChargeById(id);
			List<Type> typeList = null;
			if(JBLConstants.ADMINID==user.getId()){
				typeList = typeService.getTypesByDeptId(0, "charge");
			}else
				typeList = typeService.getTypesByDeptId(charge.getDeptId(), "charge");
			selectHtml(typeList, "id", "name", "tid", "tHtml", charge.getTid()+"", "checkSelected(this.id, 'span6')");
			List<Area> areaList = areaService.getAreasByPid(JBLConstants.BZ);
			selectHtml(areaList, "id", "name", "aid", "areaHTML",charge.getAid()+"", "supplierList(this.value);checkSelected(this.id,'span1')");
			List<Supplier> suList= supService.getSuppliersByAreaId(charge.getAid());
			selectHtml(suList, "id", "name", "sid", "suHtml", charge.getSid()+"", null);
			getRequest().setAttribute("charge", charge);
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
			chargeService.update(charge);
			operateRecord(Messages.MODIFY_CHARGE+charge.getSerialNo(), JBLConstants.MODIFY);
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
			charge = chargeService.getChargeById(charge.getId());
			chargeService.delete(charge);
			operateRecord(Messages.DELETE_CHARGE+charge.getSerialNo(), JBLConstants.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL);
			return "fail";
		}
		setMsg(JBLConstants.DELETE_SUCCESS);
		return SUCCESS;
	}
}
