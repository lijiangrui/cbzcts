package com.jbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbl.dao.CompanyDAO;
import com.jbl.model.Tcompany;
@Repository(value="companyDAO")
public class CompanyDAOImpl extends BaseDAOImpl<Tcompany> implements CompanyDAO{

}
