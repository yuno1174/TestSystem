package com.test_system.bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private String id;
	private String name;

	ProductBean() {
		setId("");
		setName("");
	}

	public ProductBean(String id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
