package com.lujun.frame.generic;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

@SuppressWarnings("unchecked")
public class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;
	protected Class<T> clazz;

	public GenericDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void remove(Object id) {
		T entity = entityManager.getReference(clazz, id);
		entityManager.remove(entity);
	}

	@Override
	public T find(Object id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public List<T> findAll(boolean distinct, int skip, int size) {
		StringBuilder jpql = new StringBuilder("select");
		if (distinct)
			jpql.append(" distinct");
		jpql.append(" t from " + clazz.getSimpleName() + " t");
		return findByJPQLQuery(jpql.toString(), clazz, skip, size,
				(Object[]) null);
	}

	@Override
	public List<T> findByProperty(String field, Object value, int skip, int size) {
		StringBuilder jpql = new StringBuilder("select");
		jpql.append(" t from " + clazz.getSimpleName() + " t");
		jpql.append(" where t." + field + " = ?1");
		return findByJPQLQuery(jpql.toString(), clazz, skip, size, value);
	}

	@Override
	public int countAll(boolean distinct) {
		StringBuilder jpql = new StringBuilder("select count(");
		if (distinct)
			jpql.append("distinct ");
		jpql.append("t) from " + clazz.getSimpleName() + " t");
		return countByJPQLQuery(jpql.toString(), (Object[]) null);
	}

	@Override
	public int countByProperty(String field, Object value) {
		StringBuilder jpql = new StringBuilder("select count(");
		jpql.append("t) from " + clazz.getSimpleName() + " t");
		jpql.append(" where t." + field + " = ?1");
		return countByJPQLQuery(jpql.toString(), value);
	}

	@Override
	public <A> A getReference(Class<A> clazz, Object id) {
		return entityManager.getReference(clazz, id);
	}

	@Override
	public <X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip,
			int size, Object... params) {
		return findByQuery(entityManager.createQuery(jpql), clazz, params,
				skip, size);
	}

	@Override
	public <X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip,
			int size, Map<String, Object> params) {
		return findByQuery(entityManager.createQuery(jpql), clazz, params,
				skip, size);
	}

	@Override
	public <X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip,
			int size, Object... params) {
		return findByQuery(entityManager.createNamedQuery(name), clazz, params,
				skip, size);
	}

	@Override
	public <X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip,
			int size, Map<String, Object> params) {
		return findByQuery(entityManager.createNamedQuery(name), clazz, params,
				skip, size);
	}

	@Override
	public <X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip,
			int size, Object... params) {
		if (clazz == null) {
			Query query = entityManager.createNativeQuery(sql);
			//返回Map对象
			query.unwrap(SQLQuery.class).setResultTransformer(
					Transformers.ALIAS_TO_ENTITY_MAP);
			return findByQuery(query, clazz, params, skip, size);
		} else {
			Query query = entityManager.createNativeQuery(sql, clazz);
			return findByQuery(query, clazz, params, skip, size);
		}
	}

	@Override
	public <X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip,
			int size, Map<String, Object> params) {
		if (clazz == null) {
			Query query = entityManager.createNativeQuery(sql);
			//返回Map对象
			query.unwrap(SQLQuery.class).setResultTransformer(
					Transformers.ALIAS_TO_ENTITY_MAP);
			return findByQuery(query, clazz, params, skip, size);
		} else {
			Query query = entityManager.createNativeQuery(sql, clazz);
			return findByQuery(query, clazz, params, skip, size);
		}
	}

	@Override
	public int countByJPQLQuery(String jpql, Object... params) {
		return countByQuery(entityManager.createQuery(jpql), params);
	}

	@Override
	public int countByJPQLQuery(String jpql, Map<String, Object> params) {
		return countByQuery(entityManager.createQuery(jpql), params);
	}

	@Override
	public int countByNamedQuery(String name, Object... params) {
		return countByQuery(entityManager.createNamedQuery(name), params);
	}

	@Override
	public int countByNamedQuery(String name, Map<String, Object> params) {
		return countByQuery(entityManager.createNamedQuery(name), params);
	}

	@Override
	public int countByNativeQuery(String sql, Object... params) {
		return countByQuery(entityManager.createNativeQuery(sql), params);
	}

	@Override
	public int countByNativeQuery(String sql, Map<String, Object> params) {
		return countByQuery(entityManager.createNativeQuery(sql), params);
	}

	@Override
	public int executeByJPQL(String jpql, Object... params) {
		Query query = entityManager.createQuery(jpql);
		if (params != null) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i + 1, params[i]);
		}
		return query.executeUpdate();
	}

	@Override
	public int executeByJPQL(String jpql, Map<String, Object> params) {
		Query query = entityManager.createQuery(jpql);
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet())
				query.setParameter(param.getKey(), param.getValue());
		}
		return query.executeUpdate();
	}

	@Override
	public int executeBySQL(String sql, Object... params) {
		Query query = entityManager.createNativeQuery(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i + 1, params[i]);
		}
		return query.executeUpdate();
	}

	@Override
	public int executeBySQL(String sql, Map<String, Object> params) {
		Query query = entityManager.createNativeQuery(sql);
		if (params != null) {
			for (Entry<String, Object> param : params.entrySet())
				query.setParameter(param.getKey(), param.getValue());
		}
		return query.executeUpdate();
	}

	private <X> List<X> findByQuery(Query query, Class<X> calzz, Object object,
			int skip, int size) {
		query.setHint("org.hibernate.cacheMode", "REFRESH");//开启缓存
		if (object != null) {
			if (object instanceof Map) {
				Map<String, Object> params = (Map<String, Object>) object;
				for (Entry<String, Object> param : params.entrySet())
					query.setParameter(param.getKey(), param.getValue());
			} else {
				Object[] params = (Object[]) object;
				for (int i = 0; i < params.length; i++)
					query.setParameter(i + 1, params[i]);
			}
		}
		if (skip >= 0 && size > 0) {
			query.setFirstResult(skip);
			query.setMaxResults(size);
		}
		return query.getResultList();
	}

	private int countByQuery(Query query, Object object) {
		if (object != null) {
			if (object instanceof Map) {
				Map<String, Object> params = (Map<String, Object>) object;
				for (Entry<String, Object> param : params.entrySet())
					query.setParameter(param.getKey(), param.getValue());
			} else {
				Object[] params = (Object[]) object;
				for (int i = 0; i < params.length; i++)
					query.setParameter(i + 1, params[i]);
			}
		}
		Object result = query.getSingleResult();
		return result == null ? 0 : Integer.parseInt(result.toString());
	}

}
