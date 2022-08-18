package com.gtt.server.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.UserProjectDao;
import com.gtt.server.user.dao.UserPrefixDao;
import com.gtt.server.user.entity.UserPrefix;

public class UserPrefixDaoImpl extends CoreDaoImpl<UserPrefix, Serializable>implements UserPrefixDao{
	public UserPrefixDaoImpl(Class<UserPrefix> entityClass) {
		super(entityClass);
	}
	
//	@Override
//	public List findUser_prefixList(String id_user_type, String user_type_name) throws DataAccessException{
//		DetachedCriteria criteria = DetachedCriteria.forClass(User_prefix.class);
//		
//		criteria.add(Restrictions.eq("id_user_type", id_user_type));
//		criteria.add(Restrictions.eq("user_type_name",user_type_name));
//	
//		List objectList = getHibernateTemplate().findByCriteria(criteria);
//		return objectList;
//	}
}


