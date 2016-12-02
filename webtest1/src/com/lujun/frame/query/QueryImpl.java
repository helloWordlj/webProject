package com.lujun.frame.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;

@Service("query")
public class QueryImpl implements Query {

	private SqlMapClientTemplate SqlMapClientTemplate;

	@Autowired
	public QueryImpl(SqlMapClient sqlMapClient) {
		SqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
	}

	public String test(String a) {
		return a;
	}

	@Override
	public int queryForCount(String statementName, QueryCriteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		Object result = SqlMapClientTemplate.queryForObject(statementName, map);
		return result == null ? 0 : (Integer) result;
	}

	@Override
	public boolean isExists(String statementName, QueryCriteria criteria) {
		return queryForCount(statementName, criteria) > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryForList(String statementName,
			QueryCriteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		return SqlMapClientTemplate.queryForList(statementName, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> queryForPage(String statementName,
			QueryCriteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		return SqlMapClientTemplate.queryForList(statementName, map,
				criteria.getIndex(), criteria.getRows());
	}

	@Override
	public Object queryForObject(String statementName, QueryCriteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		return SqlMapClientTemplate.queryForObject(statementName, map);
	}

	@Override
	public void update(String statementName, QueryCriteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("criteria", criteria);
		SqlMapClientTemplate.update(statementName, map);
	}

}
