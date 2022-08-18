package com.gtt.server.user.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.CompanyDao;
import com.gtt.server.user.entity.Company;
import com.gtt.server.user.entity.UserType;
import com.gtt.server.user.service.CompanyService;

public class CompanyServiceImpl extends CoreServiceImpl<Company,Serializable>
implements CompanyService{

	private CompanyDao companyDao;
	public CompanyServiceImpl(CompanyDao companyDao) {
		super(companyDao);
		this.companyDao = companyDao;
		// TODO Auto-generated constructor stub
	}
	@Override
	public List getCustomerList(String id_company) throws DataAccessException {
		return companyDao.findCustomerList(id_company);
	}
	
	


	
	

}
