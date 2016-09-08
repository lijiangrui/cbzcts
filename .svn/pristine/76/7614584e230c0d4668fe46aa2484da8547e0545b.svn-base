package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.AreaDAO;
import com.jbl.dao.SupplierDAO;
import com.jbl.dao.TemplateDAO;
import com.jbl.model.Tarea;
import com.jbl.model.Tcertificate;
import com.jbl.model.Tcharge;
import com.jbl.model.Tpatrol;
import com.jbl.model.Tproduct;
import com.jbl.model.Tsupplier;
import com.jbl.model.Ttemplate;
import com.jbl.pagemodel.Certificate;
import com.jbl.pagemodel.Charge;
import com.jbl.pagemodel.Patrol;
import com.jbl.pagemodel.Product;
import com.jbl.pagemodel.Supplier;
import com.jbl.service.SupplierService;
import com.jbl.util.CommonUtils;

@Service(value="supplierService")
public class SupplierServiceImpl implements SupplierService {

	private SupplierDAO sprDAO;
	
	private AreaDAO areaDAO;
	
	private TemplateDAO templateDAO;
	
	public SupplierDAO getSprDAO() {
		return sprDAO;
	}
	@Autowired
	public void setSprDAO(SupplierDAO sprDAO) {
		this.sprDAO = sprDAO;
	}
	public AreaDAO getAreaDAO() {
		return areaDAO;
	}
	@Autowired
	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	public TemplateDAO getTemplateDAO() {
		return templateDAO;
	}
	@Autowired
	public void setTemplateDAO(TemplateDAO templateDAO) {
		this.templateDAO = templateDAO;
	}
	@Override
	public void save(Supplier supplier) throws Exception {
		Tsupplier tsu = new Tsupplier();
		Integer areaId = supplier.getAreaId();
		Tarea tarea = areaDAO.get(Tarea.class,areaId);
		List<Certificate> cList = supplier.getClist();
		Set<Tcertificate> tcSet = certifyList2set(cList,tsu);
		List<Product> pList = supplier.getPlist();
		Set<Tproduct> tpSet = productList2set(pList,tsu);
		BeanUtils.copyProperties(supplier, tsu);
		tsu.setTarea(tarea);
		tsu.setTcertificates(tcSet);
		tsu.setTproducts(tpSet);
		tsu.setCreateTime(new Date());
		tsu.setDeltriger(false);
		sprDAO.save(tsu);
	}
	private Set<Tcertificate> certifyList2set(List<Certificate> cList, Tsupplier tsupplier) {
		Set<Tcertificate> tcSet = new HashSet<Tcertificate>();
		if(CommonUtils.isNotNull(cList)){
			for(Certificate c : cList){
				if(CommonUtils.isNotNull(c)&&CommonUtils.isNotNull(c.getType())){
					Tcertificate tc = new Tcertificate();
					BeanUtils.copyProperties(c, tc);
					tc.setTsupplier(tsupplier);
					tcSet.add(tc);
				}
			}
		}
		return tcSet;
	}
	
	public Set<Tproduct> productList2set(List<Product> pList,Tsupplier tsupplier){
		Set<Tproduct> tpSet = new HashSet<Tproduct>();
		if(CommonUtils.isNotNull(pList)){
			for(Product p : pList){
				if(CommonUtils.isNotNull(p)&&CommonUtils.isNotNull(p.getName())){
					Tproduct tp = new Tproduct();
					BeanUtils.copyProperties(p, tp);
					tp.setTsupplier(tsupplier);
					tpSet.add(tp);
				}
			}
		}
		return tpSet;
	}
	
	
	@Override
	public List<Supplier> getSuppliersByAreaId(int areaId) throws Exception {
		String hql = "from Tsupplier ts where ts.deltriger=0 and ts.tarea.id=:areaId";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("areaId", areaId);
		List<Tsupplier> tslist = sprDAO.find(hql, params);
		return copyProperties(tslist);
	}
	
