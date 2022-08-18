package com.gtt.server.user.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.RequestStatus;

public interface RequestStatusDao extends CoreDao<RequestStatus, Serializable>{
	public List findAll() throws DataAccessException;
}
