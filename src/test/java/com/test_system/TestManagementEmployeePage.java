package com.test_system;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.test_system.page.ManagementEmployeePage;

/**
 * Simple test using the WicketTester
 */
public class TestManagementEmployeePage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void managementEmployeePageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(ManagementEmployeePage.class);

		// assert rendered page class
		tester.assertRenderedPage(ManagementEmployeePage.class);
	}
}
