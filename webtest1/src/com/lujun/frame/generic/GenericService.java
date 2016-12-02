package com.lujun.frame.generic;

import java.util.List;
import java.util.Map;

public interface GenericService<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 *            主键
	 */
	void remove(Object id);

	/**
	 * 查找实体
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	T find(Object id);

	/**
	 * 查找所有实体
	 * 
	 * @param distinct
	 *            去除重复
	 * @param skip
	 * @param size
	 * @return
	 */
	List<T> findAll(boolean distinct, int skip, int size);

	/**
	 * 按字段查找实体
	 * 
	 * @param field
	 *            字段名
	 * @param value
	 *            字段值
	 * @param skip
	 * @param size
	 * @return
	 */
	List<T> findByProperty(String field, Object value, int skip, int size);

	/**
	 * 获取所有条数
	 * 
	 * @param distinct
	 *            去除重复
	 * @return
	 */
	int countAll(boolean distinct);

	/**
	 * 按字段获取条数
	 * 
	 * @param field
	 *            字段名
	 * @param value
	 *            字段值
	 * @return
	 */
	int countByProperty(String field, Object value);

	//
	// 以下是通用操作方法
	// （不局限当前实体）
	//

	/**
	 * 获取代理实体
	 * 
	 * @param clazz
	 *            实体类型
	 * @param id
	 *            主键
	 * @return
	 */
	<X> X getReference(Class<X> clazz, Object id);

	/**
	 * 使用JPQL语句查找实体
	 * 
	 * @param jpql
	 * @param clazz
	 * @param skip
	 * @param size
	 * @param params
	 *            位置参数
	 * @return
	 */
	<X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip,
			int size, Object... params);

	/**
	 * 使用JPQL语句查找实体
	 * 
	 * @param jpql
	 * @param clazz
	 * @param skip
	 * @param size
	 * @param params
	 *            命名参数
	 * @return
	 */
	<X> List<X> findByJPQLQuery(String jpql, Class<X> clazz, int skip,
			int size, Map<String, Object> params);

	/**
	 * 使用命名查询查找实体
	 * 
	 * @param name
	 * @param clazz
	 * @param skip
	 * @param size
	 * @param params
	 *            位置参数
	 * @return
	 */
	<X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip,
			int size, Object... params);

	/**
	 * 使用命名查询查找实体
	 * 
	 * @param name
	 * @param clazz
	 * @param skip
	 * @param size
	 * @param params
	 *            命名参数
	 * @return
	 */
	<X> List<X> findByNamedQuery(String name, Class<X> clazz, int skip,
			int size, Map<String, Object> params);

	/**
	 * 使用原生SQL查找实体
	 * 
	 * @param sql
	 * @param clazz
	 * @param skip
	 * @param size
	 * @param params
	 *            位置参数
	 * @return
	 */
	<X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip,
			int size, Object... params);

	/**
	 * 使用原生SQL查找实体
	 * 
	 * @param sql
	 * @param clazz
	 * @param skip
	 * @param size
	 * @param params
	 *            命名参数
	 * @return
	 */
	<X> List<X> findByNativeQuery(String sql, Class<X> clazz, int skip,
			int size, Map<String, Object> params);

	/**
	 * 使用JPQL语句获取条数
	 * 
	 * @param jpql
	 * @param params
	 *            位置参数
	 * @return
	 */
	int countByJPQLQuery(String jpql, Object... params);

	/**
	 * 使用JPQL语句获取条数
	 * 
	 * @param jpql
	 * @param params
	 *            命名参数
	 * @return
	 */
	int countByJPQLQuery(String jpql, Map<String, Object> params);

	/**
	 * 使用命名查询获取条数
	 * 
	 * @param name
	 * @param params
	 *            位置参数
	 * @return
	 */
	int countByNamedQuery(String name, Object... params);

	/**
	 * 使用命名查询获取条数
	 * 
	 * @param name
	 * @param params
	 *            命名参数
	 * @return
	 */
	int countByNamedQuery(String name, Map<String, Object> params);

	/**
	 * 使用原生SQL获取条数
	 * 
	 * @param sql
	 * @param params
	 *            位置参数
	 * @return
	 */
	int countByNativeQuery(String sql, Object... params);

	/**
	 * 使用原生SQL获取条数
	 * 
	 * @param sql
	 * @param params
	 *            命名参数
	 * @return
	 */
	int countByNativeQuery(String sql, Map<String, Object> params);

	/**
	 * 执行JPQL语句（常用于批量操作）
	 * 
	 * @param jpql
	 * @param params
	 *            位置参数
	 * @return
	 */
	int executeByJPQL(String jpql, Object... params);

	/**
	 * 执行JPQL语句（常用于批量操作）
	 * 
	 * @param jpql
	 * @param params
	 *            命名参数
	 * @return
	 */
	int executeByJPQL(String jpql, Map<String, Object> params);

	/**
	 * 执行原生SQL（常用于批量操作）
	 * 
	 * @param jpql
	 * @param params
	 *            位置参数
	 * @return
	 */
	int executeBySQL(String sql, Object... params);

	/**
	 * 执行原生SQL（常用于批量操作）
	 * 
	 * @param jpql
	 * @param params
	 *            命名参数
	 * @return
	 */
	int executeBySQL(String sql, Map<String, Object> params);

}
