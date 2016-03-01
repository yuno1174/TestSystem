package com.test_system.page;

import org.apache.wicket.markup.html.link.Link;

import com.test_system.HomePage;
import com.test_system.MySession;

public class LogoutPage extends TestHeader {
	private static final long serialVersionUID = 1L;

	public LogoutPage() {
		super();

		// セッションのログアウトの更新
		MySession.get().setLoggedIn(false);

		// セッションの社員情報の消去
		MySession.get().setEmployeeBean(null);

		// ログインページに戻るリンク
		add(new Link<Void>("toHomePage") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new HomePage());
			}
		});
	}
}
