package com.gtt.server.user.dao.impl;

import java.io.Serializable;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.CompanyTypeDao;
import com.gtt.server.user.entity.CompanyType;

public class CompanyTypeDaoImpl extends CoreDaoImpl<CompanyType, Serializable> implements CompanyTypeDao {
	public CompanyTypeDaoImpl(Class<CompanyType> entityClass) {
		super(entityClass);
	}
}