	private List<Supplier> copyProperties(List<Tsupplier> tslist) {
		List<Supplier> slist = new ArrayList<Supplier>();
		if(CommonUtils.isNotNull(tslist)){
			for(Tsupplier ts : tslist){
				Supplier s = new Supplier();
				copyProperties(ts, s);
				slist.add(s);
			}
		}
		return slist;
	}
	private void copyProperties(Tsupplier tsupplier, Supplier supplier) {
		BeanUtils.copyProperties(tsupplier, supplier);
		set2List(tsupplier,supplier);
		supplier.setAreaId(tsupplier.getTarea().getId());
		supplier.setAreaName(tsupplier.getTarea().getName());
	}
	/**
	 * 将one2many的set转换为list，便于页面处理
	 * @param ts
	 * @param s
	 */
	private void set2List(Tsupplier ts, Supplier s) {
		s.setClist(certificateSet2list(ts.getTcertificates()));
		s.setPlist(productSet2list(ts.getTproducts()));
		s.setChlist(chargeSet2list(ts.getTcharges()));
		s.setPalist(patrolSet2list(ts.getTpatrols()));
	}
	private List<Certificate> certificateSet2list(Set<Tcertificate> tcSet) {
		List<Certificate> clist = new ArrayList<Certificate>();
		if(CommonUtils.isNotNull(tcSet)){
			Iterator it = tcSet.iterator();
			while(it.hasNext()){
				Tcertificate tc = (Tcertificate)it.next();
				Certificate c = new Certificate();
				BeanUtils.copyProperties(tc, c);
				clist.add(c);
			}
		}
		return clist;
	}
	private List<Product> productSet2list(Set<Tproduct> tp) {
		List<Product> plist = new ArrayList<Product>();
		if(CommonUtils.isNotNull(tp)){
			Tproduct pro ;
			Iterator it = tp.iterator();
			while(it.hasNext()){
				pro = (Tproduct)it.next();
				Product p = new Product();
				BeanUtils.copyProperties(pro, p);
				plist.add(p);
			}
		}
		return plist;
	}
	private List<Charge> chargeSet2list(Set<Tcharge> tc) {
		List<Charge> chlist = new ArrayList<Charge>();
		if(CommonUtils.isNotNull(tc)){
			Tcharge pro ;
			Iterator it = tc.iterator();
			while(it.hasNext()){
				pro = (Tcharge)it.next();
				Charge p = new Charge();
				BeanUtils.copyProperties(pro, p);
				chlist.add(p);
			}
		}
		return chlist;
	}
	private List<Patrol> patrolSet2list(Set<Tpatrol> tp) {
		List<Patrol> palist = new ArrayList<Patrol>();
		if(CommonUtils.isNotNull(tp)){
			Tpatrol pro ;
			Iterator it = tp.iterator();
			while(it.hasNext()){
				pro = (Tpatrol)it.next();
				Patrol p = new Patrol();
				BeanUtils.copyProperties(pro, p);
				palist.add(p);
			}
		}
		return palist;
	}
	@Override
	public void saveTemplate(Integer userId, String templateName, Supplier supplier) throws Exception {
		Ttemplate template = new Ttemplate();
		BeanUtils.copyProperties(supplier, template);
		template.setTemplateName(templateName);
		template.setUserId(userId);
		templateDAO.save(template);
	}
	@Override
	public List<Supplier> getSupplierByVal(String searchVal) throws Exception {
		searchVal = "'%"+searchVal.trim()+"%'";
		String hql = "from Tsupplier ts where ts.deltriger=0 " +
				" and (ts.code like "+searchVal +
				" or ts.name like "+searchVal +
				" or ts.tarea.name like "+searchVal +
				" or ts.position like "+searchVal +
				" or ts.legalPerson like "+searchVal +
				" or ts.contactPerson like "+searchVal +
				" or ts.contact like "+searchVal+")";
		return getSuppliers(hql);
	}
	private List<Supplier> getSuppliers(String hql) throws Exception{
		hql += "order by ts.createTime desc";
		List<Tsupplier> tslist = sprDAO.find(hql);
		return copyProperties(tslist);
	}
	@Override
	public Supplier getSupplierById(Integer id) throws Exception {
		Tsupplier tsupplier = sprDAO.get(Tsupplier.class, id);
		Supplier supplier = new Supplier();
		copyProperties(tsupplier, supplier);
		return supplier;
	}
	
	@Override
	public void update(Supplier supplier) throws Exception {
		Tsupplier tsupplier = sprDAO.get(Tsupplier.class, supplier.getId());
		BeanUtils.copyProperties(supplier, tsupplier,new String[]{"tcertificates"});
		Tarea tarea = areaDAO.get(Tarea.class, supplier.getAreaId());
		tsupplier.setTarea(tarea);
		sprDAO.saveOrUpdate(tsupplier);
	}

	@Override
	public void delete(Supplier supplier) throws Exception {
		Tsupplier ts = sprDAO.get(Tsupplier.class, supplier.getId());
		ts.setDeltriger(true);
		sprDAO.update(ts);
	}
	@Override
	public boolean isExist(String no) throws Exception {
		String hql = "from Tsupplier ts where ts.deltriger=0 " +
				" and (ts.code = '"+no+"'" +
				" or ts.license = '"+no+"')";
		List<Tsupplier> tslist = sprDAO.find(hql);
		if(CommonUtils.isNotNull(tslist))return true;
		return false;
	}
	@Override
	public List<Supplier> getSupplierByParams(Map<String, Object> params) throws Exception {
		String hql ="from Tsupplier ts where ts.deltriger=0 ";
		if(CommonUtils.isNotNull(params)){
			Iterator it = params.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				String keyStr ="'%"+params.get(key)+"%'";
				hql += " and ts."+key+" like "+keyStr;
			}
		}
		return getSuppliers(hql,params);
	}
	private List<Supplier> getSuppliers(String hql, Map<String, Object> params) throws Exception {
		List<Tsupplier> tsList = sprDAO.find(hql, params);
		
		return copyProperties(tsList);
	}
}
