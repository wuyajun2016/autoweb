package com.auction.page.insurancemanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 保险管理
 * @author Administrator
 *
 */
public class InsuranceRegisterDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(CustomerManagePage.class);
	String customerName;

	public InsuranceRegisterDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【InsuranceRegisterDetailToDo】");
	}

	//进入首保录入页面
	public void clickInsuranceRegisterStartButton() {
		driver.selectFrame(By.name("iframe_9001"));
		driver.pause(1000);
		customerName = driver.getText(By.xpath("//*[@id='table1']/tbody/tr[1]/td[2]"));
		driver.click(By.xpath("//*[@id='table1']/tbody/tr[1]/td[10]/div/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='table1']/tbody/tr[1]/td[10]/div/ul/li[1]/a"));
	}
	
	//进入首保录入页面-保单录入
	public void inputInsuranceRegister(int insuranceType,String insuranceNo) {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.click(By.id("editInsurance"));
		driver.pause(1000);
		driver.selectFrame(By.xpath("//*[@id='content-main']/iframe[4]"));
		driver.selectByIndex(By.id("insuranceCompanyId"), 1,10);
		driver.selectByIndex(By.id("insuranceTypeKey"), insuranceType);
		driver.sendKeys(By.id("insuranceNo"), insuranceNo);
		driver.click(By.id("addAll"));
		driver.sendKeys(By.id("insuranceFeeTotal"), "1000");
		driver.sendKeys(By.id("remark"), driver.getAttribute(By.id("insuranceTypeName"), "value"));
		driver.pause(1000);
		driver.click(By.id("btn-save"));
	}
	//进入校验
	public void InsuranceRegisterSubT(String customername){
		driver.selectFrame(By.name("iframe_9001"));
		driver.pause(1000);
		driver.click(By.xpath("/html/body/div/div/div/div/div/ul/li[2]/a"));
		driver.sendKeys(By.name("customerName"), customername);
		driver.click(By.id("btn-search"));
		//关闭全部TAB
		InsuranceRegisterSub();
	}
	
	//进入首保录入页面-保存
	public void InsuranceRegisterSub(){
		driver.selectDefaultFrame();
		driver.pause(2000);
		//关闭全部TAB
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}




	
	public String InsuranceRegister(String loginAccount) {
		clickInsuranceRegisterStartButton();
		inputInsuranceRegister(1,"1234567890");
		inputInsuranceRegister(2,"3451254354360");
		InsuranceRegisterSub();
		return customerName;
	}
	public HomePage InsuranceRegisterT(String customername) {
		InsuranceRegisterSubT(customername);
		return new HomePage(driver);
	}

}
