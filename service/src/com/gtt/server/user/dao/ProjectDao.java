package com.gtt.server.user.dao;
import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.Project;



public interface ProjectDao extends CoreDao<Project, Serializable> {
	public List getProjectById(String userId) throws DataAccessException;
	public List findProjectList(String id_project) throws DataAccessException;
	public List findindicator(String id_company) throws DataAccessException;
	public List getProject(String customerId, String userId) throws DataAccessException;
}