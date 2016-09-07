package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.RoleDAO;
import com.jbl.model.Trole;
import com.jbl.pagemodel.Role;
import com.jbl.service.RoleService;
import com.jbl.util.CommonUtils;

@Service(value="roleService")
public class RoleServiceImpl implements RoleService {

	private RoleDAO roleDAO;
	@Override
	public List<Role> getAllRoles() throws Exception {
		String hql = "from Trole tr where tr.deltriger = 0 and tr.id != 1";
		List<Trole> rList = roleDAO.find(hql);
		List<Role> list = new ArrayList<Role>();
		if(!CommonUtils.isNull(rList)){
			for(Trole trole : rList){
				Role role = new Role();
				BeanUtils.copyProperties(trole, role);
				list.add(role);
			}
		}
		return list;
	}
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public void save(Role role) throws Exception {
		Trole tr = new Trole();
		BeanUtils.copyProperties(role, tr);
		roleDAO.save(tr);
	}

	@Override
	public Role getRoleById(int id) throws Exception {
		Trole tr = roleDAO.get(Trole.class, id);
		Role role = new Role();
		BeanUtils.copyProperties(tr, role);
		return role;
	}

	@Override
	public void update(Role role) throws Exception {
		Trole tr = new Trole();
		BeanUtils.copyProperties(role, tr);
		roleDAO.saveOrUpdate(tr);
	}
	
}
