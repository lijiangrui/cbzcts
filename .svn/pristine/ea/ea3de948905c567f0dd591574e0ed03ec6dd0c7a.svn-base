package com.jbl.dao.impl;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbl.dao.BaseDAO;

@Repository(value="baseDAO")
public class BaseDAOImpl<T> implements BaseDAO<T> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseDAOImpl.class);

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public Serializable save(T obj) throws Exception {
		return getCurrentSession().save(obj);
	}
	@Override
	public T get(String hql) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		List<T> list = q.list();
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public T get(String hql, Map<String, Object> params) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		if(params !=null && !params.isEmpty()){
			for(String key:params.keySet()){
				q.setParameter(key, params.get(key));
				logger.info("key:"+key+"value:"+params.get(key));
			}
		}
		List<T> list = q.list();
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void remove(T obj) throws Exception {
		getCurrentSession().delete(obj);
	}
	@Override
	public void update(T obj) throws Exception {
		getCurrentSession().update(obj);
		
	}
	@Override
	public void saveOrUpdate(T obj) throws Exception {
		getCurrentSession().saveOrUpdate(obj);
		
	}
	@Override
	public List<T> find(String hql) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		return q.list();
	}
	@Override
	public List<T> find(String hql, Map<String, Object> params) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		if(params !=null && !params.isEmpty()){
			for(String key:params.keySet()){
				q.setParameter(key, params.get(key));
				logger.info("key:"+key+"value:"+params.get(key));
			}
		}
		return q.list();
	}
	
	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		if(params !=null && !params.isEmpty()){
			for(String key:params.keySet()){
				q.setParameter(key, params.get(key));
				logger.info("key:"+key+"value:"+params.get(key));
			}
		}
		return q.setFirstResult((page-1) * rows).setMaxResults(rows).list();
	}
	@Override
	public long count(String hql) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}
	@Override
	public long count(String hql, Map<String, Object> params) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		if(params !=null && !params.isEmpty()){
			for(String key:params.keySet()){
				q.setParameter(key, params.get(key));
				logger.info("key:"+key+"value:"+params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}
	@Override
	public T get(Class<T> c, String id) throws Exception {
		
		return (T) getCurrentSession().get(c, id);
	}
	
	@Override
	public T get(Class<T> c, Integer id) throws Exception {
		
		return (T) getCurrentSession().get(c, id);
	}
	@Override
	public int executeHql(String hql) throws Exception {
		Query q = getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

}
