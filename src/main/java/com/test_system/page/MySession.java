package com.test_system.page;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.test_system.bean.EmployeeBean;

public final class MySession extends WebSession {

	private EmployeeBean employeeBean;
	private boolean loggedIn;

	public MySession(Request request) {
		super(request);
		setEmployeeBean(null);
		setLoggedIn(false);
	}

	public static MySession get() {
		return (MySession) WebSession.get();
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
