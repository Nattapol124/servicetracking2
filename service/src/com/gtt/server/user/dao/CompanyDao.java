package com.gtt.server.user.dao;
import java.io.Serializable;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.CoreDao;
import com.gtt.server.user.entity.Company;



public interface CompanyDao extends CoreDao<Company, Serializable> {

//	public List findCompanyList(String id_company, String company_name,String company_address) throws DataAccessException;

}