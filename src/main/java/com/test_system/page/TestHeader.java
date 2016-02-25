package com.test_system.page;

import java.sql.SQLException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class TestHeader extends WebPage {
	private static final long serialVersionUID = 1L;

	// ログイン状態に書き換えれる
	Model<String> strModel;

	public TestHeader() {

		strModel = new Model<>("");

		Label helloLabel = new Label("hello", strModel) {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(MySession.get().isLoggedIn());
				if (MySession.get().isLoggedIn()) {
					TestHeader.this.strModel.setObject("こんにちは "
							+ MySession.get().getEmployeeBean().getName()
							+ " さん");
				}
			}
		};

		Link<Void> toMenuPageLink = new Link<Void>("toMenuPage") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				try {
					setResponsePage(new MenuPage());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(MySession.get().isLoggedIn());
			}
		};

		Link<Void> toLogoutPageLink = new Link<Void>("toLogoutPage") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new LogoutPage());
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(MySession.get().isLoggedIn());

			}
		};

		Link<Void> toManagementEmployeePageLink = new Link<Void>(
				"toManagementEmployeePage") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				try {
					setResponsePage(new ManagementEmployeePage());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisibilityAllowed(MySession.get().isLoggedIn()
						&& MySession.get().getEmployeeBean().isAdmin());
			}
		};

		add(toMenuPageLink);
		add(toLogoutPageLink);
		add(toManagementEmployeePageLink);
		add(helloLabel);
	}
}