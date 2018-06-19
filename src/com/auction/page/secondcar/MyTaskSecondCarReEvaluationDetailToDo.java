package com.auction.page.secondcar;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.ImageManagePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 二手车复评-提交
 * @author Administrator
 *
 */
public class MyTaskSecondCarReEvaluationDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarReEvaluationDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarReEvaluationDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskSecondCarReEvaluationDetailToDo】");
	}

	//进入二手车复评-复评报告-车辆基本信息校验
	public void SecondCarReEvaluationBasicInfo(){

	}
	
	//进入二手车复评-初评报告校验
	public void SecondCarPreEvaluationOpinion(){
	}
	
	//进入二手车复评-复评结果
	public void SecondCarReEvaluationOpinion(){
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.selectByIndex(By.id("loanLaunchDate"), 1);
		driver.sendKeys(By.name("secondEstimatePrice"), "490000");
		driver.sendKeys(By.name("invoicePrice"), "480000");
		driver.sendKeys(By.name("secondEstimateDesc"), "复评结果OK");
	}
	
	
	//进入发起二手车评估-影像管理
	public void SecondCarImageManage(int i,int type){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,type);
	}
	
	
	//提交
	public void SecondCarReSubmit(String loginAccount,int type){
		driver.click(By.id("tohref"));
		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,type);
	}
	/**
	 * 进入二手车复评页面
	 * @return
	 */
	public HomePage SecondCarReEvaluationSubmit(String loginAccount) {
		SecondCarReEvaluationBasicInfo();
		SecondCarPreEvaluationOpinion();
		SecondCarReEvaluationOpinion();
		for(int k=6;k<=10;k++){
			SecondCarImageManage(k,2);
		}

		SecondCarReSubmit(loginAccount,4);
		return new HomePage(driver);
	}


}
