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
import com.jbl.service.DeptService;
import com.jbl.service.PatrolService;
import com.jbl.service.SupplierService;
import com.jbl.service.TypeService;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;
import com.jbl.util.Messages;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("basePackage")
@Namespace("/patrol")
@Action(value="patrolAction")
public class PatrolAction extends BaseAction implements ModelDriven<Patrol>{

	private PatrolService patrolService;
	
	private AreaService areaService;
	
	private SupplierService supService;
	
	private DeptService deptService;
	
	public PatrolService getPatrolService() {
		return patrolService;
	}
	@Autowired
	public void setPatrolService(PatrolService patrolService) {
		this.patrolService = patrolService;
	}
	public SupplierService getSupService() {
		return supService;
	}
	@Autowired
	public void setSupService(SupplierService supService) {
		this.supService = supService;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	private TypeService typeService;
	
	public TypeService getTypeService() {
		return typeService;
	}
	@Autowired
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
	public DeptService getDeptService() {
		return deptService;
	}
	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	private Patrol patrol = new Patrol();
	@Override
	public Patrol getModel() {
		return patrol;
	}
	
	@Action(value="showpatrolpage",results={
			@Result(name="success",location="/WEB-INF/pages/patrol/show_patrol_page.jsp")})
	public String showPatrolPage(){
		try {
			User user = getCurrentUser();
			List<Type> typeList = typeService.getTypesByDeptId(user.getDeptid(),"patrol");
			selectHtml(typeList, "id", "name", "tid", "tHtml", null, "checkSelected(this.id,'span6')");
			List<Area> areaList = areaService.getAreasByPid(JBLConstants.BZ);
			selectHtml(areaList, "id", "name", "aid", "areaHTML", "", "supplierList(this.value);checkSelected(this.id,'span1')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void supplierList(){
		try {
			int areaId = Integer.parseInt(getRequest().getParameter("areaId"));
			List<Supplier> supplierList = supService.getSuppliersByAreaId(areaId);
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
			patrol.setUserId(user.getId());
			patrol.setSerialNo(JBLConstants.PREFIX_PATROL+CommonUtils.serialNo());
			patrolService.save(patrol);
			operateRecord(Messages.SAVE_CHARGE+patrol.getSerialNo(), JBLConstants.ADD);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SAVE_FAIL);
			return "fail";
		}
		setUrl("showpatrolpage!showPatrolPage.action");
		return SUCCESS;
	}
	
	@Action(value="showpatrollist",results={
			@Result(name="success",location="/WEB-INF/pages/patrol/show_patrol_list.jsp"),
			@Result(name="input_success",location="/WEB-INF/pages/patrol/show_patrol_list1.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showPatrolList(){
		Map<String,Object> params = new HashMap<String,Object>();
		User user = getCurrentUser();
		List<Patrol> palist;
		try {
			branche(user,params);
			palist = patrolService.getPatrolByParams(params,user.getChargeDepts());
			display(palist);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
		}
		return swich(user);
	}
	/**
	 * 判断角色，是否可查看详细信息。
	 * @param user
	 * @return
	 */
	private String swich(User user) {
		if(user.getChaRight())
			return "input_success";
		else
			return SUCCESS;
	}
	/**
	 * 构造查询条件
	 * @param user
	 * @param params
	 * role：1-超级管理员
	 * 		2-机构管理员
	 * 		3-部门管理员
	 * 		4-录入员
	 * 		5-查看员
	 */
	private void branche(User user, Map<String, Object> params) {
		int roleid = user.getRoleid();
		switch(roleid){
		case 1:
		case 2:
			break;
		case 3:
			params.put("ttype.tdept.id", user.getDeptid());
			break;
		case 4:
			params.put("tuser.id", user.getId());
			break;
		case 5:
			params.put("tuser.tdept.id",user.getDeptid());
			break;
		}
	}
	@Action(value="searchpatrollist",results={
			@Result(name="success",location="/WEB-INF/pages/patrol/show_patrol_list.jsp"),
			@Result(name="input_success",location="/WEB-INF/pages/patrol/show_patrol_list1.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String searchPatrolList(){
		User user = getCurrentUser();
		try {
			String add = branchRole(user);
			List<Patrol> patrolList = patrolService.getPatrolByVal(patrol.getSearchVal(),add);
			display(patrolList);
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
				add= " and pa.ttype.tdept.id = "+user.getDeptid();
				break;
			case 4:
				add = " and pa.tuser.id = "+user.getId();
				break;
			case 5:
				add = " and pa.tuser.tdept.id = "+user.getDeptid();
				break;
		}
		return add;
	}
	@Action(value="showsearchpage",results={
			@Result(name="success",location="/WEB-INF/pages/patrol/show_search_page.jsp"),
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
			@Result(name="success",location="/WEB-INF/pages/patrol/show_modifypatrol_page.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showModifyPage(){
		int id = Integer.parseInt(getRequest().getParameter("id"));
		User user = getCurrentUser();
		try {
			patrol = patrolService.getPatrolById(id);
			List<Type> typeList = null;
			if(JBLConstants.ADMINID==user.getId()){
				typeList = typeService.getTypesByDeptId(0, "patrol");
			}else
				typeList = typeService.getTypesByDeptId(patrol.getDeptId(), "patrol");
			selectHtml(typeList, "id", "name", "tid", "tHtml", patrol.getTid()+"", "checkSelected(this.id, 'span6')");
			List<Area> areaList = areaService.getAreasByPid(JBLConstants.BZ);
			selectHtml(areaList, "id", "name", "aid", "areaHTML",patrol.getAid()+"", "supplierList(this.value);checkSelected(this.id,'span1')");
			List<Supplier> suList= supService.getSuppliersByAreaId(patrol.getAid());
			selectHtml(suList, "id", "name", "sid", "suHtml", patrol.getSid()+"", null);
			getRequest().setAttribute("patrol", patrol);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.MODIFY_FAIL);
			return "fail";
		}
		
		return SUCCESS;
	}
	
	@Action(value="modify",results={@Result(name="success",location="/sub_success.jsp"),@Result(name="fail",location="/msg.jsp")})
	public String modify(){
		try {
			if(CommonUtils.isNull(patrol.getSerialNo())){
				patrol.setSerialNo(JBLConstants.PREFIX_PATROL+CommonUtils.serialNo());
			}
			patrolService.update(patrol);
			operateRecord(Messages.MODIFY_PATROL+patrol.getSerialNo(), JBLConstants.MODIFY);
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
			patrol = patrolService.getPatrolById(patrol.getId());
			patrolService.delete(patrol);
			operateRecord(Messages.DELETE_PATROL+patrol.getSerialNo(), JBLConstants.DELETE);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.DELETE_FAIL);
			return "fail";
		}
		setMsg(JBLConstants.DELETE_SUCCESS);
		return SUCCESS;
	}
	
	@Action(value="showpatrol",results={
			@Result(name="success",location="/WEB-INF/pages/patrol/show_patrol.jsp"),
			@Result(name="fail",location="/msg.jsp")
	})
	public String showPatrol(){
		try {
			Integer id = Integer.parseInt(getRequest().getParameter("id"));
			patrol = patrolService.getPatrolById(id);
			getRequest().setAttribute("patrol", patrol);
		} catch (Exception e) {
			e.printStackTrace();
			setMsg(JBLConstants.SEARCH_FAIL);
			return "fail";
		}
		return SUCCESS;
	}
}
