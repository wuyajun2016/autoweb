package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 资金部出纳（资金划拨）-提交
 * @author Administrator
 *
 */
public class MyTaskFinanceDepartmentAccountDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskFinanceDepartmentAccountDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskFinanceDepartmentAccountDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskFinanceDepartmentAccountDetailToDo】");
	}

	//进入资金部出纳（资金划拨）-审批信息-收款人信息
	public void FinanceDepartmentAccountPayee(){
		
	} 
	
	//进入资金部出纳（资金划拨）-流程意见
	public void FinanceDepartmentAccountOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("opinion"), "资金部出纳审核通过了");
	}
	
	//进入资金部出纳（资金划拨）-提交
	public void FinanceDepartmentAccountSubmit(String loginAccount){
//		driver.pause(1000);
//		driver.click(By.id("btn-opinion-save"));
//		driver.pause(2000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.id("select-sign-btn"));
//		//关闭弹出流转到XXX的提示框
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
//		//关闭全部TAB
//		driver.pause(2000);
//		driver.click(By.xpath("//*[@id='page-wrapper']//button[@class='dropdown J_tabClose']"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
//		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
	}

	/**
	 * 进入我的任务-待办-资金部出纳（资金划拨）提交
	 * @return
	 */
	public HomePage MyTaskPageFinanceDepartmentAccount(String loginAccount) {
		FinanceDepartmentAccountOpinion();
		FinanceDepartmentAccountSubmit(loginAccount);
		return new HomePage(driver);
	}


}
