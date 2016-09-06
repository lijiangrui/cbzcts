package com.jbl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.DeptDAO;
import com.jbl.dao.RoleDAO;
import com.jbl.dao.UserDAO;
import com.jbl.model.Trole;
import com.jbl.model.Tuser;
import com.jbl.service.RepairService;
import com.jbl.util.Encrypt;


@Service(value="repairService")
public class RepairServiceImpl implements RepairService {

	private UserDAO userDAO;
	
	private DeptDAO deptDAO;
	
	private RoleDAO roleDAO;
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	public DeptDAO getDeptDAO() {
		return deptDAO;
	}
	@Autowired
	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

public UserDAO getUserDAO() {
	return userDAO;
}
@Autowired
public void setUserDAO(UserDAO userDAO) {
	this.userDAO = userDAO;
}

	@Override
	public void repair() throws Exception {
		repairUser();
	}
	
	private void repairUser() throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", "admin");
		String hql = "from Tuser u where u.name=:name";
		Tuser user = userDAO.get(hql, params);
		if(user !=null){
			user.setPwd(Encrypt.e("admin"));
			user.setDeltriger(false);
			userDAO.saveOrUpdate(user);
		}else{
			Tuser admin = new Tuser();
			admin.setName("admin");
			admin.setPwd(Encrypt.e("admin"));
			admin.setRealname("超级管理员");
			admin.setCreatetime(new Date());
			admin.setTdept(null);
			Trole role = roleDAO.get(Trole.class, 1);
			admin.setTrole(role);
			admin.setDeltriger(false);
			userDAO.saveOrUpdate(admin);
		}
		
	}

}
