package com.test_system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test_system.bean.EmployeeBean;

public class EmployeeDAO {

	public EmployeeDAO() throws ClassNotFoundException {
		Class.forName(DBSetting.SQL_DRIVER);
	}

	public List<EmployeeBean> selectEmployee() throws SQLException {
		String sql = "select * from employee;";
		List<EmployeeBean> employees = new ArrayList<>();

		Connection conn = DriverManager.getConnection(DBSetting.URL,
				DBSetting.USER, DBSetting.PASS);
		Statement stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery(sql);
		while (results.next()) {
			employees.add(new EmployeeBean(results.getString("employeeid"),
					results.getString("employeename"), results
							.getBoolean("isAdmin")));
		}

		return employees;
	}
}
