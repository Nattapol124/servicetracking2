package com.gtt.server.user.dao.impl;

import java.io.Serializable;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.UserProjectDao;
import com.gtt.server.user.entity.UserProject;

public class UserProjectDaoImpl extends CoreDaoImpl<UserProject, Serializable> implements UserProjectDao{

	public UserProjectDaoImpl(Class<UserProject> entityClass) {
		super(entityClass);
	}

}
