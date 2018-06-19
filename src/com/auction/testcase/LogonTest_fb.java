package com.auction.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.StartCredit;
import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;

@Test(groups = { "LogonTest" })
public class LogonTest_fb extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private HomePage HomePage;
	protected WebdriverBaseApi webDriver;
	private Logger logger = Logger.getLogger(LogonTest_fb.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
			DbUnitUtil = new DbUnitUtil();
			DbUnitUtil.setUp();
			DbUnitUtil.insertFileIntoDb("tb_UserInfo");
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}
//		StartCredit test = new StartCredit();
//		test.setCellPhone("15068129031");
//		test.setCustomerName("自动化1");
//		test.setIdentifyNo("110102199701014532");
//		test.setIdentifyType(1);
//		test.setInvestigationBank(1);
//		test.setMaritalStatus(2);
//
//		FrameworkDao.addStudent(test);
	}

	@Test(enabled = true, alwaysRun = true)
	public void testLogin() {
		boolean flag = false;
		try {
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			HomePage = new HomePage(webDriver);
			LoginPage = HomePage.goLoginPage();
			HomePage = LoginPage.loginOK(UserInfo.getUsername(),
					UserInfo.getPassword(), null);
			flag = HomePage.isTextPresent("吴雅军");
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testLogin", flag);
		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
				+ captureName);
	}


	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
			DbUnitUtil.tearDown();
		} catch (Exception e) {
			logger.error("afterClassTest error：", e);
		}
		afterClass();
	}
}
