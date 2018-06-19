package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 分公司出纳（分公司付款）-提交
 * @author Administrator
 *
 */
public class MyTaskBranchCompanyAccountDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskBranchCompanyAccountDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskBranchCompanyAccountDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskBranchCompanyAccountDetailToDo】");
	}

	//进入分公司出纳-审批信息-付款信息
	public void BranchCompanyAccountPayInfo(int BusinessType){
		if(BusinessType==1){
			driver.pause(1000);
			driver.selectFrame(By.name("iframe_undefined"));
			driver.click(By.id("accountSelect"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_pay']/tbody/tr/td[1]/a"));
			driver.pause(1000);
			driver.sendKeys(By.name("dealerPaymentRemark"), "付款信息是对的,本出纳同意");
		}else{
			driver.pause(1000);
			driver.selectFrame(By.name("iframe_undefined"));
			driver.sendKeys(By.name("collectedRemark"), "付款信息是对的,本出纳同意");
		}

	} 
	
	//进入分公司出纳-流程意见
	public void BranchCompanyAccountOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "分公司出纳审核通过了");
	}
	
	//进入分公司出纳-提交
	public void FBranchCompanyAccountSubmit(String loginAccount){
//		driver.pause(1000);
//		driver.click(By.id("btn-opinion-save"));
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
		nextnode.NextNodePopup(0,loginAccount,1);
	}

	/**
	 * 进入我的任务-待办-分公司出纳提交
	 * @return
	 */
	public HomePage MyTaskPageBranchCompanyAccount(int BusinessType,String loginAccount) {
		BranchCompanyAccountPayInfo(BusinessType);
		BranchCompanyAccountOpinion();
		FBranchCompanyAccountSubmit(loginAccount);
		return new HomePage(driver);
	}


}
