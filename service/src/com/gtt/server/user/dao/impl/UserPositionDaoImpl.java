package com.gtt.server.user.dao.impl;

import java.io.Serializable;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.UserPositionDao;
import com.gtt.server.user.entity.UserPosition;


public class UserPositionDaoImpl extends CoreDaoImpl<UserPosition, Serializable> implements UserPositionDao{
	public UserPositionDaoImpl(Class<UserPosition> entityClass) {
		super(entityClass);
	}
}
