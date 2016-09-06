package com.jbl.service;

import java.util.List;
import java.util.Map;

import com.jbl.pagemodel.Type;

public interface TypeService {

	List<Type> getTypesByDeptId(int deptId,String type) throws Exception;

	List<Type> getTypesByParams(Map<String,Object> params) throws Exception;

	List<Type> getAllTypes(String type) throws Exception;

	void save(Type type) throws Exception;

	Type getTypeById(int id) throws Exception;

	void update(Type type) throws Exception;

	void delete(Type type) throws Exception;

}
