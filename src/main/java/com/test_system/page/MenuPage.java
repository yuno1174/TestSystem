package com.test_system.page;

import java.sql.SQLException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.test_system.MySession;
import com.test_system.bean.ProductBean;
import com.test_system.dao.ProductDAO;

public class MenuPage extends TestHeader {
	private static final long serialVersionUID = 1L;

	public MenuPage() throws SQLException {
		super();

		// セッション確認
		if (!MySession.get().isLoggedIn()) {
			// ログインしてないぞ
		}

		// データベースから値を引っ張る(Listで代用中)

		ProductDAO dao = null;
		try {
			dao = new ProductDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ListView<ProductBean> productsList = new ListView<ProductBean>(
				"products", dao.selectProduct()) {
			@Override
			protected void populateItem(final ListItem<ProductBean> item) {

				ProductBean product = (ProductBean) item.getModelObject();

				Link<Void> toProductTestInfomationPageLink = new Link<Void>(
						"toProductTestInfomationPage") {
					@Override
					public void onClick() {
						try {
							setResponsePage(new ProductTestInformationPage(
									item.getModel()));
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				};
				item.add(toProductTestInfomationPageLink);
				toProductTestInfomationPageLink.add(new Label("productId",
						product.getId()));
				item.add(new Label("productName", product.getName()));
			}
		};
		add(productsList);
	}
}