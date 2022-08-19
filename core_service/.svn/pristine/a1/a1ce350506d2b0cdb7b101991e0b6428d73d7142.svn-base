package com.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.core.dao.CoreDao;

public class CoreDaoImpl<T, PK extends Serializable> extends
		HibernateDaoSupport implements CoreDao<T, PK> {

	private Class<T> entityClass;

	public CoreDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void insert(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public T merge(T entity) {
		return getHibernateTemplate().merge(entity);
	}

	@Override
	public void insertOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void insertOrUpdate(List<T> entityList) {
		getHibernateTemplate().saveOrUpdateAll(entityList);
	}

	@Override
	public void delete(PK pk) {
		getHibernateTemplate().delete(findByPrimaryKey(pk));
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(List<T> entityList) {
		getHibernateTemplate().deleteAll(entityList);
	}

	@Override
	public List<T> findAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public T findByPrimaryKey(PK pk) {
		T item = getHibernateTemplate().get(entityClass, pk);
		if (item == null) {
			throw new ObjectRetrievalFailureException(entityClass, pk);
		}
		return item;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByQueryParam(String namedQuery, String[] params, Object[] condition) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(namedQuery, params, condition);
	}

	@Override
	public int sqlQuary(String sql) {
		return getSession().createSQLQuery(sql).executeUpdate();
	}
}
