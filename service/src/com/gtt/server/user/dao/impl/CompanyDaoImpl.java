package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.CompanyDao;
import com.gtt.server.user.dao.ProjectDao;
import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.User;

public class CompanyDaoImpl extends CoreDaoImpl<Company, Serializable>implements CompanyDao{
	public CompanyDaoImpl(Class<Company> entityClass) {
		super(entityClass);
	}

	@Override
	public List findCustomerList(String id_company) throws DataAccessException {

//		String sql = "SELECT DISTINCT company.id_company,company_name FROM company INNER JOIN user on company.id_company=user.id_customer WHERE company.id_company!='0' AND user.id_company='1'";
		String sql = "SELECT DISTINCT company.id_company,company_name,company_address,company_phone,company_fax,company_email FROM company INNER JOIN user on company.id_company=user.id_customer WHERE company.id_company!='99' AND user.id_company='"+id_company+"' ";

		System.out.println("hello customer");
		List<Company> results = new ArrayList<Company>();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
			Company item = new Company();
			item.setId(Integer.parseInt(String.valueOf(obj[0])));
			item.setCompany_name(String.valueOf(obj[1]));
			item.setCompany_address(String.valueOf(obj[2]));
			item.setCompany_phone(String.valueOf(obj[3]));
			item.setCompany_fax(String.valueOf(obj[4]));
			item.setCompany_email(String.valueOf(obj[5]));
			results.add(item);
			System.out.println(results);
			}		
	}	

		return results;
}
}	


