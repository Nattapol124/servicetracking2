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
	public List findRequestList(String request_title,String request_file,String request_remark,String request_dateStart,String request_dateEnd,String reqeust_status)
			throws DataAccessException{
		String sql = "SELECT id_request, request_title, request_file, request_remark,request_dateStart,request_dateEnd,request_status FROM request";
		List<Request> results = new ArrayList<Request>();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		if(objectList != null && objectList.size()>0 ) {
			for(Object[] obj : objectList){
			Request item = new Request(Integer.parseInt(String.valueOf(obj[0])));
			item.setRequest_title(request_title);
			item.setRequest_file(request_file);
			item.setRequest_remark(request_remark);
			item.setRequest_dateStart(request_dateStart);
			item.setRequest_dateEnd(request_dateEnd);
			results.add(item);
			System.out.println(results);
		}
	}
		return results;
		
	}

}
