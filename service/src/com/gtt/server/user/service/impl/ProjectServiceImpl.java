package com.gtt.server.user.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.ProjectDao;
import com.gtt.server.user.entity.Project;
import com.gtt.server.user.service.ProjectService;

public class ProjectServiceImpl extends CoreServiceImpl<Project,Serializable>
implements ProjectService{
	
	private ProjectDao projectDao;
	public ProjectServiceImpl(ProjectDao projectDao) {
		super(projectDao);
		this.projectDao = projectDao;
		// TODO Auto-generated constructor stub
	}
	@Override
	public List getProjectList(String company) throws DataAccessException {
		return projectDao.findProjectList(company);
	}
	@Override
	public List getindicator(String id_company) throws DataAccessException {
		return projectDao.findindicator(id_company);
	}
	@Override
	public List getProject(String userId) throws DataAccessException {
		return projectDao.getProject(userId);
	}

	


}
