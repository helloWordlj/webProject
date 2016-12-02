package com.lujun.frame.query;

public class QueryCriteria {

	private int page = 1;

	private int rows = 10;

	public int getIndex() {
		return (page - 1) * rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
