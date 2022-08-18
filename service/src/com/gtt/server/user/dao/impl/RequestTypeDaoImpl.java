package com.gtt.server.user.dao.impl;

import java.io.Serializable;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.RequestTypeDao;
import com.gtt.server.user.entity.RequestType;

public class RequestTypeDaoImpl extends CoreDaoImpl<RequestType, Serializable>
implements RequestTypeDao{
	public RequestTypeDaoImpl(Class<RequestType> entityClass) {
		super(entityClass);
	}
}
