package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.DeptDAO;
import com.jbl.dao.TypeDAO;
import com.jbl.model.Tdept;
import com.jbl.model.Ttype;
import com.jbl.pagemodel.Type;
import com.jbl.service.TypeService;
import com.jbl.util.CommonUtils;
import com.jbl.util.JBLConstants;

@Service(value="typeService")
public class TypeServiceImpl implements TypeService {

	private TypeDAO typeDAO;
	
	public TypeDAO getTypeDAO() {
		return typeDAO;
	}
	@Autowired
	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	private DeptDAO deptDAO;
	

	public DeptDAO getDeptDAO() {
		return deptDAO;
	}
	@Autowired
	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	@Override
	public List<Type> getTypesByDeptId(int deptId,String typ) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		String hql = "from Ttype tt where tt.type='"+typ+"' ";
		if(deptId != JBLConstants.ADMINDEPTID){
			params.put("deptId", deptId);
			hql += "and tt.tdept.id=:deptId";
		}
		List<Ttype> ttList = typeDAO.find(hql, params);
		List<Type> tList = new ArrayList<Type>();
		if(!CommonUtils.isNull(ttList)){
			for(Ttype tt : ttList){
				Type type= new Type();
				BeanUtils.copyProperties(tt, type);
				type.setDeptId(tt.getTdept().getId());
				tList.add(type);
			}
		}
		return tList;
	}
	@Override
	public List<Type> getTypesByParams(Map<String,Object> params) throws Exception {
		String hql = "from Ttype tt where tt.deltriger=0 ";
		if(CommonUtils.isNotNull(params)){
			for(String key : params.keySet()){
				if("deptId".equals(key)){
					hql +=" and (tt.tdept.id=:"+key + " or tt.tdept.tdept.id=:"+key+")";
				}else{
					hql += " and tt."+key+"=:"+key;
				}
			}
		}
		List<Ttype> ttypeList = typeDAO.find(hql, params);
		List<Type> typeList = new ArrayList<Type>();
		return copyProp(ttypeList, typeList);
	}
	private List<Type> copyProp(List<Ttype> ttypeList, List<Type> typeList) {
		if(CommonUtils.isNotNull(ttypeList)){
			for(Ttype ttype: ttypeList){
				Type type = new Type();
				BeanUtils.copyProperties(ttype, type);
				type.setDeptId(ttype.getTdept().getId());
				type.setDeptName(ttype.getTdept().getName());
				typeList.add(type);
			}
		}
		return typeList;
	}
	@Override
	public List<Type> getAllTypes(String type) throws Exception {
		String hql = "from Ttype tt where tt.type='"+type+"' order by tt.tdept.id asc";
		List<Ttype> ttypeList = typeDAO.find(hql);
		List<Type> typeList = new ArrayList<Type>();
		return copyProp(ttypeList, typeList);
	}
	@Override
	public void save(Type type) throws Exception {
		Ttype ttype = new Ttype();
		BeanUtils.copyProperties(type, ttype);
		Tdept tdept = deptDAO.get(Tdept.class, type.getDeptId());
		ttype.setTdept(tdept);
		typeDAO.save(ttype);
	}
	@Override
	public Type getTypeById(int id) throws Exception {
		Ttype tt = typeDAO.get(Ttype.class, id);
		Type type = new Type();
		BeanUtils.copyProperties(tt, type);
		type.setDeptId(tt.getTdept().getId());
		type.setDeptName(tt.getTdept().getName());
		return type;
	}
	@Override
	public void update(Type type) throws Exception {
		Ttype tt = new Ttype();
		BeanUtils.copyProperties(type, tt);
		Tdept dept = deptDAO.get(Tdept.class, type.getDeptId());
		tt.setTdept(dept);
		typeDAO.saveOrUpdate(tt);
	}
	@Override
	public void delete(Type type) throws Exception {
		Ttype tt = typeDAO.get(Ttype.class, type.getId());
		typeDAO.remove(tt);
	}

}
