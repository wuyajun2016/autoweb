package com.auction.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.StartCredit;
import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.MyTaskPage;
import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.auction.page.mytask.MyTaskBranchCompanyManagerDetailToDo;
import com.auction.page.mytask.MyTaskMiddleCheckDetailToDo;
import com.auction.page.mytask.MyTaskOfficeDetailToDo;
import com.auction.page.mytask.MyTaskPrimaryCheckDetailToDo;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.util.RandomIdentify;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;
import com.framework.util.*;

/**
 * 用例:分公司总经理
 * @author Administrator
 *
 */
@Test(groups = { "LoanStart" })
public class MyTaskBranchCompanyManagerTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private MyTaskPage mytaskpage;
	private HomePage HomePage;
	private String CustomerManagerName; 
	private MyTaskBranchCompanyManagerDetailToDo mytaskbranchcompanymanagerdetailtodo;
	protected WebdriverBaseApi webDriver;
	private Logger logger = Logger.getLogger(MyTaskBranchCompanyManagerTest.class);

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
	public void MyTaskBranchCompanyManager() {
		boolean flag = false;
		beforeTest("MyTaskBranchCompanyManager");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			mytaskpage = HomePage.goMyTaskPage(0);
			HomePage = mytaskpage.MyTaskPageStartCredit();
			mytaskbranchcompanymanagerdetailtodo = HomePage.goMyTaskBranchCompanyManagerDetailToDo();
			HomePage = mytaskbranchcompanymanagerdetailtodo.MyTaskPageBranchCompanyManager(CustomerManagerName);
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
