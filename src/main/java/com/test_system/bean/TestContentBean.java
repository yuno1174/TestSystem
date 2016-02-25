package com.test_system.bean;

import java.io.Serializable;

public class TestContentBean implements Serializable {
	private String productId;
	private int testNumber;
	private String type;
	private String step;
	private String expectedOutput;

	// 使ってほしくない
	public TestContentBean() {
		setProductId("");
		setTestNumber(-1);
		setType("");
		setStep("");
		setExpectedOutput("");
	}

	public TestContentBean(String productId, int testNumber, String type,
			String step, String expectedOutput) {
		setProductId(productId);
		setTestNumber(testNumber);
		setType(type);
		setStep(step);
		setExpectedOutput(expectedOutput);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

}
