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
 * 二手车初评-提交
 * @author Administrator
 *
 */
public class MyTaskSecondCarPreEvaluationDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarPreEvaluationDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarPreEvaluationDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskSecondCarPreEvaluationDetailToDo】");
	}

	//进入二手车初评-初评报告-车辆基本信息
	public void SecondCarPreEvaluationBasicInfo(){
		driver.pause(3000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.selectByIndex(By.id("firstEstimateSourceKey"), 1);
		driver.sendKeys(By.name("firstEstimatePrice"), "600000");
		driver.sendKeys(By.name("firstEstimateDesc"), "初评报告OK");
	}
	
	//进入二手车初评-初评报告-流程意见
	public void SecondCarPreEvaluationOpinion(){
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='registeredForm']/div[6]/div[2]/div[1]/div/div/label[1]/input"));
		driver.sendKeys(By.id("opinion"), "初评报告流程意见OK");
	}
	
	//进入发起二手车评估-影像管理
	public void SecondCarImageManage(int i,int type){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,type);
	}
	
	
	//提交
	public void SecondCarSubmit(String loginAccount,int type){
		driver.click(By.id("tohref"));
		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,type);
	}
	/**
	 * 进入二手车初评页面
	 * @return
	 */
	public HomePage SecondCarPreEvaluationSubmit(String loginAccount) {
		SecondCarPreEvaluationBasicInfo();
		SecondCarPreEvaluationOpinion();
		for(int k=6;k<=10;k++){
			SecondCarImageManage(k,2);
		}

		SecondCarSubmit(loginAccount,3);
		return new HomePage(driver);
	}


}
