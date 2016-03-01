package com.test_system.page;

import java.sql.SQLException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import com.test_system.MySession;
import com.test_system.bean.ProductBean;
import com.test_system.bean.TestContentBean;
import com.test_system.bean.TestInformationBean;
import com.test_system.dao.TestContentDAO;
import com.test_system.dao.TestInformationDAO;

public class ProductTestInformationPage extends TestHeader {
	private static final long serialVersionUID = 1L;

	public ProductTestInformationPage(IModel<ProductBean> product)
			throws SQLException {
		super();

		// セッション確認
		if (!MySession.get().isLoggedIn()) {
			// ログインしてないぞ
		}

		// データベースから値を引っ張る
		TestContentDAO contentDao = null;
		try {
			contentDao = new TestContentDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		TestInformationDAO informarionDao = null;
		try {
			informarionDao = new TestInformationDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ListView<TestContentBean> testContents = new ListView<TestContentBean>(
				"testContents", contentDao.selectTestContent(product
						.getObject().getId())) {

			@Override
			protected void populateItem(ListItem<TestContentBean> item) {
				item.setDefaultModel(new CompoundPropertyModel<>(item
						.getModel()));
				item.add(new Label("testNumber"));
				item.add(new Label("type"));
				item.add(new Label("step"));
				item.add(new Label("expectedOutput"));
			}
		};
		ListView<TestInformationBean> testInformations = new ListView<TestInformationBean>(
				"testInformations",
				informarionDao.selectTestInformation(product.getObject()
						.getId())) {

			@Override
			protected void populateItem(ListItem<TestInformationBean> item) {
				item.setDefaultModel(new CompoundPropertyModel<>(item
						.getModel()));
				item.add(new Label("testNumber"));
				item.add(new Label("testDay"));
				item.add(new Label("employeeId"));
				item.add(new Label("result"));
				item.add(new Label("remarks"));
			}
		};

		add(testContents);
		add(testInformations);

		add(new Label("productId", product.getObject().getId()));
		add(new Label("productName", product.getObject().getName()));
	}
}