package com.auction.page.businessfiles;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class BusinessFilesPage extends BasePage{

	private Logger logger = Logger.getLogger(BusinessFilesPage.class);
	
	public BusinessFilesPage(WebdriverBaseApi driver){
		super(driver);
		logger.debug("running test in 【BusinessFilesPage】");
	}

	/**
	 * 点击业务档案
	 * @return
	 */
	public HomePage clickBusinessFiles() {
		driver.click(By.xpath("/html/body/div/div/div[3]/ul/li[2]"));
		driver.pause(2000);
		return new HomePage(driver);
	}

}
