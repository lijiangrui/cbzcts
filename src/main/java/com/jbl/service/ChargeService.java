package com.jbl.service;

import java.util.List;
import java.util.Map;

import com.jbl.pagemodel.Charge;

public interface ChargeService {

	public List<Charge> getChargeByParams(Map<String, Object> params,String chargeDepts) throws Exception;

	public List<Charge> getChargeByVal(String searchVal,String add) throws Exception;

	public void save(Charge charge) throws Exception;

	public Charge getChargeById(int id) throws Exception;

	public void update(Charge charge) throws Exception;

	public void delete(Charge charge) throws Exception;

	public Charge getChargeBySerialNo(String serialNo) throws Exception;

}