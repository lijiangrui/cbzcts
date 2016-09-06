package com.jbl.service;

import java.util.List;
import java.util.Map;

import com.jbl.model.Tsupplier;
import com.jbl.pagemodel.Supplier;

public interface SupplierService {

	void save(Supplier supplier) throws Exception;

	List<Supplier> getSuppliersByAreaId(int areaId) throws Exception;

	void saveTemplate(Integer userId, String templateName, Supplier supplier) throws Exception;

	List<Supplier> getSupplierByVal(String searchVal) throws Exception;

	Supplier getSupplierById(Integer id) throws Exception;

	void delete(Supplier supplier) throws Exception;

	void update(Supplier supplier) throws Exception;

	boolean isExist(String no) throws Exception;

	List<Supplier> getSupplierByParams(Map<String, Object> params) throws Exception;

}
