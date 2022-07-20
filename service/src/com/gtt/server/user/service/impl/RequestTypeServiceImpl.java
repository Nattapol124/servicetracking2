package com.gtt.server.user.service.impl;

import java.io.Serializable;

import com.core.dao.CoreDao;
import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.RequestTypeDao;
import com.gtt.server.user.entity.RequestType;
import com.gtt.server.user.service.RequestService;
import com.gtt.server.user.service.RequestTypeService;

public class RequestTypeServiceImpl extends CoreServiceImpl<RequestType, Serializable>
implements RequestTypeService{
	private RequestTypeDao requestTypeDao;
	public RequestTypeServiceImpl(RequestTypeDao requestTypeDao) {
		super(requestTypeDao);
		this.requestTypeDao = requestTypeDao;
		// TODO Auto-generated constructor stub
	}
	

}
