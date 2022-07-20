package com.core.service.impl;

import java.io.Serializable;
import java.util.List;

import com.core.dao.CoreDao;
import com.core.service.CoreService;

public class CoreServiceImpl<T, PK extends Serializable> implements
		CoreService<T, PK> {

	private CoreDao<T, PK> coreDao;

	public CoreServiceImpl(CoreDao<T, PK> coreDao) {
		this.coreDao = coreDao;
	}

	@Override
	public void saveItem(T entity) {
		coreDao.insert(entity);
	}

	@Override
	public void updateItem(T entity) {
		coreDao.update(entity);
	}

	@Override
	public T mergeItem(T entity) {
		return coreDao.merge(entity);
	}

	@Override
	public void saveOrUpdateItem(T entity) {
		coreDao.insertOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateItems(List<T> entityList) {
		coreDao.insertOrUpdate(entityList);
	}

	@Override
	public void removeItem(PK pk) {
		coreDao.delete(pk);
	}

	@Override
	public void removeItem(T entity) {
		coreDao.delete(entity);
	}

	@Override
	public void removeItems(List<T> entityList) {
		coreDao.delete(entityList);
	}

	@Override
	public List<T> getAllItems() {
		return coreDao.findAll();
	}

	@Override
	public T getItem(PK pk) {
		return coreDao.findByPrimaryKey(pk);
	}

	@Override
	public List<T> getItemsByCondition(String namedQuery, String[] params, Object[] conditions) {
		return coreDao.findByQueryParam(namedQuery, params, conditions);
	}

	@Override
	public void saveItems(List<T> entityList) {
		for (T item : entityList) {
			coreDao.insert(item);
		}
	}

	@Override
	public int getSqlQuary(String sql) {
		return coreDao.sqlQuary(sql);
	}
}
