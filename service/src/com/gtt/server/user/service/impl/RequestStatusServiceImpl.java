package com.gtt.server.user.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.RequestStatusDao;
import com.gtt.server.user.entity.RequestStatus;
import com.gtt.server.user.service.RequestStatusService;

public class RequestStatusServiceImpl extends CoreServiceImpl<RequestStatus, Serializable>
implements RequestStatusService{
	private RequestStatusDao requestStatusDao;
	public RequestStatusServiceImpl(RequestStatusDao requestStatusDao) {
		super(requestStatusDao);
		this.requestStatusDao = requestStatusDao;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List getAll() throws DataAccessException {
		return requestStatusDao.findAll();
	}

}
