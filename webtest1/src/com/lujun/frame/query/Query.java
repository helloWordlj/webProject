package com.lujun.frame.query;

import java.util.List;
import java.util.Map;

public interface Query {

	int queryForCount(String statementName, QueryCriteria criteria);

	boolean isExists(String statementName, QueryCriteria criteria);

	List<Map<String, Object>> queryForList(String statementName,
			QueryCriteria criteria);

	List<Map<String, Object>> queryForPage(String statementName,
			QueryCriteria criteria);

	Object queryForObject(String statementName, QueryCriteria criteria);

	void update(String statementName, QueryCriteria criteria);

	String test(String s);

}
