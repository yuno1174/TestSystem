package com.test_system.bean;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	private String id;
	private String name;
	private boolean admin;

	// お勧めしない
	EmployeeBean() {
		id = "";
		name = "";
		admin = false;
	}

	public EmployeeBean(String id, String name, boolean admin) {
		setId(id);
		setName(name);
		setAdmin(admin);
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}