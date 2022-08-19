package com.gtt.server.user.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.UserDao;
import com.gtt.server.user.entity.User;
import com.gtt.server.user.entity.UserType;
import com.gtt.server.user.service.UserService;

public class UserServiceImpl 
extends CoreServiceImpl<User,Serializable>
implements UserService
{
	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
		this.userDao = userDao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List getLogin(String username, String password) throws DataAccessException {
		return userDao.findLogin(username, password);
	}
	@Override
	public List getUserList(String company) throws DataAccessException {
		return userDao.findUserList(company);
	}

<<<<<<< HEAD
=======
	@Override
	public List getaddUserList(String company,String id_company) throws DataAccessException {
		return userDao.findAddUserList(company,id_company);
	}

>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
	

	
}
