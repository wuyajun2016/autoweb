package com.auction.page.mytask;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 新车、二手车贷款发起-提交
 * @author Administrator
 *
 */
public class MyTaskLoanStartDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskLoanStartDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskLoanStartDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskLoanStartDetailToDo】");
	}

	//进入贷前管理-贷款评审，点击第一条记录
	public void ClickLoanReviewStart() {
		driver.selectFrame(By.name("iframe_3002"));
		driver.click(By.xpath("//*[@id='table']/tbody/tr[1]/td[10]/button"),10);
		driver.pause(1000);
	}
	//进入发起贷款-业务信息
	public void LoanStartBusinessInfo(int i){
		driver.pageLoadSucceed();
		driver.selectFrame(By.name("iframe_undefined"),10);
		if(i==1){
			driver.selectByIndex(By.id("product"), 1);
		}else{
			driver.selectByIndex(By.id("product"), 2);
		}

		
		driver.selectByIndex(By.xpath("//*[@id='creditFormList']//select[@id='productId']"), 1);
	}
	
	
	
	/**
	 * 进入发起贷款-项目基本信息-选择车型
	 * @param cartype 1新车，2二手车
	 */
	public void LoanStartProjectBasicInfo(int cartype,String carDealer){
		driver.pause(2000);
		//选择车型
		if(cartype==2){
			driver.pause(1000);
			driver.selectByIndex(By.id("carType"), 1);
			driver.click(By.id("customerBtn"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_5']/tbody/tr[1]/td[7]/button"));
		}else{
				driver.pause(3000);
				driver.selectByIndex(By.id("getBrand"), 1);
				driver.pause(5000);
				driver.selectByIndex(By.id("getCarList"), 3);
				driver.pause(5000);
				driver.selectByIndex(By.id("getCarModel"), 1);

			
			//判断车系是否选好了
//			driver.pause(2000);
//			String carlist = driver.getAttribute(By.name("carMakeName"), "value");
//			System.out.println("------------------carlist:"+carlist+"---------------");
//			if(carlist.equals("--请选择--")||carlist.equals("")){
//				driver.selectByIndex(By.id("getCarList"), 3,10);
//				driver.pause(1000);
//				driver.selectByIndex(By.id("getCarModel"), 1,10);
//			}
		}
		driver.pause(1000);
		driver.setRadioGroup(By.xpath("//*[@id='creditFormList']/div[3]/div[2]/div[2]/div[1]/div/label[1]/input"), "on");
		//选择车行
		
//		driver.selectByIndex(By.id("carDealer"), 39);
		driver.selectByValue(By.id("carDealer"), carDealer);
		//开票价
		driver.sendKeys(By.name("billingPrice"), "500000");
		//贷款金额
		driver.sendKeys(By.name("loanAmount"), "200000");
		//车商费用
		driver.selectByIndex(By.id("dealerFeeId"), 1,2);
		//选择上门地址
		driver.pause(3000);
		driver.selectByIndex(By.name("visitAddressPid"), 11,10);
		driver.pause(3000);
		driver.selectByIndex(By.name("visitAddressCid"), 1,10);
		driver.pause(3000);
		driver.selectByIndex(By.name("visitAddressRid"), 5,10);
		//判断上门地址是否选好了
//		driver.pause(2000);
//		String address = driver.getAttribute(By.name("visitAddressCname"), "value");
//		System.out.println("------------------address:"+address+"---------------");
//		if(address.equals("--请选择--")||address.equals("")){
//			driver.selectByIndex(By.name("visitAddressCid"), 1,10);
//			driver.pause(1000);
//			driver.selectByIndex(By.name("visitAddressRid"), 5,10);
//		}
		driver.sendKeys(By.name("visitAddressDetail"), "西溪华府");
		driver.pause(1000);
		driver.click(By.id("getPos"));
		driver.pause(1000);
	    //在地图上右击选择位置
		driver.rightClick(By.className("BMap_mask"));
		driver.pause(2000);
		driver.click(By.xpath("//*[@id='map']/div[4]/div/span"));
		driver.pause(3000);
	} 

	//提交
	public void LoanStartSubmit(String loginAccount){
//		driver.click(By.id("submit"));
//		driver.pause(2000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr[4]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='task']/div/div/div[3]/div/button[1]"));
//		//点击关闭弹出提示框‘成功流转给XXX’
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
//		//关闭全部TAB
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,1);
	}
	/**
	 * 进入我的任务-待办-二手车贷款发起页面
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(int i,String loginAccount,int cartype,String carDealer) {
		ClickLoanReviewStart();
		LoanStartBusinessInfo(i);
		LoanStartProjectBasicInfo(cartype,carDealer);
		LoanStartSubmit(loginAccount);
		return new HomePage(driver);
	}


}
