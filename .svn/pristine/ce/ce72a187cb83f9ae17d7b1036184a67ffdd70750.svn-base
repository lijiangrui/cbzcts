package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.OperateRecordDAO;
import com.jbl.dao.UserDAO;
import com.jbl.model.Trecord;
import com.jbl.model.Tuser;
import com.jbl.pagemodel.Record;
import com.jbl.service.OperateRecordService;
import com.jbl.util.CommonUtils;

@Service(value="orService")
public class OperateRecordServiceImpl implements OperateRecordService {

	private OperateRecordDAO operateRecordDAO;
	
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void record(Record record) throws Exception {
		Trecord tr = new Trecord();
		int userId = record.getOperaterId();
		Tuser tuser = userDAO.get(Tuser.class, userId);
		BeanUtils.copyProperties(record, tr);
		tr.setTuser(tuser);
		operateRecordDAO.save(tr);
	}

	public OperateRecordDAO getOperateRecordDAO() {
		return operateRecordDAO;
	}
	@Autowired
	public void setOperateRecordDAO(OperateRecordDAO operateRecordDAO) {
		this.operateRecordDAO = operateRecordDAO;
	}

	@Override
	public List<Record> getRecordList(int operateId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		String hql = "from Trecord r where 1=1";
		if(operateId!=0){
			hql += " and r.tuser.id=:operaterId";
			params.put("operaterId", operateId);
		}
		hql += " order by r.id desc";
		List<Trecord> trlist = operateRecordDAO.find(hql, params);
		
		return transList(trlist);
	}

	private List<Record> transList(List<Trecord> trlist) {
		List<Record> rlist = new ArrayList<Record>();
		if(CommonUtils.isNotNull(trlist)){
			for(Trecord tr :trlist){
				Record r = new Record();
				BeanUtils.copyProperties(tr, r);
				r.setOperater(tr.getTuser().getName());
				r.setOperaterId(tr.getTuser().getId());
				rlist.add(r);
			}
		}
		return rlist;
	}
	@Override
	public List<Record> getRecordList(int operateId, int type) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		String hql = "from Trecord r where 1=1";
		if(operateId!=0){
			hql += " and r.tuser.id=:operaterId";
			params.put("operaterId", operateId);
		}
		if(type !=0){
			hql += " and r.type=:type ";
			params.put("type", type);
		}
		hql += " order by r.id desc";
		List<Trecord> trlist = operateRecordDAO.find(hql, params);
		
		return transList(trlist);
	}
	
}
