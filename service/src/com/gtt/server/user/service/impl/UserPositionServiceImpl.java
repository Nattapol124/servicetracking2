package com.gtt.server.user.service.impl;

import java.io.Serializable;

import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.UserPositionDao;
import com.gtt.server.user.entity.UserPosition;
import com.gtt.server.user.service.UserPositionService;

public class UserPositionServiceImpl extends CoreServiceImpl<UserPosition,Serializable> 
implements UserPositionService{
	
	private UserPositionDao userPositionDao;
	public UserPositionServiceImpl(UserPositionDao userPositionDao) {
		super(userPositionDao);
		this.userPositionDao = userPositionDao;
		
	}

}
