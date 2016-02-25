package com.test_system.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import com.test_system.bean.ProductBean;

public class ProductTestInformationPage extends TestHeader {
	private static final long serialVersionUID = 1L;

	public ProductTestInformationPage(IModel<ProductBean> product) {
		super();

		// セッション確認
		if (!MySession.get().isLoggedIn()) {
			// ログインしてないぞ
		}

		add(new Label("productId", product.getObject().getId()));
		add(new Label("productName", product.getObject().getName()));
	}
}
