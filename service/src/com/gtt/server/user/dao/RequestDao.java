package com.gtt.server.user.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.Request;

public interface RequestDao extends CoreDao<Request, Serializable> 
{
	public List findRequestList(String id)throws DataAccessException;
<<<<<<< HEAD
	public List findReqByCustomer(String customerId) throws DataAccessException;
<<<<<<< HEAD
	public List findRequestById(String id) throws DataAccessException;
=======
=======
	public List findReqByCustomer(String id) throws DataAccessException;
	List findRequestById(String id) throws DataAccessException;
>>>>>>> b9570f1971edf8f5f67f1820f23c153b6ca86b16

>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
}
