package com.auction.page.beforeloanmanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.helper.WebDriverTable;

/**
 * 发起征信并提交
 * @author Administrator
 *
 */
public class MyTaskStartCreditDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskStartCreditDetailToDo.class);
	private WebDriverTable webdrivertable;
	
	public MyTaskStartCreditDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskStartCreditDetailToDo】");
	}

	//弹出框选择一个流转人员点击确定按钮提交到下一步
	public void submitToNextNode(String loginAccount_zx) {
//		driver.pause(3000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='task']/div/div/div[3]/div/button[1]/span"));
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
//		driver.pause(3000);
//		//关闭全部TAB
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodeZX(1,loginAccount_zx);
	}
	
	//点击提交按钮
	public void clickSaveButton() {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.click(By.xpath("//*[@id='save']/span"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(3000);
	}
	//我的任务-发起征信文案校验
	public void checkContent(String nextNode) {
		boolean isSucceed = false;
		String nextnode = driver.getText(By.id("nextFlowNodeName"));
		if(nextnode.equals(nextNode)){
			isSucceed = true;
		}else{
			logger.debug("我的任务-征信发起-文案校验失败");
			Assert.assertTrue(isSucceed);
		}
	}
	
	/**
	 * 进入我的任务-待办-征信开始-提交
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(String nextNode,String loginAccount_zx) {
		clickSaveButton();
//		checkContent(nextNode);
		submitToNextNode(loginAccount_zx);
		return new HomePage(driver);
	}
}
