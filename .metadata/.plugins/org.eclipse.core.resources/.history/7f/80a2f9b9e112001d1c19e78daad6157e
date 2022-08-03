package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.RequestDao;
import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.Request;
import com.gtt.server.user.entity.RequestStatus;
import com.gtt.server.user.entity.RequestType;
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
	@Override
	public List findReqByCustomer(String customerId) throws DataAccessException {	
		
		String sql = "select request.id_request, user.id_user, user.user_nickname, request.id_user_process"
				+ ", requeststatus.id_request_status, requeststatus.status_name, requesttype.id_request_type"
				+ ", requesttype.type_name, project.id_project, project.project_name, request.request_title"
				+ ", request.request_remark, request.request_date, request.request_file from request "
				+ "inner join user on request.id_user = user.id_user "
				+ "inner join requeststatus on request.id_request_status = requeststatus.id_request_status "
				+ "inner join requesttype on request.id_request_type = requesttype.id_request_type "
				+ "inner join project on request.id_project = project.id_project "
				+ "where user.id_customer ="+customerId;
		
		List<Request> results =new ArrayList<Request>();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		
		
		if(objectList != null && objectList.size() > 0) {
			for (Object[] obj : objectList) {
				User user = new User();
				User userproc = new User();
				RequestStatus reqS = new RequestStatus();
				RequestType reqT = new RequestType();
				Project project = new Project();
				Request item = new Request(Integer.parseInt(String.valueOf(obj[0])));
				user.setId(Integer.parseInt(String.valueOf( obj[1])));
				user.setNickname(String.valueOf(obj[2]));
				item.setId_user(user);
				userproc.setId(Integer.parseInt(String.valueOf( obj[3])));

				item.setId_user_process(userproc);
				reqS.setId(Integer.parseInt(String.valueOf(obj[4])));
				reqS.setStatus_name(String.valueOf(obj[5]));
				item.setId_request_status(reqS);
				reqT.setId(Integer.parseInt(String.valueOf( obj[6])));
				reqT.setType_name((String.valueOf( obj[7])));
				item.setId_request_type(reqT);
				project.setId(Integer.parseInt(String.valueOf(obj[8])));
				project.setProject_name(String.valueOf(obj[9]));
				item.setId_project(project);
				item.setRequest_title(String.valueOf(obj[10]));
				item.setRequest_remark(String.valueOf(obj[11]));
				item.setRequest_date((Date) obj[12]);
				item.setRequest_file(String.valueOf(obj[13]));

				
				results.add(item);
			}
			
			
		}
		return results;
	}
}
	