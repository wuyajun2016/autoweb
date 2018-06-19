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
 * 分公司总经理-提交
 * @author Administrator
 *
 */
public class MyTaskBranchCompanyManagerDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskBranchCompanyManagerDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskBranchCompanyManagerDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【MyTaskBranchCompanyManagerDetailToDo】");
	}

	//进入分公司总经理-审批信息
	public void BranchCompanyManagerApprovalInfo(){

		
	} 
	
	//进入分公司总经理-流程意见
	public void BranchCompanyManagerOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("opinion"), "分公司总经理通过");
	}
	
	//进入影像管理-点击图片
	public void ImageManageUpload(){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.CheckImage();
	}
	
	//进入分公司总经理-提交
	public void BranchCompanyManagerSubmit(String loginAccount){
//		driver.pause(1000);
//		driver.click(By.id("btn-opinion-save"));
//		driver.pause(2000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.id("select-sign-btn"));
//		//关闭弹出流转到XXX的提示框
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
//		//关闭全部TAB
//		driver.pause(2000);
//		driver.click(By.xpath("//*[@id='page-wrapper']//button[@class='dropdown J_tabClose']"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
	}

	/**
	 * 进入我的任务-待办-分公司总经理提交
	 * @return
	 */
	public HomePage MyTaskPageBranchCompanyManager(String loginAccount) {
		BranchCompanyManagerOpinion();
		ImageManageUpload();
		BranchCompanyManagerSubmit(loginAccount);
		return new HomePage(driver);
	}


}
