package com.gtt.server.user.dao.impl;

import java.io.Serializable;

import com.core.dao.impl.CoreDaoImpl;
import com.gtt.server.user.dao.UserTypeDao;
import com.gtt.server.user.entity.UserType;


public class UserTypeDaoImpl extends CoreDaoImpl<UserType, Serializable>
		implements UserTypeDao {

	public UserTypeDaoImpl(Class<UserType> entityClass) {
		super(entityClass);
	}

//	@Override
//	public List findUserTypeList(String id_user_type, String user_type_name) throws DataAccessException
// {
//		DetachedCriteria criteria = DetachedCriteria.forClass(UserType.class);
//
//		criteria.add(Restrictions.eq("id_user_type", id_user_type));
//		criteria.add(Restrictions.eq("user_type_name", user_type_name));
//		List objectList = getHibernateTemplate().findByCriteria(criteria);
//
//		return objectList;
//	}

}
