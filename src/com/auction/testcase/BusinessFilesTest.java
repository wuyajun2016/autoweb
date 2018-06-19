package com.auction.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.page.HomePage;
import com.auction.page.businessfiles.BusinessFilesPage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;

@Test(groups = { "BusinessFilesTest" })
public class BusinessFilesTest extends WebdriverBaseCase {
	private BusinessFilesPage BusinessFilesPage;
	private HomePage HomePage;
	protected WebdriverBaseApi webDriver;
	private Logger logger = Logger.getLogger(BusinessFilesTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
		} catch (Exception e) {
			logger.error("beforeClassTest error£º", e);
		}
	}

	@Test(enabled = true, alwaysRun = true)
	public void businessFileTest() {
		boolean flag = false;
		try {
			HomePage = new HomePage(webDriver);
			BusinessFilesPage = HomePage.goBusinessFilesPage();
			HomePage = BusinessFilesPage.clickBusinessFiles();

		} catch (Exception e) {
			logger.error("businessFileTest error£º", e);
		}
//		logger.debug("flag==" + flag);
//		String captureName = afterTest("testLogin", flag);
//		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
//				+ captureName);
	}


	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
			
		} catch (Exception e) {
			logger.error("afterClassTest error£º", e);
		}
		afterClass();
	}
}
