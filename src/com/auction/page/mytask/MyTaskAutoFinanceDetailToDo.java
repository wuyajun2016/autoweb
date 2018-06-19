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
 * 汽车金融部-提交
 * @author Administrator
 *
 */
public class MyTaskAutoFinanceDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskAutoFinanceDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskAutoFinanceDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskAutoFinanceDetailToDo】");
	}

	//进入汽车金融部-审批信息
	public void AutoFinanceApprovalInfo(){

		
	} 
	
	//进入汽车金融部-流程意见
	public void AutoFinanceOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isConcernedCustomer']"), "on"); //是否关注客户
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isAgency']"), "on"); //是否代购
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isGpsInstalled1']"), "on"); //按公司规定安装GPS
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isGpsInstalled2']"), "on"); //按银行规定安装GPS
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "汽车金融部通过");
	}
	
	//进入影像管理-点击图片
	public void ImageManageUpload(){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.CheckImage();
	}
	
	//进入汽车金融部-提交
	public void AutoFinanceSubmit(String loginAccount){
//		driver.pause(1000);
//		driver.click(By.id("btn-opinion-save"));
//		//关闭弹出流转到XXX的提示框
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
//		//关闭全部TAB
//		driver.pause(2000);
//		driver.click(By.xpath("//*[@id='page-wrapper']//button[@class='dropdown J_tabClose']"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
//		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
		
	}

	/**
	 * 进入我的任务-待办-汽车金融部提交
	 * @return
	 */
	public HomePage MyTaskPageAutoFinance(String loginAccount) {
		AutoFinanceOpinion();
		ImageManageUpload();
		AutoFinanceSubmit(loginAccount);
		return new HomePage(driver);
	}


}
