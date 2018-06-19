package com.auction.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.util.RandomIdentify;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;
import com.framework.util.*;

/**
 * 用例：新建客户
 * @author Administrator
 *
 */
@Test(groups = { "LogonTest" })
public class CustomerManageTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private CustomerManagePage CustomerManagePage;
	private HomePage HomePage;
	protected WebdriverBaseApi webDriver;
	private RandomIdentify RandomIdentify;
	private String CustomerManagerName;  //客户经理名字
	private String customerName;  //借款人姓名
	private String identifyNo;    //身份证号码
	private String CellPhone;     //借款人手机号码
	private int identifytype=1;   //证件类型自定义为身份证
	private Logger logger = Logger.getLogger(CustomerManageTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
			RandomIdentify=new RandomIdentify();
//			DbUnitUtil = new DbUnitUtil();
//			DbUnitUtil.setUp();
//			DbUnitUtil.insertFileIntoDb("tb_UserInfo");
			customerName = RandomUtil.getChineseName();
			identifyNo = RandomIdentify.getIDCard();
			CellPhone = RandomUtil.getTel();
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}

	}
	
	@Test(enabled = true, alwaysRun = true)
	public void testLogin() {
		boolean flag = false;
		beforeTest("testLogin");
		try {
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			HomePage = new HomePage(webDriver);
			LoginPage = HomePage.goLoginPage();
			HomePage = LoginPage.loginOK(UserInfo.getUsername(),
					UserInfo.getPassword(), null);
			flag = HomePage.isTextPresent(CustomerManagerName);
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testLogin", flag);
		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
				+ captureName);
	}
	

	@Test(dependsOnMethods = { "testLogin" },enabled = true, alwaysRun = true)
	public void addcustomer() {
		boolean flag = false;
		beforeTest("addcustomer");
		
		try {
			HomePage = new HomePage(webDriver);
			CustomerManagePage = HomePage.goCustomerManagePage();
//			CustomerManagePage = new CustomerManagePage(webDriver);
			HomePage = CustomerManagePage.AddCustomer(customerName, identifytype, identifyNo, CellPhone);
			flag = HomePage.isTextPresent(customerName);
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("addcustomer", flag);
		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
				+ captureName);
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
