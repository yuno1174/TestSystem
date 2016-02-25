package com.test_system;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.test_system.page.ProductTestInformationPage;

/**
 * Simple test using the WicketTester
 */
public class TestProductTestInformationPage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void productTestInformationzPageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(ProductTestInformationPage.class);

		//assert rendered page class
		tester.assertRenderedPage(ProductTestInformationPage.class);
	}
}
