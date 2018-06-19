package com.auction.page.DocDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 文档传递发起
 * @author Administrator
 *
 */
public class DocDeliveryStartDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(CustomerManagePage.class);

	public DocDeliveryStartDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【DocDeliveryStartDetailToDo】");
	}

	//发起文档传递
	public void clickDocDeliveryStartButton() {
		driver.selectFrame(By.name("iframe_4001"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='wait']/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[8]/div/button"));
		driver.click(By.xpath("//*[@id='wait']//a[@class='startDocumentDelivery']"));
	}
	
	//文档传递页面输入相关值
	public void inputDocDelivery() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='collapse_0']//div[@data-title='个人消费抵押合同']"));
		driver.click(By.xpath("//*[@id='collapse_0']//div[@data-title='借款人收入证明']"));
		driver.click(By.xpath("//*[@id='collapse_0']//div[@data-title='结婚证']"));
	}
	//进入文档传递-提交
	public void DocDeliverySub(String loginAccount){
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,7);
	}




	
	public HomePage DocDeliveryStart(String loginAccount) {
		clickDocDeliveryStartButton();
		inputDocDelivery();
		DocDeliverySub(loginAccount);
		return new HomePage(driver);
	}

}
