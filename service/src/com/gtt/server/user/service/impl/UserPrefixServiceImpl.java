package com.gtt.server.user.service.impl;

import java.io.Serializable;

import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.entity.UserPrefix;
import com.gtt.server.user.service.UserPrefixService;
import com.gtt.server.user.dao.UserPrefixDao;

public class UserPrefixServiceImpl extends CoreServiceImpl<UserPrefix, Serializable>
implements UserPrefixService{
	private UserPrefixDao userPrefixDao;
	public UserPrefixServiceImpl(UserPrefixDao userPrefixDao) {
		super(userPrefixDao);
		this.userPrefixDao = userPrefixDao;
		// TODO Auto-generated constructor stub
	}
	

}
