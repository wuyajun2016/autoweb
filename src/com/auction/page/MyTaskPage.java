package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class MyTaskPage extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskPage.class);
	
	public MyTaskPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【StartCreditPage】");
	}

	//点击待办事项
	public void clickMyTaskToDo() {
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_1001"));
		driver.click(By.xpath("/html/body/div[1]/div/div/div/div/ul/li[1]/a"));
		driver.pause(1000);
	}
	//点击列表中第一条记录操作
	public void startDo() {
		driver.pause(3000);
		driver.click(By.xpath("//*[@id='table1']/tbody/tr[1]/td[12]/a"));
		driver.pause(3000);
	}
	
	/**
	 * 进入我的任务-待办,选择第一条记录
	 * @return
	 */
	public HomePage MyTaskPageStartCredit() {
		clickMyTaskToDo();
		startDo();
		return new HomePage(driver);
	}


}
