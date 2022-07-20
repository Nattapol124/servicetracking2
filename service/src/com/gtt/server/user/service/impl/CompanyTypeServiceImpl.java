package com.gtt.server.user.service.impl;

import java.io.Serializable;

import com.core.service.impl.CoreServiceImpl;
import com.gtt.server.user.dao.CompanyTypeDao;
import com.gtt.server.user.entity.CompanyType;
import com.gtt.server.user.service.CompanyTypeService;

public class CompanyTypeServiceImpl extends CoreServiceImpl<CompanyType, Serializable>
implements CompanyTypeService {
	private CompanyTypeDao companyTypeDao;
	public CompanyTypeServiceImpl(CompanyTypeDao companyTypeDao) {
		super(companyTypeDao);
		this.companyTypeDao = companyTypeDao;
		// TODO Auto-generated constructor stub
	}

}
