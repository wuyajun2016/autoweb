package com.auction.testcase.DocDelivery;

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
 * 文档传递-资料复核
 * @author Administrator
 *
 */
public class DocDeliveryContractDataReVerifyTest extends WebdriverBaseCase{
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
			logger.error("beforeClassTest error：", e);
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
			logger.error("testLogin error：", e);
		}
	}
	
	@Test(enabled = true, alwaysRun = true)
	public void DocDeliveryDataReVerify() {
		boolean flag = false;
		beforeTest("DocDeliveryDataReVerify");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			HomePage = HomePage.goMyTaskPage(0).MyTaskPageStartCredit().goDocDeliveryDataReVerifyDetailToDo().DocDeliveryDataReVerify(CustomerManagerName);
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
	}


	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
//			DbUnitUtil.tearDown();
		} catch (Exception e) {
			logger.error("afterClassTest error：", e);
		}
		afterClass();
	}
}
