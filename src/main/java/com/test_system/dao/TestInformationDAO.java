package com.test_system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test_system.bean.TestInformationBean;

public class TestInformationDAO {

	public TestInformationDAO() throws ClassNotFoundException {
		Class.forName(DBSetting.SQL_DRIVER);
	}

	// 使われない
	public List<TestInformationBean> selectTestInformation()
			throws SQLException {
		String sql = "select * from test_information";
		List<TestInformationBean> testInformations = new ArrayList<>();

		Connection conn = DriverManager.getConnection(DBSetting.URL,
				DBSetting.USER, DBSetting.PASS);
		Statement stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery(sql);
		while (results.next()) {
			testInformations
					.add(new TestInformationBean(
							results.getString("productid"), results
									.getInt("testnumber"), results
									.getDate("testDay"), results
									.getString("employeeid"), results
									.getString("result"), results
									.getString("remarks")));
		}

		return testInformations;
	}

	// 使われない
	public List<TestInformationBean> selectTestInformation(String productid)
			throws SQLException {
		String sql = "select * from test_information where productid = '"
				+ productid + "';";
		List<TestInformationBean> testInformations = new ArrayList<>();

		Connection conn = DriverManager.getConnection(DBSetting.URL,
				DBSetting.USER, DBSetting.PASS);
		Statement stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery(sql);
		while (results.next()) {
			testInformations
					.add(new TestInformationBean(
							results.getString("productid"), results
									.getInt("testnumber"), results
									.getDate("testDay"), results
									.getString("employeeid"), results
									.getString("result"), results
									.getString("remarks")));
		}

		return testInformations;
	}
}
