package com.test_system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test_system.bean.ProductBean;

public class ProductDAO {

	public ProductDAO() throws ClassNotFoundException {
		Class.forName(DBSetting.SQL_DRIVER);
	}

	public List<ProductBean> selectProduct() throws SQLException {
		String sql = "select * from product;";
		List<ProductBean> products = new ArrayList<>();

		Connection conn = DriverManager.getConnection(DBSetting.URL,
				DBSetting.USER, DBSetting.PASS);
		Statement stmt = conn.createStatement();

		ResultSet results = stmt.executeQuery(sql);
		while (results.next()) {
			products.add(new ProductBean(results.getString("productid"),
					results.getString("productname")));
		}

		return products;
	}
}
