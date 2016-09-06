package com.jbl.service;

import java.util.List;

import com.jbl.pagemodel.Role;

public interface RoleService {

	List<Role> getAllRoles() throws Exception;

	void save(Role role) throws Exception;

	Role getRoleById(int id) throws Exception;

	void update(Role role) throws Exception;

}
