package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 签单分配提交
 * @author Administrator
 *
 */
public class MyTaskSignBillDistributionDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSignBillDistributionDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSignBillDistributionDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskSignBillDistributionDetailToDo】");
	}

	//进入签单分配-签单分配
	public void SignBillDistribution(String CustomerManagerName,String MainSign){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		//点击主签单后面的选择按钮
		driver.click(By.id("mainSignSelect"));
		driver.pause(2000);
		//主签单弹出框中选择一个人员
//		driver.click(By.xpath("//*[@id='table_sign_main']/tbody/tr[1]/td[1]/a"));
//		driver.pause(1000);
		
		for(int i=1;i<=10;i++){
			String name=driver.getText(By.xpath("//*[@id='table_sign_main']/tbody/tr["+i+"]/td[4]"));
			if(name.equals(MainSign)){
				driver.click(By.xpath("//*[@id='table_sign_main']/tbody/tr["+i+"]/td[1]/a"));
				break;
			}
		}
		//点击副签单后面的选择按钮
		driver.pause(2000);
		driver.click(By.id("viceSignSelect"));
		driver.pause(2000);
		//副签单弹出框中选择一个人员,查询出zqd1
		driver.sendKeys(By.name("signName"), CustomerManagerName);
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='btn-search-qd']/span[2]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='table_sign_vice']/tbody/tr/td[1]/a"));
	}
	
	//进入签单分配-选择权重
	public void SignBillDistributionWeight(){
		driver.pause(1000);
		driver.sendKeys(By.id("mainSignerWeight"), "80");
	}
	
	//进入签单分配-流程意见
	public void SignBillProcessOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "签单分配同意");
	} 

	//提交
	public void SignBillDistributionSubmit(String loginAccount){
//		driver.click(By.id("btn-opinion-save"));
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
//		driver.pause(1000);
//		//关闭全部TAB
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(0,loginAccount,1);
	}
	
	/**
	 * 进入我的任务-待办-签单分配-提交
	 * @return
	 */
	public HomePage MyTaskSignBillDistribution(String loginAccount,String CustomerManagerName,String MainSign) {
		SignBillDistribution(CustomerManagerName,MainSign);
		SignBillDistributionWeight();
		SignBillProcessOpinion();
		SignBillDistributionSubmit(loginAccount);
		return new HomePage(driver);
	}


}
