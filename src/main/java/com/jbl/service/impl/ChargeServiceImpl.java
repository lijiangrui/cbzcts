package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.ChargeDAO;
import com.jbl.dao.DeptDAO;
import com.jbl.dao.SupplierDAO;
import com.jbl.dao.TypeDAO;
import com.jbl.dao.UserDAO;
import com.jbl.model.Tcharge;
import com.jbl.model.Tdept;
import com.jbl.model.Tsupplier;
import com.jbl.model.Ttype;
import com.jbl.model.Tuser;
import com.jbl.pagemodel.Charge;
import com.jbl.service.ChargeService;
import com.jbl.util.CommonUtils;

@Service(value="chargeService")
public class ChargeServiceImpl implements ChargeService {

	private Logger logger = Logger.getLogger(this.getClass());
	
	private ChargeDAO chargeDAO;
	
	private TypeDAO typeDAO;
	
	private SupplierDAO supplierDAO;
	
	private DeptDAO deptDAO;
	
	private UserDAO userDAO;
	
	public ChargeDAO getChargeDAO() {
		return chargeDAO;
	}
	@Autowired
	public void setChargeDAO(ChargeDAO chargeDAO) {
		this.chargeDAO = chargeDAO;
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
	public void save(Charge charge) throws Exception {
		Tcharge tc = new Tcharge();
		reverseCopy(charge, tc);
		chargeDAO.save(tc);
	}
	private void reverseCopy(Charge charge, Tcharge tc) throws Exception {
		BeanUtils.copyProperties(charge, tc);
		Ttype type = typeDAO.get(Ttype.class,charge.getTid());
		Tsupplier ts = supplierDAO.get(Tsupplier.class, charge.getSid());
		Tuser user = userDAO.get(Tuser.class,charge.getUserId());
		tc.setCreateTime(new Date());
		tc.setTtype(type);
		tc.setTsupplier(ts);
		tc.setTuser(user);
	}
	@Override
	public List<Charge> getChargeByParams(Map<String, Object> params,String chargeDepts) throws Exception {
		String hql = "from Tcharge pa where 1=1 ";
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
		return getCharge(params, hql);
	}
	private List<Charge> getCharge(Map<String, Object> params, String hql) throws Exception {
		hql +=" order by pa.createTime desc";
		List<Tcharge> tpalist = chargeDAO.find(hql, params);
		List<Charge> palist = new ArrayList<Charge>();
		if(CommonUtils.isNull(tpalist))return null;
		copyProperties(tpalist, palist);
		return palist;
	}
	private List<Charge> getCharge(String hql) throws Exception {
		hql +=" order by pa.createTime desc";
		List<Tcharge> tpalist = chargeDAO.find(hql);
		List<Charge> palist = new ArrayList<Charge>();
		if(CommonUtils.isNull(tpalist))return null;
		copyProperties(tpalist, palist);
		return palist;
	}
	private void copyProperties(List<Tcharge> tpalist, List<Charge> palist) {
		for(Tcharge tpa : tpalist){
			Charge pa = copyObj(tpa);
			palist.add(pa);
		}
	}
	private Charge copyObj(Tcharge tch) {
		Charge ch = new Charge();
		BeanUtils.copyProperties(tch, ch);
		ch.setTid(tch.getTtype().getId());
		ch.setTypeName(tch.getTtype().getName());
		ch.setAid(tch.getTsupplier().getTarea().getId());
		ch.setAreaName(tch.getTsupplier().getTarea().getName());
		ch.setSid(tch.getTsupplier().getId());
		ch.setSupplierName(tch.getTsupplier().getName());
		if(CommonUtils.isNotNull(tch.getTuser().getTdept())){
			ch.setDeptId(tch.getTuser().getTdept().getId());
			ch.setDeptName(tch.getTuser().getTdept().getName());
			ch.setDeptNo(tch.getTuser().getTdept().getNo());
		}
		ch.setUserId(tch.getTuser().getId());
		ch.setUserName(tch.getTuser().getName());
		return ch;
	}
	@Override
	public List<Charge> getChargeByVal(String searchVal,String add) throws Exception {
		searchVal = "'%"+searchVal.trim()+"%'";
		String hql = "from Tcharge pa where 1=1 " +
				" and (pa.tsupplier.tarea.name like "+searchVal +
				" or pa.tsupplier.name like "+searchVal +
				" or pa.chargeTime like "+searchVal +
				" or pa.serialNo like "+searchVal+")" +
				add;
		logger.info("searchVal : "+searchVal);
		return getCharge(hql);
	}
	@Override
	public Charge getChargeById(int id) throws Exception {
		Tcharge tc = chargeDAO.get(Tcharge.class, id);
		return copyObj(tc);
	}
	@Override
	public void update(Charge charge) throws Exception {
		Tcharge tc = chargeDAO.get(Tcharge.class, charge.getId());
		BeanUtils.copyProperties(charge, tc);
		Ttype tt = typeDAO.get(Ttype.class, charge.getTid());
		Tsupplier ts = supplierDAO.get(Tsupplier.class, charge.getSid());
		tc.setTtype(tt);
		tc.setTsupplier(ts);
		chargeDAO.saveOrUpdate(tc);
	}
	@Override
	public void delete(Charge charge) throws Exception {
		Tcharge tc = chargeDAO.get(Tcharge.class, charge.getId());
		tc.setDeltriger(true);
		chargeDAO.update(tc);
	}
	@Override
	public Charge getChargeBySerialNo(String serialNo) throws Exception {
		String hql = "from Tcharge tc where tc.serialNo= '"+serialNo+"'";
		Tcharge tc = chargeDAO.get(hql);
		Charge charge = new Charge();
		if(CommonUtils.isNotNull(tc)){
			charge = copyObj(tc);
		}
		return charge;
	}
}
