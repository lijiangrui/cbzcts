package com.jbl.service;

import java.util.List;
import java.util.Map;

import com.jbl.pagemodel.User;

public interface UserService {
	public void test();

	public User save(User u) throws Exception;
	
	public User login(User user) throws Exception;

	public void removeByIds(String ids) throws Exception;

	public void update(User user) throws Exception;

	public List<User> getUserList(User user) throws Exception;

	public User getUserById(Integer id) throws Exception;

	public List<User> searchUserListByParams(Map<String, Object> params) throws Exception;

	public List<User> getUserByVal(String searchVal) throws Exception;

	public void delete(User user) throws Exception;

	public void updatePwd(User user) throws Exception;
}
