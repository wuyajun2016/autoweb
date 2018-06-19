package com.auction.page.beforeloanmanage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.helper.WebDriverTable;

/**
 * 接受征信并提交
 * @author Administrator
 *
 */
public class MyTaskAcceptCreditDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskAcceptCreditDetailToDo.class);
	private WebDriverTable webdrivertable;
	
	public MyTaskAcceptCreditDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskInputCreditDetailToDo】");
	}

	//银行征信文案校验
	public void bankInvestResultCheck() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	}
	
	//网络征信文案校验
	public void netInvestResultCheck() {

	}
	//点击提交按钮
	public void clickSaveButton() {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='save']/span"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(3000);
		//关闭全部TAB
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}
	
	/**
	 * 进入我的任务-待办-征信接受-提交
	 * @return
	 */
	public HomePage MyTaskPageStartCredit() {
		bankInvestResultCheck();
		netInvestResultCheck();
		clickSaveButton();
		return new HomePage(driver);
	}
}
