package com.test_system;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.test_system.bean.EmployeeBean;
import com.test_system.dao.EmployeeDAO;
import com.test_system.page.MenuPage;
import com.test_system.page.MySession;
import com.test_system.page.TestHeader;

public class HomePage extends TestHeader {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

		final IModel<String> idModel = new Model<>("");
		final IModel<String> passwordModel = new Model<>("");

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				super.onSubmit();

				System.out.println("id : " + idModel.getObject());
				System.out.println("password : " + passwordModel.getObject());
				if (login(idModel.getObject(), passwordModel.getObject())) {
					// ログイン成功
					MySession.get().setLoggedIn(true);
					try {
						setResponsePage(new MenuPage());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					// ログイン失敗
					setResponsePage(new HomePage());
				}
			}
		};

		add(form);
		form.add(new TextField<String>("idField", idModel));
		form.add(new TextField<String>("passwordField", passwordModel));
	}

	public boolean login(String id, String password) {

		// データベースから値を引っ張る(Listで代用中)
		// ArrayList<EmployeeBean> list = new ArrayList<>();
		// list.add(new EmployeeBean("admin", "admin", true));
		// list.add(new EmployeeBean("1", "1", false));
		// list.add(new EmployeeBean("2", "2", false));

		ArrayList<EmployeeBean> list = null;
		EmployeeDAO dao = null;
		try {
			dao = new EmployeeDAO();
			list = (ArrayList<EmployeeBean>) dao.selectEmployee();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// list=null のとき失敗(今回はべた書きだからここを通ることはない)
		if (list.isEmpty()) {
			return false;
		}

		// 処理例(employee.getId()をパスワードと比較しているのはデータベース作るまで保留)
		for (EmployeeBean employee : list) {
			if (employee.getId().equals(id)
					&& employee.getId().equals(password)) {
				MySession.get().setEmployeeBean(employee);
				return true;
			}
		}

		// 認証できないとき
		return false;

	}
}
