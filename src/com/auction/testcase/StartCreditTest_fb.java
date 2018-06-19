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
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.coma.baserunner.RetryFail;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.util.RandomIdentify;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;
import com.framework.util.*;

/**
 * 用例:征信发起
 * @author Administrator
 *
 */
@Test(groups = { "StartCredit" })
public class StartCreditTest_fb extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private StartCreditPage StartCreditPage;
	private Configure Configure;
	private HomePage HomePage;
	protected WebdriverBaseApi webDriver;
	private RandomIdentify RandomIdentify;
	StartCredit stCredit;
	private String customerName;  //客户名字
	private String identifyNo;    //证件号码
	private String identifyNoMarry;    //证件号码,配偶
	private String CellPhone;     //借款人手机号码
	private String CustomerManagerName;  //客户经理名字
	private int identifytype=1;   //证件类型自定义为身份证
	private String investbank="杭州工行古墩路支行";     //调查银行默认选中第一个,目前是杭州工行古墩路支行，取下拉列表第一个值即可
	private int maritalstatus;  //婚姻状况自定义为未婚
	private int relationship;
	private int guarantor;
	private Logger logger = Logger.getLogger(StartCreditTest_fb.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);

			Configure = (Configure) FrameworkDao.getRandomObjectByParam(
					"Configure.getUserByParam1", "testSet");
			maritalstatus = Configure.getMaritalStatus();
			relationship = Configure.getRelationship();
			guarantor = Configure.getGuarantor();
			
			RandomIdentify=new RandomIdentify();
			customerName = RandomUtil.getChineseName();
			identifyNo = RandomIdentify.getIDCard();
			identifyNoMarry = RandomIdentify.getIDCard();
			CellPhone = RandomUtil.getTel();
			//将随机生成的以及自定义的都存入access数据库
			stCredit = new StartCredit();
			stCredit.setCellPhone(CellPhone);
			stCredit.setCustomerName(customerName);
			stCredit.setIdentifyNo(identifyNo);
			stCredit.setIdentifyType(identifytype);
			stCredit.setInvestigationBank(investbank);
			stCredit.setMaritalStatus(maritalstatus);
			FrameworkDao.addcredit(stCredit);
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}

	}
	
	@Test(enabled = true,retryAnalyzer= RetryFail.class)
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
	

	@Test(dependsOnMethods={"testLogin"},enabled = true, alwaysRun = true,retryAnalyzer= RetryFail.class)
	public void startcredit() {
		boolean flag = false;
		beforeTest("startcredit");
		try {
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam("UserInfo.getUserByParam", "testLogin");
	        CustomerManagerName = UserInfo.getLoginname();
			HomePage = new HomePage(webDriver);
			StartCreditPage = HomePage.goStartCreditPage();
			HomePage = StartCreditPage.StartCredit(customerName, identifytype, identifyNo,CellPhone,maritalstatus,investbank,CustomerManagerName,identifyNoMarry,relationship,guarantor);
			flag = HomePage.isTextPresent("保存成功");
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("startcredit", flag);
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
