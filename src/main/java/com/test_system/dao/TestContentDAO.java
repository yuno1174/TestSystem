package com.test_system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test_system.bean.TestContentBean;

public class TestContentDAO {

	public TestContentDAO() throws ClassNotFoundException {
		Class.forName(DBSetting.SQL_DRIVER);
	}

	public List<TestContentBean> selectTestContent() throws SQLException {
		String sql = "select * from test_content while ;";
		List<TestContentBean> testContents = new ArrayList<>();

		Connection conn = DriverManager.getConnection(DBSetting.URL,
				DBSetting.USER, DBSetting.PASS);
		Statement stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery(sql);
		while (results.next()) {
			testContents.add(new TestContentBean(
					);
		}

		return testContents;
	}
}
