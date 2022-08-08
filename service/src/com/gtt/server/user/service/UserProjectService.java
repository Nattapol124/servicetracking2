package com.gtt.server.user.service;
import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.CoreService;
import com.gtt.server.user.entity.UserProject;


public interface UserProjectService extends CoreService<UserProject, Serializable>{
	public List getUserProject(String id_project) throws DataAccessException;


}
