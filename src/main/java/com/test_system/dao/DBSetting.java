package com.test_system.dao;


public class DBSetting {

	public static final String SQL_DRIVER = "org.postgresql.Driver";
	public static final String URL = "jdbc:postgresql://127.0.0.1:5432/testsystem";
	public static final String USER = "postgres";
	public static final String PASS = "postgres";

	DBSetting() {
		throw new AssertionError("インスタンス化してはいけない");
	}
}