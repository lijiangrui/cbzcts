package com.jbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbl.dao.ChargeDAO;
import com.jbl.model.Tcharge;

@Repository(value="chargeDAO")
public class ChargeDAOImpl extends BaseDAOImpl<Tcharge> implements ChargeDAO {

}
