package com.gtt.server.user.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.UserProjectDao;
import com.gtt.server.user.entity.UserProject;
import com.gtt.server.user.service.UserProjectService;

public class UserProjectServiceImpl extends CoreServiceImpl<UserProject, Serializable>
implements UserProjectService{
	private UserProjectDao userprojectDao;
	public UserProjectServiceImpl(UserProjectDao userprojectDao) {
		super(userprojectDao);
		this.userprojectDao = userprojectDao;
		// TODO Auto-generated constructor stub
	}
	@Override
	public List getUserProject(String id_project) throws DataAccessException {
		return userprojectDao.findUserProject(id_project);
	}

}
