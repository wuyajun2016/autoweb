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
 * 二手车过户评估报告-提交
 * @author Administrator
 *
 */
public class MyTaskSecondCarTransferReportDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarTransferReportDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarTransferReportDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskSecondCarTransferReportDetailToDo】");
	}

	
	//进入二手车过户评估报告-流程意见
	public void SecondCarTransferVerifyOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.click(By.xpath("//*[@id='registeredForm']//input[@value='1']"));
		driver.sendKeys(By.id("opinion"), "过户评估报告流程意见OK");
	}
	
	//进入发二手车过户评估报告-影像管理
	public void SecondCarTransferVerifyImageManage(int i,int type){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,type);
	}
	
	
	//二手车过户评估报告提交
	public void SecondCarTransferVerifySubmit(String loginAccount,int type){
		driver.click(By.id("tohref"));
		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,type);
	}
	/**
	 * 进入二手车过户审批页面
	 * @return
	 */
	public HomePage SecondCarTransferVerifySubmit(String loginAccount) {
		SecondCarTransferVerifyOpinion();
		SecondCarTransferVerifyImageManage(10,2);
		SecondCarTransferVerifySubmit(loginAccount,6);
		return new HomePage(driver);
	}


}
