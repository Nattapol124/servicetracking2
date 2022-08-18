package com.gtt.server.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.CoreService;
import com.gtt.server.user.entity.RequestStatus;

public interface RequestStatusService extends CoreService<RequestStatus, Serializable> {
	
	public List getAll() throws DataAccessException;

}
