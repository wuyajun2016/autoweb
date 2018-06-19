package com.auction.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.Configure;
import com.auction.bean.StartCredit;
import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.MyTaskPage;
import com.auction.page.beforeloanmanage.MyTaskInputCreditDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.util.RandomIdentify;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;
import com.framework.util.*;

/**
 * 用例:我的任务-录入征信并提交
 * @author Administrator
 *
 */
@Test(groups = { "StartCredit" })
public class MyTaskInputCreditTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private Configure Configure;
	private LoginPage LoginPage;
	private MyTaskPage mytaskpage;
	private HomePage HomePage;
	private String CustomerManagerName; 
	private int maritalStatus;
	private int relationship;
	private MyTaskInputCreditDetailToDo mytaskinputcreditdetailtodo;
	protected WebdriverBaseApi webDriver;
	StartCredit stCredit;
	private Logger logger = Logger.getLogger(MyTaskInputCreditTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
			Configure = (Configure) FrameworkDao.getRandomObjectByParam(
					"Configure.getUserByParam1", "testSet");
			maritalStatus = Configure.getMaritalStatus();
			relationship = Configure.getRelationship();
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}

	}
	
	@Test(enabled = false)
	public void testLogin() {
		boolean flag = false;
		beforeTest("testLogin");
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
	public void myTaskInputCredit() {
		boolean flag = false;
		beforeTest("myTaskStartCredit");
		try {
			HomePage = new HomePage(webDriver);
			HomePage = HomePage.goMyTaskPage(0).MyTaskPageStartCredit().goInputCreditPage().MyTaskPageStartCredit(maritalStatus,relationship);
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
