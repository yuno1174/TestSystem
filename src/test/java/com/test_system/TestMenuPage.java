package com.test_system;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.test_system.page.MenuPage;

/**
 * Simple test using the WicketTester
 */
public class TestMenuPage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void menupageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(MenuPage.class);

		// assert rendered page class
		tester.assertRenderedPage(MenuPage.class);
	}
}
