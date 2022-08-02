package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.RequestDao;
import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.Request;
import com.gtt.server.user.entity.User;

public class RequestDaoImpl extends CoreDaoImpl<Request, Serializable>
implements RequestDao{
	public RequestDaoImpl(Class<Request> entityClass) {
		super(entityClass);
	}
	@Override
	public List findRequestList(String id)
			throws DataAccessException{
		String sql = "SELECT DISTINCT request.id_request,project.project_name,request.request_title,request.request_remark FROM request INNER JOIN project on request.id_project=project.id_project INNER JOIN user on project.id_customer=user.id_customer WHERE user.id_company='1' AND project.id_project='1'";
		List<Request> results = new ArrayList<Request>();
		Project projectresult = new Project();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
			Request item = new Request(Integer.parseInt(String.valueOf(obj[0])));
			projectresult.setProject_name(String.valueOf(obj[1]));
			item.setId_project(projectresult);
			item.setRequest_title(String.valueOf(obj[2]));
			item.setRequest_remark(String.valueOf(obj[3]));
			results.add(item);
			System.out.println(results);
		}
	}
		return results;
		
	}

}
	