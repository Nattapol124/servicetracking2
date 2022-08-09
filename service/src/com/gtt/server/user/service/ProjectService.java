package com.gtt.server.user.service;
import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.CoreService;
import com.gtt.server.user.entity.Project;



public interface ProjectService extends CoreService<Project, Serializable> {
	public List getProject(String userId) throws DataAccessException;
	public List getProjectList(String company)
			throws DataAccessException;
	public List getindicator(String id_company) throws DataAccessException;
}