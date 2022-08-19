package com.gtt.server.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.CoreService;
import com.gtt.server.user.entity.Request;

public interface RequestService extends CoreService<Request, Serializable>
{
	public List getRequestList(String id)throws DataAccessException;
<<<<<<< HEAD
	public List getReqByCustomer(String customerId) throws DataAccessException;
<<<<<<< HEAD
	public List getReqById(String id) throws DataAccessException;
=======
=======
	public List getReqByCustomer(String id) throws DataAccessException;
	public List getReqById(String id) throws DataAccessException;
>>>>>>> b9570f1971edf8f5f67f1820f23c153b6ca86b16

>>>>>>> 1d7ed70bff8e3af5829783bd506632c8669d20a9
}
