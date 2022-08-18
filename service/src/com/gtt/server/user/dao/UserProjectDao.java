package com.gtt.server.user.dao;
import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.UserProject;



public interface UserProjectDao extends CoreDao<UserProject, Serializable> {
	public List findUserProject(String id_project) throws DataAccessException;


}