package com.test_system.page;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import com.test_system.bean.EmployeeBean;
import com.test_system.dao.EmployeeDAO;

public class ManagementEmployeePage extends TestHeader {
	private static final long serialVersionUID = 1L;

	public ManagementEmployeePage() throws SQLException {
		super();

		// データベースから値を引っ張る(Listで代用中)
		EmployeeDAO dao = null;
		try {
			dao = new EmployeeDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ListView<EmployeeBean> employeesList = new ListView<EmployeeBean>(
				"employees", dao.selectEmployee()) {

			@Override
			protected void populateItem(ListItem<EmployeeBean> item) {

				item.add(new Label("employeeId", item.getModelObject().getId()));
				item.add(new Label("employeeName", item.getModelObject()
						.getName()));
				item.add(new Label("employeeIsAdmin", item.getModelObject()
						.isAdmin()));
			}
		};

		add(employeesList);
	}

	private ArrayList<EmployeeBean> getList() {
		ArrayList<EmployeeBean> list = new ArrayList<>();
		list.add(new EmployeeBean("admin", "admin", true));
		list.add(new EmployeeBean("1", "1", false));
		list.add(new EmployeeBean("2", "2", false));
		return list;
	}
}
