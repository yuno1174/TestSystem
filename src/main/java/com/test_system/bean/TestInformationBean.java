package com.test_system.bean;

import java.io.Serializable;
import java.sql.Date;

public class TestInformationBean implements Serializable {
	private String productId;
	private int testNumber;
	private Date testDay;
	private String employeeId;
	private String result;
	private String remarks;

	// 使わないで
	public TestInformationBean() {
		setProductId("");
		setTestNumber(-1);
		setTestDay(null);
		setEmployeeId("");
		setResult("");
		setRemarks("");
	}

	public TestInformationBean(String productId, int testNumber, Date testDay,
			String employeeId, String result, String remarks) {
		setProductId(productId);
		setTestNumber(testNumber);
		setTestDay(testDay);
		setEmployeeId(employeeId);
		setResult(result);
		setRemarks(remarks);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}

	public Date getTestDay() {
		return testDay;
	}

	public void setTestDay(Date testDay) {
		this.testDay = testDay;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
