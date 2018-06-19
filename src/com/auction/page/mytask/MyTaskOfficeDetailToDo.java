package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.seleniumhq.jetty7.util.log.Log;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.ImageManagePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 内勤录入(业务录入)
 * @author Administrator
 *
 */
public class MyTaskOfficeDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskOfficeDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskOfficeDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【内勤录入_MyTaskOfficeDetailToDo】");
	}

	//进入业务录入-基本信息-借款人信息
	public void OfficeBasicInfoBorrower(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("homePhone"), "021-6222122");
		driver.sendKeys(By.name("nativePlace"), "温州");
		driver.selectByIndex(By.name("education"), 4);
		driver.selectByIndex(By.name("housingStatus"), 1);
		driver.sendKeys(By.name("profession"), "软件测试工程师");
		driver.selectByIndex(By.name("industry"), 7);
		driver.selectByIndex(By.name("monthlyIncome"), 2);
		driver.sendKeys(By.name("companyName"), "车果网络科技有限公司");
		driver.sendKeys(By.name("companyPhone"), "0577-6222122");
		driver.selectByIndex(By.name("reservedFunds"), 2);
		//输入单位地址
		driver.pause(1000);
		driver.selectByIndex(By.name("companyAddressPid"), 11,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("companyAddressCid"), 1,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("companyAddressRid"), 5,3);
		driver.sendKeys(By.name("companyAddressDetail"), "紫霞街五常港路11号502室");
		//输入家庭地址
		driver.pause(1000);
		driver.selectByIndex(By.name("homeAddressPid"), 11,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("homeAddressCid"), 3,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("homeAddressRid"), 11,3);
		driver.sendKeys(By.name("homeAddressDetail"), "隔河北路11弄1号");
		driver.pause(1000);

