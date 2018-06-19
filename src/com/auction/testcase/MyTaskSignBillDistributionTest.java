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
import com.auction.page.MyTaskPage;
import com.auction.page.mytask.MyTaskOfficeDetailToDo;
import com.auction.page.mytask.MyTaskSignBillDistributionDetailToDo;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;

/**
 * 用例:签单分配
 * @author Administrator
 *
 */
@Test(groups = { "LoanStart" })
public class MyTaskSignBillDistributionTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private UserInfo UserInfo1;
	private LoginPage LoginPage;
	private MyTaskPage mytaskpage;
	private HomePage HomePage;
	private MyTaskOfficeDetailToDo mytaskofficedetailtodo;
	protected WebdriverBaseApi webDriver;
	StartCredit stCredit;
	private String CustomerManagerName;  //客户经理名字
	private String CustomerManagerName1; 
	private Logger logger = Logger.getLogger(MyTaskSignBillDistributionTest.class);

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
	public void myTaskSignBillDistribution() {
		boolean flag = false;
		beforeTest("myTaskSignBillDistribution");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "zad1");
			CustomerManagerName = UserInfo.getLoginname();
			UserInfo1 = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName1 = UserInfo1.getLoginname();
			HomePage.goMyTaskPage(1).MyTaskPageStartCredit().goMyTaskSignBillDistributionDetailToDo().MyTaskSignBillDistribution("",CustomerManagerName,CustomerManagerName1);
//			flag = HomePage.isTextPresent("保存成功");
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
//		logger.debug("flag==" + flag);
//		String captureName = afterTest("startcredit", flag);
//		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
//				+ captureName);
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
