package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.CertificateDAO;
import com.jbl.dao.SupplierDAO;
import com.jbl.model.Tcertificate;
import com.jbl.model.Tsupplier;
import com.jbl.pagemodel.Certificate;
import com.jbl.service.CertificateService;
import com.jbl.util.CommonUtils;

@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {

	private CertificateDAO cerDAO;
	
	private SupplierDAO sprDAO;
	
	public CertificateDAO getCerDAO() {
		return cerDAO;
	}
	@Autowired
	public void setCerDAO(CertificateDAO cerDAO) {
		this.cerDAO = cerDAO;
	}

	public SupplierDAO getSprDAO() {
		return sprDAO;
	}
	@Autowired
	public void setSprDAO(SupplierDAO sprDAO) {
		this.sprDAO = sprDAO;
	}
	@Override
	public void update(Certificate certificate) throws Exception {
		Tcertificate tcer = new Tcertificate();
		BeanUtils.copyProperties(certificate,tcer);
		Integer sid = certificate.getSid();
		Tsupplier tsu = sprDAO.get(Tsupplier.class,sid);
		tcer.setTsupplier(tsu);
		cerDAO.saveOrUpdate(tcer);
	}

	@Override
	public Certificate getCertificateById(Integer id) throws Exception {
		Tcertificate tcer = cerDAO.get(Tcertificate.class,id);
		Certificate cer = new Certificate();
		copyProperty(tcer, cer);
		cer.setSid(tcer.getTsupplier().getId());
		return cer;
	}
	@Override
	public List<Certificate> getCertificatesByParam(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		String hql = "from Tcertificate tc where 1=1 ";
		if(CommonUtils.isNotNull(params)){
			Iterator it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				hql += " and tc."+key+":"+key;
			}
		}
		hql += " order by tc.tsupplier.id desc";
		List<Tcertificate> tcerList = cerDAO.find(hql,params);
		List<Certificate> cerList = new ArrayList<Certificate>();
		aaa(tcerList,cerList);
		return cerList;
	}
	private void aaa(List<Tcertificate> tcerList, List<Certificate> cerList) {
		if(CommonUtils.isNotNull(tcerList)){
			for(Tcertificate tcer : tcerList){
				Certificate cer = new Certificate();
				copyProperty(tcer, cer);
				cerList.add(cer);
			}
		}
	}
	private void copyProperty(Tcertificate tcer, Certificate cer) {
		BeanUtils.copyProperties(tcer, cer);
		cer.setSupplierName(tcer.getTsupplier().getName());
	}
	@Override
	public void delete(Certificate certificate) throws Exception {
		// TODO Auto-generated method stub
		Tcertificate tcer = cerDAO.get(Tcertificate.class,certificate.getId());
		cerDAO.remove(tcer);
	}
	@Override
	public void save(Certificate certificate) throws Exception {
		// TODO Auto-generated method stub
		Tcertificate tcer = new Tcertificate();
		BeanUtils.copyProperties(certificate, tcer);
		int sid = certificate.getSid();
		Tsupplier tsu = sprDAO.get(Tsupplier.class,sid);
		tcer.setTsupplier(tsu);
		cerDAO.save(tcer);
	}
}
