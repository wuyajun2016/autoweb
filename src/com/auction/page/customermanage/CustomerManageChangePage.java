package com.auction.page.customermanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 修改客户基本信息
 * @author Administrator
 *
 */
public class CustomerManageChangePage extends BasePage {
	private Logger logger = Logger.getLogger(CustomerManageChangePage.class);

	public CustomerManageChangePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【CustomerManageChangePage】");
//		vercode = getVercode("GBK");
	}

	
	//进入客户信息修改页面
	public void enterCustomerManageChange() {
		driver.selectFrame(By.name("iframe_2002"), 10);
		driver.click(By.xpath("//*[@id='table']/tbody/tr[1]/td[9]/div/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='table']/tbody/tr[1]/td[9]/div/ul/li[2]"));
		driver.pause(1000);
	}
	/**
	 * 修改客户信息
	 * @param marriage 婚姻状况，2已婚 1未婚
	 */
	public void CustomerManageChange(int marriage){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		if(marriage==1){
			driver.selectByIndex(By.name("maritalStatus"), 2);
		}else{
			driver.selectByIndex(By.name("maritalStatus"), 1);
		}

		driver.sendKeys(By.name("homePhone"), "021-6222122");
		driver.sendKeys(By.name("nativePlace"), "温州");
		driver.selectByIndex(By.name("education"), 4);
		driver.selectByIndex(By.name("housingStatus"), 1);
		driver.sendKeys(By.name("profession"), "软件测试工程师");
		driver.selectByIndex(By.name("industry"), 7);
		driver.selectByIndex(By.name("monthlyIncome"), 2);
		driver.sendKeys(By.name("company"), "车果网络科技有限公司");
		driver.sendKeys(By.name("workPhone"), "0577-6222122");
		driver.selectByIndex(By.name("reservedFunds"), 2);
		//输入单位地址
		driver.pause(1000);
		driver.selectByIndex(By.name("companyAddressProvinceCode"), 11,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("companyAddressCityCode"), 1,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("companyAddressCountyCode"), 5,3);
		driver.pause(3000);
		driver.sendKeys(By.name("companyAddress"), "紫霞街五常港路11号502室");
		//输入家庭地址
		driver.pause(1000);
		driver.selectByIndex(By.name("homeAddressProvinceCode"), 11,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("homeAddressCityCode"), 3,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("homeAddressCountyCode"), 11,3);
		driver.pause(3000);
		driver.sendKeys(By.name("homeAddressVillage"), "隔河北路11弄1号");
		driver.pause(1000);
		if(marriage==1){
			driver.sendKeys(By.name("spouseMobilePhone"), "13888888888");
			driver.sendKeys(By.name("spouseNativePlace"), "杭州");
			driver.selectByIndex(By.name("spouseReservedFunds"), 2);
			driver.sendKeys(By.name("spouseCompany"), "江南中学");
			driver.sendKeys(By.name("spouseCompanyPhone"), "0571-85465324");
			driver.selectByIndex(By.name("spouseCompanyAddrProvinceCode"), 11,3);
			driver.pause(3000);
			driver.selectByIndex(By.name("spouseCompanyAddrCityCode"), 1,3);
			driver.pause(3000);
			driver.selectByIndex(By.name("spouseCompanyAddrCountyCode"), 5,3);
			driver.pause(1000);
			driver.sendKeys(By.name("spouseCompanyAddr"), "华府一号11栋10-2");
			driver.selectByIndex(By.name("spouseMonthlyIncome"), 2);
		}else{
			logger.debug("-------------------无配偶----------------");
		}
		driver.click(By.id("save"));
		driver.pause(1000);
	} 
	


	public HomePage CustomerManageChangeT(int marriage) {
		enterCustomerManageChange();
		CustomerManageChange(marriage);
		return new HomePage(driver);
	}

}
