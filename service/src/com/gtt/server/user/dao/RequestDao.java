package com.gtt.server.user.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.Request;

public interface RequestDao extends CoreDao<Request, Serializable> 
{
	public List findRequestList(String id)throws DataAccessException;

	public List findReqByCustomer(String customerId) throws DataAccessException;

	public List findRequestById(String id) throws DataAccessException;


}
