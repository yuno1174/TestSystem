package com.test_system.page;

import java.sql.SQLException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;

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
				item.setDefaultModel(new CompoundPropertyModel<>(item
						.getModel()));
				item.add(new Label("employeeId"));
				item.add(new Label("employeeName"));
				item.add(new Label("employeeIsAdmin"));
			}
		};
		add(employeesList);
	}
}