//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
	} 
	
	//进入业务录入-基本信息-借款人信息-配偶
	public void OfficeBasicInfoBorrowerWife(int maritalstatus){
		if(maritalstatus==1){
			driver.sendKeys(By.name("spouseMobilePhone"), "13222211122");
			driver.sendKeys(By.name("spousePermantAddress"), "杭州");
			driver.selectByIndex(By.name("spouseReservedFunds"), 2);
			driver.sendKeys(By.name("spouseCompanyName"), "江南中学");
			driver.sendKeys(By.name("spouseCompanyPhone"), "0571-85465324");
			driver.selectByIndex(By.name("spouseCompanyAddressPid"), 11,3);
			driver.pause(2000);
			driver.selectByIndex(By.name("spouseCompanyAddressCid"), 1,3);
			driver.pause(2000);
			driver.selectByIndex(By.name("spouseCompanyAddressRid"), 5,3);
			driver.pause(1000);
			driver.sendKeys(By.name("spouseCompanyAddress"), "华府一号11栋10-2");
			driver.selectByIndex(By.name("spouseMonthlyIncome"), 2);
		}else{
			logger.debug("没有配偶，不执行");
		}
		//点击保存基本信息
		driver.click(By.id("btn-baseInfo-save"));
		//关闭提示框
		driver.pause(1000);
		
	} 
	
	//进入业务录入-基本信息-紧急联系人
	public void OfficeBasicInfoCtriticalContacts(String name,int relationship,String phone,int usecar,String address){
		driver.pause(3000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.click(By.id("btn-contacter-add"),20);
		driver.pause(1000);
		driver.sendKeys(By.name("emergencyContact"), name);
		driver.selectByIndex(By.name("relationship"), relationship);
		driver.sendKeys(By.xpath("//*[@id='contacterForm']//input[@name='mobilePhone']"), phone);
		driver.pause(1000);
		driver.selectByIndex(By.name("isCarUser"), usecar);
		driver.pause(1000);
		driver.sendKeys(By.name("contactAddress"), address);
		driver.pause(1000);
		//点击保存
		driver.click(By.id("btn-contacter-save"));
	} 
	
	//进入业务录入-基本信息-流程意见
	public void OfficeBasicInfoOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "内勤录入同意");
	} 

	//预算单
	public void Budget(int businessType){
		//进入预算单tab
		driver.click(By.xpath("//a[@href='#budget']"));
		//输入基本信息
		driver.selectByIndex(By.id("isPublicLicense"), 1);
		driver.sendKeys(By.id("licenseCompany"), "浙江金湖宝马有限公司");
		driver.selectByIndex(By.id("paymentMethod"), 1);  //全额打款
		
		
		/**
		 * 输入费用信息
		 */
		//GPS
		driver.selectByIndex(By.id("gpsNumber"), 1);
		//第一年保险
		driver.selectByIndex(By.id("premiumType"), 1);
		//第一年保险-金额
		driver.sendKeys(By.id("insuranceAmount"), "100");
		//保险公司
		driver.selectByIndex(By.id("insurance"), 1);
		//上户押金
		driver.sendKeys(By.id("accountDeposit"), "100.36");
		//是否续保
		driver.selectByIndex(By.id("isRenewal"), 1);
		//续保押金
//		driver.sendKeys(By.id("renewalDeposit"), "100.36");
		//履约保证金
		driver.sendKeys(By.id("pbDeposit"), "100");
		//预计车辆购置税
		driver.selectByIndex(By.id("predictedPurchasetax"), 1);
		
		if(businessType==1){
			//预计车辆购置税-金额
			driver.sendKeys(By.id("purchaseTax"), "100");
			//提车方式
			driver.selectByIndex(By.name("deliveryMethod"), 1);
			//付款等级
			driver.selectByIndex(By.name("paymentLevel"), 1);
			//结算方式
			driver.selectByIndex(By.name("settleMethod"), 1);
//			String totalfee = driver.getAttribute(By.id("totalFee"), "value"); //获取费用合计
//			driver.sendKeys(By.id("collectedAmount"), totalfee);
		}else{
			logger.info("走银行直销");
		}

		
		//点击保存预算单
		driver.pause(2000);
		driver.click(By.id("btn-budgetInfo-save"));
		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
	}
	
	//进入业务录入-影像管理TAB
	public void ImageManageEnter(){
		driver.pause(1000);
//		driver.selectFrame(By.name("iframe_undefined"));
//		driver.click(By.xpath("//*[@href='#detail']"));
	}
	
	
	
	//进入业务录入-影像管理-上传图片
	public void ImageManageUpload(int i){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,1);
	}
	
	//关联保证人
	public void CorrelationGuarantor(int correct){
		driver.click(By.xpath("//a[@href='#guarantee']"));
		driver.pause(3000);
		if(correct==1){
			GuaranteeInfoEnter1();
		}else{
			//关联担保人
			driver.pause(1000);
			driver.click(By.id("relationGuarantor"));
//			driver.pause(1000);
//			driver.sendKeys(By.xpath("//*[@id='searchGuarantor']/div[1]/div[1]/div/input"), "演的多");
//			driver.click(By.id("btn-guarantor-search2"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_rGuarantor']/tbody/tr[1]/td[1]/a"));
			GuaranteeInfoEnter1();
			//添加反担保人
			driver.pause(1000);
			driver.click(By.id("addGuarantor"));
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[1]/div[1]/div/input"), "反担保人");
			driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[2]/div[1]/div/select"), 1);
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[2]/div[2]/div/input"), "110102199701019252");
			driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[2]/div[3]/div/select"), 1);
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[3]/div[1]/div/input"), "1997-01-01");
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[3]/div[2]/div/input"), "20");
			driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[3]/div[3]/div/select"), 2);
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[4]/div[1]/div/input"), "13200000000");
			GuaranteeInfoEnter2();
		}
		
		//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
	}

	//输入担保人信息//*[@id="getLoanGuarantorInfo"]/form/fieldset/div/div[2]/fieldset/div[4]/div[1]/div/input
	public void GuaranteeInfoEnter1(){
		driver.pause(1000);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[4]/div[2]/div/input"), "021-62202120");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[4]/div[3]/div/input"), "杭州");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[5]/div[1]/div/select"), 4);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[5]/div[2]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[6]/div[1]/div/input"), "软件测试工程师");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[6]/div[2]/div/select"), 7);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[6]/div[3]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[7]/div[1]/div/input"), "车果网络cgw");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[7]/div[2]/div/input"), "021-6222122");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[7]/div[3]/div/select"), 2);
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[8]/div[1]/div/select"), 8);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[8]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[8]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[9]/div/div/input"), "黑龙江单位地址");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[10]/div[1]/div/select"), 9);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[10]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[10]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/div/div[1]/div/input"), "上海家庭地址");
		driver.click(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/div/div[2]/button[1]"));
	}
	
	public void GuaranteeInfoEnter2(){
		driver.pause(1000);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[4]/div[2]/div/input"), "021-62202120");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[4]/div[3]/div/input"), "杭州");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[5]/div[1]/div/select"), 4);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[5]/div[2]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[6]/div[1]/div/input"), "软件测试工程师");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[6]/div[2]/div/select"), 7);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[6]/div[3]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[7]/div[1]/div/input"), "车果网络cgw");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[7]/div[2]/div/input"), "021-6222122");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[7]/div[3]/div/select"), 2);
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[8]/div[1]/div/select"), 8);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[8]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[8]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[9]/div/div/input"), "黑龙江单位地址");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[10]/div[1]/div/select"), 9);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[10]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[10]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/div/div[1]/div/input"), "上海家庭地址");
		driver.click(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/div/div[2]/button[1]"));
	}
	
	//提交
	public void OfficeSubmit(String loginAccount){
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
	}

	/**
	 * 进入我的任务-待办-内勤录入-上传图片
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(int businessType,String loginAccount,int maritalstatus,int customerAlready,int relationship) {
		if(customerAlready==0){
			System.out.println("--------------customerAlready:"+customerAlready+"-----------------");
			OfficeBasicInfoBorrower();
			OfficeBasicInfoBorrowerWife(maritalstatus);
		}else{
			logger.debug("");
		}
		OfficeBasicInfoCtriticalContacts("王五",1,"13200000000",1,"浙江杭州西湖区文一西路11号");
		OfficeBasicInfoCtriticalContacts("王刘",2,"13200000001",0,"浙江杭州西湖区文一西路12号");
		OfficeBasicInfoOpinion();
		Budget(businessType);
		ImageManageEnter();
//		for(int i = 5;i<=14;i++){
//			ImageManageUpload(i);
//		}
//		for(int i=23;i<=27;i++){
//			ImageManageUpload(i);
//		}
		CorrelationGuarantor(relationship);
		OfficeSubmit(loginAccount);
		return new HomePage(driver);
	}


}
