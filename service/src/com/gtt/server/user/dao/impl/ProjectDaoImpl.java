package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.ProjectDao;
import com.gtt.server.user.entity.Project;

public class ProjectDaoImpl extends CoreDaoImpl<Project, Serializable>implements ProjectDao{
	public ProjectDaoImpl(Class<Project> entityClass) {
		super(entityClass);
	}
	
//	@Override
//	public List findProjectList(String id_project, String id_company, String project_name) 
//			throws DataAccessException{
//		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
//		
//		criteria.add(Restrictions.eq("id_project", id_project));
//		criteria.add(Restrictions.eq("id_company",id_company));
//		criteria.add(Restrictions.eq("project_name",project_name));
//
//		List objectList = getHibernateTemplate().findByCriteria(criteria);
//		return objectList;
//	}
}


