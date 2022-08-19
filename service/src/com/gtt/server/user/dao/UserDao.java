package com.gtt.server.user.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.User;



public interface UserDao extends CoreDao<User, Serializable> {

	public List findLogin(String username, String password) throws DataAccessException;
	public List findUserList(String company) throws DataAccessException;
<<<<<<< HEAD
=======
	public List findAddUserList(String company,String id_company) throws DataAccessException;

>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
}
