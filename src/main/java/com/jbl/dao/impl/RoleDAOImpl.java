package com.jbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbl.dao.RoleDAO;
import com.jbl.model.Trole;

@Repository(value="roleDAO")
public class RoleDAOImpl extends BaseDAOImpl<Trole> implements RoleDAO {

}
