package com.jbl.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDAO<T> {
	
	public Serializable save(T obj) throws Exception;
	
	public T get(String hql) throws Exception;
	
	public T get(String hql,Map<String,Object> params) throws Exception;
	
	public T get(Class<T> c,String id) throws Exception;
	
	public T get(Class<T> c,Integer id) throws Exception;
	
	public void remove(T obj) throws Exception;
	
	public void update(T obj) throws Exception;
	
	public void saveOrUpdate(T obj) throws Exception;
	
	public List<T> find(String hql) throws Exception;
	
	public List<T> find(String hql,Map<String,Object> params) throws Exception;
	
	public List<T> find(String hql,Map<String,Object> params,int page,int rows) throws Exception;
	
	public long count(String hql) throws Exception;
	
	public long count(String hql,Map<String,Object> params) throws Exception;
	
	public int executeHql(String hql) throws Exception;
}
