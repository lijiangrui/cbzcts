package com.jbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbl.dao.AreaDAO;
import com.jbl.model.Tarea;

@Repository(value="areaDAO")
public class AreaDAOImpl extends BaseDAOImpl<Tarea> implements AreaDAO {

}
