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
 * 二手车过户审批-提交
 * @author Administrator
 *
 */
public class MyTaskSecondCarEvaluateStartDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarEvaluateStartDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarEvaluateStartDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskSecondCarEvaluateStartDetailToDo】");
	}

	//进入二手车评估主页面
	public void ClickSecondCarStart() {
		driver.selectFrame(By.name("iframe_8001"));
		driver.pause(1000);
		driver.click(By.id("assessment"));

	}
	//进入发起二手车评估-车辆基本信息页面
	public void SecondCarBasicInfo(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		int brand_random=(int)Math.rint(Math.random()*140);
		driver.selectByIndex(By.id("getBrand"), brand_random,3);
		driver.pause(3000);
		driver.selectByIndex(By.id("getCarList"), 1,3);
		driver.pause(3000);
		driver.selectByIndex(By.id("getCarModel"), 1,3);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		driver.sendKeys(By.name("licenseDate"), df.format(new Date()));
		driver.sendKeys(By.id("kilometres"), "10000");
		driver.sendKeys(By.name("carColour"), "黑色");
		driver.sendKeys(By.name("carIdentifyNum"), "auto12345");
		driver.sendKeys(By.name("commercialInsuranceExpiredDate"), df.format(new Date()));
		driver.sendKeys(By.name("trafficCompulsoryInsuranceExpiredDate"), df.format(new Date()));
		driver.sendKeys(By.name("newCarPrice"), "800000");
		driver.sendKeys(By.name("secondHandCarPrice"), "700000");
		driver.sendKeys(By.name("memo"), "二手车评估发起了");
		driver.click(By.xpath("//*[@id='registeredForm']//button[@fors='1']"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
		
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
	 * 进入二手车发起页面
	 * @return
	 */
	public HomePage SecondCarStart(String loginAccount) {
		ClickSecondCarStart();
		SecondCarBasicInfo();
		SecondCarImageManage(4,2);
		SecondCarSubmit(loginAccount,2);
		return new HomePage(driver);
	}


}
