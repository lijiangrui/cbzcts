package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.CompanyDAO;
import com.jbl.model.Tcompany;
import com.jbl.pagemodel.Company;
import com.jbl.service.CompanyService;
import com.jbl.util.CommonUtils;

@Service(value="companyService")
public class CompanyServiceImpl implements CompanyService {

	private CompanyDAO companyDAO;
	@Override
	public List<Company> getAllCompanys() throws Exception {
		String hql = "from Tcompany tc where tc.deltriger = 0";
		List<Tcompany> cList = companyDAO.find(hql);
		List<Company> list = new ArrayList<Company>();
		if(!CommonUtils.isNull(cList)){
			for(Tcompany tdept : cList){
				Company dept = new Company();
				BeanUtils.copyProperties(tdept, dept);
				list.add(dept);
			}
		}
		return list;
	}
	
	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}
	@Autowired
	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
}
