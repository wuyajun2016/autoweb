package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.ImageManagePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 副签单调查
 * @author Administrator
 *
 */
public class MyTaskSecondSignBillInvestDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondSignBillInvestDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondSignBillInvestDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskSecondSignBillInvestDetailToDo】");
	}

	//进入副签单调查-流程意见
	public void MainSignBillInvestProcessOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("opinion"), "签单调查同意");
	} 

	//进入签单调查-进入影像管理TAB
	public void MainSignBillInvestImageManageEnter(){
//		driver.click(By.xpath("/html/body/div[1]/ul/li[2]/a"));
	}
	
	//进入签单调查-影像管理
	public void MainSignBillInvestImageManage(int i){
//		driver.pause(1000);
//		driver.click(By.id("tree_"+i+"_span"));
//
//		driver.click(By.xpath("//*[@id='detail']/div/div[1]/div[2]/div/div[2]/ul/li[2]/a"));
//
//		driver.click(By.xpath("//*[@id='upImage']/span"));
//
//		win32guibyau3.fileUpload("打开","C:\\Users\\Public\\Pictures\\Sample Pictures\\"+i+".jpg",1);
//
//		driver.click(By.xpath("//*[@id='upload']/span"));
//		driver.pause(1000);
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,1);
	}

	//提交
	public void MainSignBillInvestSubmit(String loginAccount){
//		driver.click(By.id("btn-opinion-save"));
//		driver.pause(1000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.id("select-sign-btn"));
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
		nextnode.NextNodePopup(1,loginAccount,1);
	}
	
	/**
	 * 进入我的任务-待办-主签单调查-提交
	 * @return
	 */
	public HomePage MyTaskSignBillDistribution(String loginAccount) {
		MainSignBillInvestProcessOpinion();
		MainSignBillInvestImageManageEnter();
		//循环输入影像照片
//		for(int i=5;i<=14;i++){
//			MainSignBillInvestImageManage(i);
//		}
		MainSignBillInvestSubmit(loginAccount);
		return new HomePage(driver);
	}


}
