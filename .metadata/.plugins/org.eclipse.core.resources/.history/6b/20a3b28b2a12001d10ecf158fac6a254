package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.ProjectDao;
import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.Project;

public class ProjectDaoImpl extends CoreDaoImpl<Project, Serializable>implements ProjectDao{
	public ProjectDaoImpl(Class<Project> entityClass) {
		super(entityClass);
	}
	
	@Override
	public List findProjectList(String company) throws DataAccessException {
		System.out.println("findProjectList!!");
		String sql = "SELECT project.id_project, project.project_name, customer.company_name , company.company_name  FROM user inner join project on user.id_customer = project.id_customer inner join company on user.id_company = company.id_company inner join company customer on user.id_customer = customer.id_company WHERE user.id_company='"+company+"' GROUP BY project.id_project";
		System.out.println("sql project = " + sql);
		List<Project> results = new ArrayList<Project>();
		Company Company_results = new Company();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		System.out.println("objectList project = " + objectList);
		if (objectList != null && objectList.size() > 0) {
			for (Object[] obj : objectList) {
				Project item = new Project();
				item.setId(Integer.parseInt(String.valueOf(obj[0])));
				item.setProject_name(String.valueOf(obj[1]));
				Company_results.setCompany_name(company);
				Company_results.setCompany_name(String.valueOf(obj[3]));

				item.setId_customer(Company_results);
				results.add(item);
				System.out.println("results = " + results);
			}
		}
		return results;

	}

	@Override
	public List findindicator(String id_company) throws DataAccessException {
		String sql = "SELECT DISTINCT project.id_project,project.project_name FROM project INNER JOIN user ON project.id_customer=user.id_customer WHERE user.id_company='"+id_company+"'";
		List<Project> results = new ArrayList<Project>();
		Company Company_results = new Company();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		System.out.println("objectList project = " + objectList);
		if (objectList != null && objectList.size() > 0) {
			for (Object[] obj : objectList) {
				Project item = new Project();
				item.setId(Integer.parseInt(String.valueOf(obj[0])));
				item.setProject_name(String.valueOf(obj[1]));
				System.out.println(item.getProject_name()+"projectname");
				results.add(item);
			}
		}		return results;
	}
	
}


