package com.loginDemo.loginDemo;

import java.io.Serializable;
import java.util.List;

public class JTableList<L> implements Serializable {

	private static final long serialVersionUID = 6695625930049463695L;

	private String Result = "ERROR";
	private List<L> Records;
	private long TotalRecordCount;

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public List<L> getRecords() {
		return Records;
	}

	public void setRecords(List<L> records) {
		Records = records;
	}

	public long getTotalRecordCount() {
		return TotalRecordCount;
	}

	public void setTotalRecordCount(long totalRecordCount) {
		TotalRecordCount = totalRecordCount;
	}

}
