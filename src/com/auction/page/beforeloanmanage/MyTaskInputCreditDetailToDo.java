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
 * 录入征信并提交
 * @author Administrator
 *
 */
public class MyTaskInputCreditDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskInputCreditDetailToDo.class);
	private WebDriverTable webdrivertable;
	
	public MyTaskInputCreditDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskInputCreditDetailToDo】");
	}

	/**
	 * 银行征信
	 * @param maritalStatus 1有配偶，2无配偶
	 * @param relationship 1有关系人 2无关系人
	 */
	public void bankInvestResult(int maritalStatus,int relationship) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.selectByIndex(By.xpath("//*[@id='creditForm']//select[@name='relavants[0].checkType']"), 1);
		driver.pause(1000);
		driver.selectByIndex(By.xpath("//*[@id='creditForm']//select[@name='relavants[0].checkResult']"), 1);
		driver.sendKeys(By.xpath("//*[@id='creditForm']//input[@name='relavants[0].checkDate']"), df.format(new Date()));
		driver.sendKeys(By.xpath("//*[@id='creditForm']//textarea[@name='relavants[0].creditRemark']"), "借款人银行征信通过");
		driver.pause(1000);
		//有配偶情况
		if(maritalStatus==1){
			driver.selectByIndex(By.xpath("//*[@id='wife']//select[@name='relavants[1].checkType']"), 1, 1);
			driver.pause(1000);
			driver.selectByIndex(By.xpath("//*[@id='wife']//select[@name='relavants[1].checkResult']"), 1);
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].checkDate']"), df.format(new Date()));
			driver.sendKeys(By.xpath("//*[@id='wife']//textarea[@name='relavants[1].creditRemark']"), "配偶银行征信通过");
			driver.pause(1000);
		}else{
			logger.debug("没有配偶");
		}
		//有关系人和配偶情况
		if(relationship==1&&maritalStatus==1){
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].checkType']"), 1);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].checkResult']"), 1);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].checkDate']"), df.format(new Date()));
			driver.sendKeys(By.xpath("//*[@id='partyBox']//textarea[@name='relavants[2].creditRemark']"), "关系人银行征信通过");
		}else{
			logger.debug("没有关系人");
		}
		//只有关系人
		if(relationship==1&&maritalStatus!=1){
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[1].checkType']"), 1);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[1].checkResult']"), 1);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[1].checkDate']"), df.format(new Date()));
			driver.sendKeys(By.xpath("//*[@id='partyBox']//textarea[@name='relavants[1].creditRemark']"), "关系人银行征信通过");
		}else{
			logger.debug("没有关系人");
		}
	}
	
	//网络征信
	public void netInvestResult() {

	}
	//点击提交按钮
	public void clickSaveButton() {
		driver.click(By.xpath("//*[@id='save']/span"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(1000);
		//关闭全部TAB

		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}
	
	/**
	 * 进入我的任务-待办-征信录入-提交
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(int maritalStatus,int relationship) {
		bankInvestResult(maritalStatus,relationship);
		netInvestResult();
		clickSaveButton();
		return new HomePage(driver);
	}
}
