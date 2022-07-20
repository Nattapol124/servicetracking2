package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.CompanyDao;
import com.gtt.server.user.dao.ProjectDao;
import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.Project;

public class CompanyDaoImpl extends CoreDaoImpl<Company, Serializable>implements CompanyDao{
	public CompanyDaoImpl(Class<Company> entityClass) {
		super(entityClass);
	}
	
//	@Override
//	public List findCompanyList(String id_company, String company_name,String company_address) throws DataAccessException{
//		
//		DetachedCriteria criteria = DetachedCriteria.forClass(Company.class);
//		
//		criteria.add(Restrictions.eq("id_company", id_company));
//		criteria.add(Restrictions.eq("company_name",company_name));
//		criteria.add(Restrictions.eq("company_address",company_address));
//
//		List objectList = getHibernateTemplate().findByCriteria(criteria);
//		return objectList;
//	}
}


