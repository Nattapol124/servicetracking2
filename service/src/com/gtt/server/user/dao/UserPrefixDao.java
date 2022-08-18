package com.gtt.server.user.dao;
import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.UserPrefix;



public interface UserPrefixDao extends CoreDao<UserPrefix, Serializable> {

//	public List findUser_prefixList(String id_user_type, String user_type_name) throws DataAccessException;

}