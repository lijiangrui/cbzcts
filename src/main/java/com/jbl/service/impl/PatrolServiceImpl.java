package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.DeptDAO;
import com.jbl.dao.PatrolDAO;
import com.jbl.dao.SupplierDAO;
import com.jbl.dao.TypeDAO;
import com.jbl.dao.UserDAO;
import com.jbl.model.Tdept;
import com.jbl.model.Tpatrol;
import com.jbl.model.Tsupplier;
import com.jbl.model.Ttype;
import com.jbl.model.Tuser;
import com.jbl.pagemodel.Patrol;
import com.jbl.service.PatrolService;
import com.jbl.util.CommonUtils;

@Service(value="patrolService")
public class PatrolServiceImpl implements PatrolService {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private PatrolDAO patrolDAO;
	
	private TypeDAO typeDAO;
	
	private SupplierDAO supplierDAO;
	
	private DeptDAO deptDAO;
	
	private UserDAO userDAO;
	
	public PatrolDAO getPatrolDAO() {
		return patrolDAO;
	}
	@Autowired
	public void setPatrolDAO(PatrolDAO patrolDAO) {
		this.patrolDAO = patrolDAO;
	}

	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}
	@Autowired
	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}
	
	public TypeDAO getTypeDAO() {
		return typeDAO;
	}
	@Autowired
	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	public DeptDAO getDeptDAO() {
		return deptDAO;
	}
	@Autowired
	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public void save(Patrol patrol) throws Exception {
		Tpatrol tp = new Tpatrol();
		reverseCopy(patrol, tp);
		patrolDAO.save(tp);
	}
	private void reverseCopy(Patrol patrol, Tpatrol tp) throws Exception {
		BeanUtils.copyProperties(patrol, tp);
		Ttype type = typeDAO.get(Ttype.class,patrol.getTid());
		Tsupplier ts = supplierDAO.get(Tsupplier.class, patrol.getSid());
		Tuser tuser = userDAO.get(Tuser.class,patrol.getUserId());
		tp.setCreateTime(new Date());
		tp.setTtype(type);
		tp.setTsupplier(ts);
		tp.setTuser(tuser);
	}
	@Override
	public List<Patrol> getPatrolByParams(Map<String, Object> params,String chargeDepts) throws Exception {
		String hql = "from Tpatrol pa where 1=1 ";
		if(CommonUtils.isNotNull(params)){
			Iterator it = params.keySet().iterator();
			while(it.hasNext()){
				String key = (String)it.next();
				String keyStr = key.substring(key.length()-1,key.length());
				hql += " and pa."+key+" =:"+keyStr;
				params.put(keyStr, params.get(key));
				params.remove(key);
			}
		}
		if(CommonUtils.isNotNull(chargeDepts)){
			chargeDepts = chargeDepts.replace(",", "','");
			hql +=" or pa.tuser.tdept.id in ('"+chargeDepts+"')";
		}
		return getPtrols(params, hql);
	}
	private List<Patrol> getPtrols(Map<String, Object> params, String hql) throws Exception {
		hql +=" order by pa.createTime desc";
		List<Tpatrol> tpalist = patrolDAO.find(hql, params);
		List<Patrol> palist = new ArrayList<Patrol>();
		if(CommonUtils.isNull(tpalist))return null;
		copyProperties(tpalist, palist);
		return palist;
	}
	private List<Patrol> getPtrols(String hql) throws Exception {
		hql +=" order by pa.createTime desc";
		List<Tpatrol> tpalist = patrolDAO.find(hql);
		List<Patrol> palist = new ArrayList<Patrol>();
		if(CommonUtils.isNull(tpalist))return null;
		copyProperties(tpalist, palist);
		return palist;
	}
	private void copyProperties(List<Tpatrol> tpalist, List<Patrol> palist) {
		for(Tpatrol tpa : tpalist){
			Patrol pa = copyObj(tpa);
			palist.add(pa);
		}
	}
	private Patrol copyObj(Tpatrol tpa) {
		Patrol pa = new Patrol();
		BeanUtils.copyProperties(tpa, pa);
		pa.setTid(tpa.getTtype().getId());
		pa.setTypeName(tpa.getTtype().getName());
		pa.setAid(tpa.getTsupplier().getTarea().getId());
		pa.setAreaName(tpa.getTsupplier().getTarea().getName());
		pa.setSid(tpa.getTsupplier().getId());
		pa.setSupplierName(tpa.getTsupplier().getName());
		if(CommonUtils.isNotNull(tpa.getTuser().getTdept())){
			pa.setDeptId(tpa.getTuser().getTdept().getId());
			pa.setDeptName(tpa.getTuser().getTdept().getName());
			pa.setDeptNo(tpa.getTuser().getTdept().getNo());
		}
		pa.setUserId(tpa.getTuser().getId());
		pa.setUserName(tpa.getTuser().getName());
		return pa;
	}
	@Override
	public List<Patrol> getPatrolByVal(String searchVal,String add) throws Exception {
		searchVal = "'%"+searchVal.trim()+"%'";
		String hql = "from Tpatrol pa where 1=1 " +
				" and (pa.tsupplier.tarea.name like "+searchVal +
				" or pa.tsupplier.name like "+searchVal +
				" or pa.content like "+searchVal +
				" or pa.serialNo like "+searchVal +
				" or pa.result like "+searchVal+")" +
				add;
		logger.info("searchVal : "+searchVal);
		return getPtrols(hql);
	}
	@Override
	public Patrol getPatrolById(int id) throws Exception {
		Tpatrol tp = patrolDAO.get(Tpatrol.class, id);
		return copyObj(tp);
	}
	@Override
	public void update(Patrol patrol) throws Exception {
		Tpatrol tp = patrolDAO.get(Tpatrol.class, patrol.getId());
		BeanUtils.copyProperties(patrol, tp);
		Ttype tt = typeDAO.get(Ttype.class, patrol.getTid());
		Tsupplier ts = supplierDAO.get(Tsupplier.class, patrol.getSid());
		tp.setTtype(tt);
		tp.setTsupplier(ts);
		patrolDAO.saveOrUpdate(tp);
	}
	@Override
	public void delete(Patrol patrol) throws Exception {
		Tpatrol tp = patrolDAO.get(Tpatrol.class, patrol.getId());
		tp.setDeltriger(true);
		patrolDAO.update(tp);
	}
	@Override
	public Patrol getPatrolBySerialNo(String serialNo) throws Exception {
		String hql = "from Tpatrol tp where tp.serialNo = '"+serialNo+"'";
		List<Tpatrol> tpList = patrolDAO.find(hql);
		if(CommonUtils.isNotNull(tpList)){
			Tpatrol tp = tpList.get(0);
			return copyObj(tp);
		}
		return null;
	}
	

}
