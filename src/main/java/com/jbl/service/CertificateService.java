package com.jbl.service;

import java.util.List;
import java.util.Map;

import com.jbl.pagemodel.Certificate;

public interface CertificateService {

	void update(Certificate certificate) throws Exception;

	Certificate getCertificateById(Integer id) throws Exception;

	List<Certificate> getCertificatesByParam(Map<String, Object> param) throws Exception;

	void delete(Certificate certificate) throws Exception;

	void save(Certificate certificate) throws Exception;

}
