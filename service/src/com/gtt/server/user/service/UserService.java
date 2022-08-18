package com.gtt.server.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.CoreService;
import com.gtt.server.user.entity.User;


public interface UserService extends CoreService<User,Serializable>{
//	public boolean saveUser(List<User> entityList);
	public List getLogin(String username, String password) throws DataAccessException;
	public List getUserList (String company) throws DataAccessException;
	public List getaddUserList (String company,String id_company) throws DataAccessException;

}
