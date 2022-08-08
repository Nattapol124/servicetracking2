package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.UserProjectDao;
import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.User;
import com.gtt.server.user.entity.UserProject;
import com.gtt.server.user.entity.UserType;

public class UserProjectDaoImpl extends CoreDaoImpl<UserProject, Serializable> implements UserProjectDao{

	public UserProjectDaoImpl(Class<UserProject> entityClass) {
		super(entityClass);
	}

	@Override
	public List findUserProject(String id_project) throws DataAccessException {
		String sql = "SELECT user.id_user,user.username,user.user_firstname,user.user_lastname FROM `userproject` INNER JOIN user ON userproject.id_user=user.id_user WHERE id_project='6'AND user.id_customer='0';";
		List<User> results = new ArrayList<User>();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
			User item = new User(Integer.parseInt(String.valueOf(obj[0])));
			item.setUsername(String.valueOf(obj[1]));
			item.setUser_firstname(String.valueOf(obj[2]));
			item.setUser_lastname(String.valueOf(obj[3]));			
			results.add(item);
		}
	}
		return results;// TODO Auto-generated method stub
	}

}
