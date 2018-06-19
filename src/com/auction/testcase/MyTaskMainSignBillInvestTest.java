package com.auction.testcase;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.StartCredit;
import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.MyTaskPage;
import com.auction.page.mytask.MyTaskMainSignBillInvestDetailToDo;
import com.auction.page.mytask.MyTaskOfficeDetailToDo;
import com.auction.page.mytask.MyTaskSignBillDistributionDetailToDo;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;

/**
 * 用例:主签单调查-提交
 * @author Administrator
 *
 */
@Test(groups = { "LoanStart" })
public class MyTaskMainSignBillInvestTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private MyTaskPage mytaskpage;
	private HomePage HomePage;
	private MyTaskOfficeDetailToDo mytaskofficedetailtodo;
	protected WebdriverBaseApi webDriver;
	StartCredit stCredit;
	private String CustomerManagerName;  //客户经理名字
	private Logger logger = Logger.getLogger(MyTaskMainSignBillInvestTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}

	}
	

	@Test(enabled = true, alwaysRun = true)
	public void myTaskMainSignBillInvest() {
		boolean flag = false;
		beforeTest("myTaskMainSignBillInvest");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			HomePage.goMyTaskPage(0).MyTaskPageStartCredit().goMyTaskMainSignBillInvestDetailToDo().MyTaskSignBillDistribution(CustomerManagerName);
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
