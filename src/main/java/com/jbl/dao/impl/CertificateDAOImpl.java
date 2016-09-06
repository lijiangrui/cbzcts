package com.jbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbl.dao.CertificateDAO;
import com.jbl.model.Tcertificate;

@Repository("certificateDAO")
public class CertificateDAOImpl extends BaseDAOImpl<Tcertificate> implements CertificateDAO{

}
