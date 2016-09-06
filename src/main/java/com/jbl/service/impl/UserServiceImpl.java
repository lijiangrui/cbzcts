package com.jbl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbl.dao.DeptDAO;
import com.jbl.dao.RoleDAO;
import com.jbl.dao.TitleDAO;
import com.jbl.dao.UserDAO;
import com.jbl.model.Tcompany;
import com.jbl.model.Tdept;
import com.jbl.model.Trole;
import com.jbl.model.Ttitle;
import com.jbl.model.Tuser;
import com.jbl.pagemodel.User;
import com.jbl.service.UserService;
import com.jbl.util.Encrypt;
import com.jbl.util.CommonUtils;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	/**
	 * Logger for this class
	 */
	private UserDAO userDAO;
	
	private DeptDAO deptDAO;
	private RoleDAO roleDAO;
	private TitleDAO titleDAO;
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	public void test(){
		logger.info(this);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TitleDAO getTitleDAO() {
		return titleDAO;
	}
	@Autowired
	public void setTitleDAO(TitleDAO titleDAO) {
		this.titleDAO = titleDAO;
	}

	@Override
	public User save(User u) throws Exception {
		Tuser user = new Tuser();
		//spring提供的实体属性复制，第三个属性为除了某些属性
		BeanUtils.copyProperties(u, user, new String[] { "pwd" });
		user.setPwd(Encrypt.e(u.getPwd()));
		user.setCreatetime(new Date());
		Tdept tdept = deptDAO.get(Tdept.class, u.getDeptid());
		user.setTdept(tdept);
		Trole trole = roleDAO.get(Trole.class, u.getRoleid());
		user.setTrole(trole);
		Ttitle ttitle = titleDAO.get(Ttitle.class, u.getTitleId());
		user.setTtitle(ttitle);
		user.setDeltriger(false);
		userDAO.saveOrUpdate(user);
		BeanUtils.copyProperties(user, u);
		return u;
	}

	@Override
	public User login(User user) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", user.getName());
		params.put("pwd", Encrypt.e(user.getPwd()));
		logger.info(Encrypt.e(user.getPwd()));
		String hql = "from Tuser u where u.deltriger =0 and u.name=:name and u.pwd=:pwd";
		Tuser u = userDAO.get(hql,params);
		if(u != null){
			
			return copyProperty(u);
		}
		return null;
	}

	@Override
	public void removeByIds(String ids) throws Exception {
		String hql = "delete Tuser t where 1=1 and t.id in (";
		if(ids != null && !"".equals(ids)){
			String[] idsArr = ids.split(",");
			for(int i=0;i<idsArr.length;i++){
				if(i>0){
					hql += ",";
				}
				hql += "'"+idsArr[i]+"'";
			}
			hql+= ")";
		}
		logger.info(hql);
		userDAO.executeHql(hql);
	}

	@Override
	public void update(User user) throws Exception {
		Tuser u = userDAO.get(Tuser.class, user.getId());
		logger.info(u);
		BeanUtils.copyProperties(user, u,new String[]{"pwd"});
		if(CommonUtils.isNotNull(user.getPwd()) 
				&&!u.getPwd().equals(Encrypt.e(user.getPwd()))){
			u.setPwd(Encrypt.e(user.getPwd()));
		}
		Trole trole = roleDAO.get(Trole.class,user.getRoleid());
		Tdept tdept = deptDAO.get(Tdept.class,user.getDeptid());
		Ttitle ttitle = titleDAO.get(Ttitle.class, user.getTitleId());
		u.setTdept(tdept);
		u.setTrole(trole);
		u.setTtitle(ttitle);
		u.setModifytime(new Date());
		userDAO.saveOrUpdate(u);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		String hql = "from Tuser t where t.deltriger =0 and t.id!=1";
		if(user.getCompanyid() != 0){
			hql += " and t.tcompany.id=:companyid";
			params.put("companyid", user.getCompanyid());
		}
		hql += " order by t.tdept.id desc";
		return getUserList(params, hql);
	}

	private List<User> getUserList(Map<String, Object> params, String hql) throws Exception {
		List<Tuser> tuserList = userDAO.find(hql, params);
		return copyProperties(tuserList);
	}

	private List<User> copyProperties(List<Tuser> tuserList) {
		List<User> userList = new ArrayList<User>();
		if(tuserList != null && tuserList.size()>0){
			for(Tuser u : tuserList){
				User tmpuser = copyProperty(u);
				userList.add(tmpuser);
			}
		}
		return userList;
	}
	private User copyProperty(Tuser u) {
		User user = new User();
		BeanUtils.copyProperties(u, user);
		if(CommonUtils.isNotNull(u.getTrole())){
			user.setRoleid(u.getTrole().getId());
			user.setRolename(u.getTrole().getName());
			user.setMenu(u.getTrole().getMenu());
			user.setChaRight(u.getTrole().getChaRight());
		}
		if(CommonUtils.isNotNull(u.getTdept())){
			user.setDeptid(u.getTdept().getId());
			user.setDeptname(u.getTdept().getName());
			user.setCompanyid(u.getTdept().getTcompany().getId());
			user.setCompanyname(u.getTdept().getTcompany().getName());
		}
		if(CommonUtils.isNotNull(u.getTtitle())){
			user.setTitleId(u.getTtitle().getId());
			user.setTitleName(u.getTtitle().getName());
		}
		return user;
	}

	public DeptDAO getDeptDAO() {
		return deptDAO;
	}
	@Autowired
	public void setDeptDAO(DeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		Tuser t = userDAO.get(Tuser.class, id);
		if(t != null){
			return copyProperty(t);
		}
		return null;
	}

	@Override
	public List<User> searchUserListByParams(Map<String, Object> params) throws Exception {
		String hql="from Tuser u where u.id != 1";
		if(CommonUtils.isNotNull(params)){
			for(String key : params.keySet()){
				hql += " and u."+key+" like :"+key+"";
			}
		}
		return getUserList(params,hql);
	}

	@Override
	public List<User> getUserByVal(String searchVal) throws Exception {
		searchVal = "'%"+searchVal.trim()+"%'";
		String hql = "from Tuser ts where 1=1" +
				" and (ts.name like "+searchVal +
				" or ts.realname like "+searchVal +
				" or ts.tdept.tcompany.name like "+searchVal +
				" or ts.tdept.name like "+searchVal +
				" or ts.trole.name like "+searchVal+")";
		return getUserList(hql);
	}

	private List<User> getUserList(String hql) throws Exception{
		hql += "order by ts.createtime desc";
		List<Tuser> tuserList = userDAO.find(hql);
		return copyProperties(tuserList);
	}

	@Override
	public void delete(User user) throws Exception {
		Tuser tu = userDAO.get(Tuser.class, user.getId());
		userDAO.remove(tu);
	}

	@Override
	public void updatePwd(User user) throws Exception {
		// TODO Auto-generated method stub
		Tuser u = userDAO.get(Tuser.class, user.getId());
		if(CommonUtils.isNotNull(user.getPwd()) 
				&&!u.getPwd().equals(Encrypt.e(user.getPwd()))){
			u.setPwd(Encrypt.e(user.getPwd()));
		}
		userDAO.saveOrUpdate(u);
	}
}
