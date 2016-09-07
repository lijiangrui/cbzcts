package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.CompanyDAO;
import com.jbl.dao.DeptDAO;
import com.jbl.model.Tcompany;
import com.jbl.model.Tdept;
import com.jbl.pagemodel.Dept;
import com.jbl.service.DeptService;
import com.jbl.util.CommonUtils;

@Service(value="deptService")
public class DeptServiceImpl implements DeptService {
	
	private DeptDAO deptDAO;
	private CompanyDAO companyDAO;
	@Override
	public List<Dept> getAllDepts() throws Exception {
		String hql = "from Tdept td where td.deltriger = 0";
		List<Tdept> dList = deptDAO.find(hql);
		List<Dept> list = new ArrayList<Dept>();
		if(!CommonUtils.isNull(dList)){
			for(Tdept tdept : dList){
				Dept dept = new Dept();
				BeanUtils.copyProperties(tdept, dept);
				if(CommonUtils.isNotNull(tdept.getTcompany())){
					dept.setCompanyId(tdept.getTcompany().getId());
					dept.setCompanyName(tdept.getTcompany().getName());
				}
				if(CommonUtils.isNotNull(tdept.getTdept())){
					dept.setDeptId(tdept.getTdept().getId());
					dept.setDeptName(tdept.getTdept().getName());
				}
				list.add(dept);
			}
		}
		return list;
	}

	public DeptDAO getDeptDAO() {
		return deptDAO;
	}
	@Autowired
	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}
	@Autowired
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	@Override
	public List<Dept> getDeptsByParams(Map<String, Object> params) throws Exception {
		String hql = "from Tdept td where td.deltriger=0 ";
		if(CommonUtils.isNotNull(params)){
			for(String key : params.keySet()){
				hql += " and tt."+key+"=:"+key;
			}
		}
		List<Tdept> tdeptList = deptDAO.find(hql, params);
		return deptList(tdeptList);
	}

	private List<Dept> deptList(List<Tdept> tdeptList) {
		List<Dept> deptList = new ArrayList<Dept>();
		if(CommonUtils.isNotNull(tdeptList)){
			for(Tdept tdept: tdeptList){
				Dept dept = new Dept();
				BeanUtils.copyProperties(tdept, dept);
				if(CommonUtils.isNotNull(tdept.getTcompany())){
					dept.setCompanyId(tdept.getTcompany().getId());
					dept.setCompanyName(tdept.getTcompany().getName());
				}
				deptList.add(dept);
			}
		}
		return deptList;
	}

	@Override
	public void save(Dept dept) throws Exception {
		Tdept tdept = new Tdept();
		BeanUtils.copyProperties(dept, tdept);
		int companyId = dept.getCompanyId();
		int deptId = dept.getDeptId();
		Tcompany tc = companyDAO.get(Tcompany.class,companyId);
		Tdept td = deptDAO.get(Tdept.class, deptId);
		tdept.setTcompany(tc);
		tdept.setTdept(td);
		
		deptDAO.save(tdept);
	}

	@Override
	public Dept getDeptById(int id) throws Exception {
		Tdept tdept = deptDAO.get(Tdept.class, id);
		Dept dept = new Dept();
		BeanUtils.copyProperties(tdept, dept);
		if(CommonUtils.isNotNull(tdept.getTcompany())){
			dept.setCompanyId(tdept.getTcompany().getId());
			dept.setCompanyName(tdept.getTcompany().getName());
		}
		if(CommonUtils.isNotNull(tdept.getTdept())){
			dept.setDeptId(tdept.getTdept().getId());
			dept.setDeptName(tdept.getTdept().getName());
		}
		return dept;
	}

	@Override
	public void update(Dept dept) throws Exception {
		Tdept tdept = deptDAO.get(Tdept.class, dept.getId());
		tdept.setName(dept.getName());
		int companyId = dept.getCompanyId();
		int deptId = dept.getDeptId();
		Tcompany pcompany = companyDAO.get(Tcompany.class, companyId);
		Tdept pdept = deptDAO.get(Tdept.class,deptId);
		tdept.setTcompany(pcompany);
		tdept.setTdept(pdept);
		deptDAO.saveOrUpdate(tdept);
	}

	@Override
	public void delete(Dept dept) throws Exception {
		Tdept tdept = deptDAO.get(Tdept.class,dept.getId());
		tdept.setDeltriger(true);
		deptDAO.update(tdept);
	}

	@Override
	public List<Dept> getAllDeptsExp(Integer id) throws Exception {
		String hql = "from Tdept td where td.deltriger = 0 and td.id != :id";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("id", id);
		List<Tdept> tdList = deptDAO.find(hql, params);
		return deptList(tdList);
	}

	@Override
	public List<Dept> getAllDeptsExpName(String office) throws Exception {
		String hql = "from Tdept td where td.deltriger = 0 and td.name != :name";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", office);
		List<Tdept> tdList = deptDAO.find(hql, params);
		return deptList(tdList);
	}

	@Override
	public List<Dept> getDeptsByPid(int id) throws Exception {
		Tdept td = deptDAO.get(Tdept.class, id);
		Set<Tdept> tds = td.getTdepts();
		List<Dept> deptList = change(tds);
		return deptList;
	}

	private List<Dept> change(Set<Tdept> tds) {
		Iterator it = tds.iterator();
		List<Dept> deptList = new ArrayList<Dept>();
		while(it.hasNext()){
			Tdept t = (Tdept) it.next();
			Dept dept = new Dept();
			BeanUtils.copyProperties(t, dept);
			deptList.add(dept);
		}
		return deptList;
	}
	
}
