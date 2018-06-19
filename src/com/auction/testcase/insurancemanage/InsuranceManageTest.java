package com.auction.testcase.insurancemanage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.testcase.MyTaskAcceptCreditTest;
import com.framework.util.FrameworkDao;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;

/**
 * ±£œ’π‹¿Ì
 * @author Administrator
 *
 */
public class InsuranceManageTest extends WebdriverBaseCase{
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private HomePage HomePage;
	protected WebdriverBaseApi webDriver;
	private String CustomerManagerName;
	private Logger logger = Logger.getLogger(MyTaskAcceptCreditTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
		} catch (Exception e) {
			logger.error("beforeClassTest error£∫", e);
		}

	}
	
	@Test(enabled = false)
	public void testLogin() {
		boolean flag = false;
		try {
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			HomePage = new HomePage(webDriver);
			LoginPage = HomePage.goLoginPage();
			HomePage = LoginPage.loginOK(UserInfo.getUsername(),
					UserInfo.getPassword(), null);
		} catch (Exception e) {
			logger.error("testLogin error£∫", e);
		}
	}
	
	@Test(enabled = true, alwaysRun = true)
	public void InsuranceManage() {
		boolean flag = false;
		beforeTest("InsuranceManage");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			String customername = HomePage.goInsuranceRegisterDetailToDo().InsuranceRegister(CustomerManagerName);
			 HomePage.goInsuranceRegisterDetailToDo().InsuranceRegisterT(customername);
		} catch (Exception e) {
			logger.error("testLogin error£∫", e);
		}
	}


	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
//			DbUnitUtil.tearDown();
		} catch (Exception e) {
			logger.error("afterClassTest error£∫", e);
		}
		afterClass();
	}
}
