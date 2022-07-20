package com.gtt.server.user.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.Request;

public interface RequestDao extends CoreDao<Request, Serializable> 
{
	public List findRequestList(String request_title,String request_file,String request_remark,String request_dateStart,String request_dateEnd,String reqeust_status)throws DataAccessException;

}
