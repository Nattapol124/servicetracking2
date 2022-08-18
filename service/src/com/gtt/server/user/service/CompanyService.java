package com.gtt.server.user.service;
import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.service.CoreService;
import com.gtt.server.user.entity.Company;



public interface CompanyService extends CoreService<Company, Serializable> {
	public List getCustomerList(String id_company) throws DataAccessException;

}