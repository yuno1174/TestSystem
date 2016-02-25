package com.test_system;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.test_system.page.LogoutPage;

/**
 * Simple test using the WicketTester
 */
public class TestLogoutPage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void logoutpageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(LogoutPage.class);

		// assert rendered page class
		tester.assertRenderedPage(LogoutPage.class);
	}
}
