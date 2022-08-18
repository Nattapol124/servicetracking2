package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.RequestStatusDao;
import com.gtt.server.user.entity.Project;
import com.gtt.server.user.entity.Request;
import com.gtt.server.user.entity.RequestStatus;

public class RequestStatusDaoImpl extends CoreDaoImpl<RequestStatus, Serializable> 
implements RequestStatusDao{
	
	private RequestStatusDao requestStatusDao; 

	public RequestStatusDaoImpl(Class<RequestStatus> entityClass) {
		super(entityClass);
	}
	
	@Override
	public List findAll() throws DataAccessException {
		// ต้อง select form SQL ไม่ได้ทำแบบ DetachedCriteria
//		DetachedCriteria criteria = DetachedCriteria.forClass(RequestStatus.class);
//		criteria.addOrder(Order.asc("id"));
//		List objectList = getHibernateTemplate().findByCriteria(criteria);
//		return objectList;
		
		String sql = "SELECT requeststatus.id_request_status, requeststatus.status_name FROM requeststatus ";
		List<RequestStatus> results = new ArrayList<RequestStatus>();
		List<Object[]> objectList = getSession().createSQLQuery(sql).list();
		System.out.println("objectList project = " + objectList);
		if(objectList != null && objectList.size() > 0) {
			for (Object[] obj : objectList) {
				RequestStatus item = new RequestStatus();
				item.setId(Integer.parseInt(String.valueOf(obj[0])));
				item.setStatus_name(String.valueOf(obj[1]));
				
				results.add(item);
			}
		}   
		return results;
		
	}
	
	
	
}
