package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.ProductDAO;
import com.jbl.dao.SupplierDAO;
import com.jbl.model.Tproduct;
import com.jbl.model.Tsupplier;
import com.jbl.pagemodel.Product;
import com.jbl.service.ProductService;
import com.jbl.util.CommonUtils;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	private ProductDAO proDAO;
	
	private SupplierDAO sprDAO;
	
	public ProductDAO getProDAO() {
		return proDAO;
	}
	@Autowired
	public void setProDAO(ProductDAO proDAO) {
		this.proDAO = proDAO;
	}

	public SupplierDAO getSprDAO() {
		return sprDAO;
	}
	@Autowired
	public void setSprDAO(SupplierDAO sprDAO) {
		this.sprDAO = sprDAO;
	}
	@Override
	public Product getProductById(Integer id) throws Exception {
		Tproduct tpro = proDAO.get(Tproduct.class,id);
		Product pro = new Product();
		BeanUtils.copyProperties(tpro,pro);
		pro.setSid(tpro.getTsupplier().getId());
		pro.setSupplierName(tpro.getTsupplier().getName());
		return pro;
	}
	@Override
	public void update(Product product) throws Exception {
		Tproduct tpro = new Tproduct();
		BeanUtils.copyProperties(product,tpro);
		Integer sid = product.getSid();
		Tsupplier tsu = sprDAO.get(Tsupplier.class,sid);
		tpro.setTsupplier(tsu);
		proDAO.saveOrUpdate(tpro);
	}
	@Override
	public List<Product> getProductsByParams(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Tproduct tp where 1=1 ";
		if(CommonUtils.isNotNull(params)){
			Iterator it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				hql += " and tp."+key+":"+key;
			}
		}
		hql += "order by tp.tsupplier.id asc";
		List<Tproduct> tproList = proDAO.find(hql, params);
		List<Product> proList = new ArrayList<Product>();
		this.copyProperties(tproList,proList);
		return proList;
	}
	private void copyProperties(List<Tproduct> tproList, List<Product> proList) {
		// TODO Auto-generated method stub
		if(CommonUtils.isNotNull(tproList)){
			for(Tproduct tpro : tproList){
				Product pro = new Product();
				copyProperty(tpro,pro);
				proList.add(pro);
			}
		}
	}
	private void copyProperty(Tproduct tpro, Product pro) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(tpro, pro);
		pro.setSid(tpro.getTsupplier().getId());
		pro.setSupplierName(tpro.getTsupplier().getName());
	}
	@Override
	public void delete(Product product) throws Exception {
		// TODO Auto-generated method stub
		Tproduct tpro = proDAO.get(Tproduct.class,product.getId());
		proDAO.remove(tpro);
	}
	@Override
	public void save(Product product) throws Exception {
		// TODO Auto-generated method stub
		Tproduct tpro = new Tproduct();
		BeanUtils.copyProperties(product, tpro);
		Tsupplier tsu = sprDAO.get(Tsupplier.class,product.getSid());
		tpro.setTsupplier(tsu);
		proDAO.save(tpro);
	}

}
