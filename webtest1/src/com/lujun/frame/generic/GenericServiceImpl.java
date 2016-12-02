package com.lujun.frame.generic;

import java.util.List;
import java.util.Map;

public class GenericServiceImpl<T> implements GenericService<T> {

	protected GenericDao<T> genericDao;

	public GenericServiceImpl(GenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public T save(T entity) {
		return genericDao.save(entity);
	}

	@Override
	public T update(T entity) {
		return genericDao.update(entity);
	}

	@Override
	public void remove(Object id) {
		genericDao.remove(id);
	}

	@Override
	public T find(Object id) {
		return genericDao.find(id);
	}

	@Override
	public List<T> findAll(boolean distinct, int skip, int size) {
		return genericDao.findAll(distinct, skip, size);
	}

	@Override
	public List<T> findByProperty(String field, Object value, int skip, int size) {
		return genericDao.findByProperty(field, value, skip, size);
	}

	@Override
	public int countAll(boolean distinct) {
		return genericDao.countAll(distinct);
	}

	@Override
	public int countByProperty(String field, Object value) {
		return genericDao.countByProperty(field, value);
	}

	@Override
	public <X> X getReference(Class<X> clazz, Object id) {
		return genericDao.getReference(clazz, id);
	}

	@Override
	public <X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip,
			int size, Object... params) {
		return genericDao.findByJPQLQuery(jpql, clazz, skip, size, params);
	}

	@Override
	public <X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip,
			int size, Map<String, Object> params) {
		return genericDao.findByJPQLQuery(jpql, clazz, skip, size, params);
	}

	@Override
	public <X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip,
			int size, Object... params) {
		return genericDao.findByNamedQuery(name, clazz, skip, size, params);
	}

	@Override
	public <X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip,
			int size, Map<String, Object> params) {
		return genericDao.findByNamedQuery(name, clazz, skip, size, params);
	}

	@Override
	public <X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip,
			int size, Object... params) {
		return genericDao.findByNativeQuery(sql, clazz, skip, size, params);
	}

	@Override
	public <X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip,
			int size, Map<String, Object> params) {
		return genericDao.findByNativeQuery(sql, clazz, skip, size, params);
	}

	@Override
	public int countByJPQLQuery(String jpql, Object... params) {
		return genericDao.countByJPQLQuery(jpql, params);
	}

	@Override
	public int countByJPQLQuery(String jpql, Map<String, Object> params) {
		return genericDao.countByJPQLQuery(jpql, params);
	}

	@Override
	public int countByNamedQuery(String name, Object... params) {
		return genericDao.countByNamedQuery(name, params);
	}

	@Override
	public int countByNamedQuery(String name, Map<String, Object> params) {
		return genericDao.countByNamedQuery(name, params);
	}

	@Override
	public int countByNativeQuery(String sql, Object... params) {
		return genericDao.countByNativeQuery(sql, params);
	}

	@Override
	public int countByNativeQuery(String sql, Map<String, Object> params) {
		return genericDao.countByNativeQuery(sql, params);
	}

	@Override
	public int executeByJPQL(String jpql, Object... params) {
		return genericDao.executeByJPQL(jpql, params);
	}

	@Override
	public int executeByJPQL(String jpql, Map<String, Object> params) {
		return genericDao.executeByJPQL(jpql, params);
	}

	@Override
	public int executeBySQL(String sql, Object... params) {
		return genericDao.executeBySQL(sql, params);
	}

	@Override
	public int executeBySQL(String sql, Map<String, Object> params) {
		return genericDao.executeBySQL(sql, params);
	}

}
