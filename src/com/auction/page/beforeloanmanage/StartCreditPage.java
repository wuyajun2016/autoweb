package com.auction.page.beforeloanmanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 发起征信后保存
 * @author Administrator
 *
 */
public class StartCreditPage extends BasePage{
	private Logger logger = Logger.getLogger(StartCreditPage.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	
	public StartCreditPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【StartCreditPage】");
//		vercode = getVercode("GBK");
	}


	//点击发起征信按钮
	public void clickStartCreditButton() {
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_3001"), 1000);
		driver.click(By.xpath("//*[@id='launchedCredit']/span"));
		driver.pause(1000);
	}
	//输入客户名称
	public void inputCustomerName(String customerName) {
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"), 1000);
		driver.sendKeys(By.name("customerName"), customerName);
	}
	//选择证件类型
	public void chooseCustomerIdentify(int CustomerIdentifyType) {
		driver.selectByIndex(By.name("cardType"), CustomerIdentifyType);
	}
	//输入证件号码
	public void inputCustomerIdentify(String CustomerIdentify) {
		driver.sendKeys(By.name("cardNo"), CustomerIdentify);

	}
	/**
	 * 
	 * @param maritalStatus 1代表已婚，其他都是未婚
	 */
	public void inputmaritalStatus(int maritalStatus,String identifyNoMarry) {
		if(maritalStatus==1){
			driver.selectByIndex(By.name("maritalStatus"), maritalStatus);
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].fullName']"), "配偶");
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].cardId']"), identifyNoMarry);
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].mobile']"), "13200000000");
			driver.click(By.xpath("//*[@id='wife']/div[2]/div[3]/div[1]/button"));
			driver.pause(1000);
			win32guibyau3.fileUpload("打开","C:\\Users\\Public\\Pictures\\Sample Pictures\\2.jpg",1);
		}else{
			driver.selectByIndex(By.name("maritalStatus"), maritalStatus);
		}

	}
	//输入调查银行
	public void inputinvestigationBank(int investigationBank) {
		driver.selectByIndex(By.name("inquryBankId"), investigationBank);
	}
	//输入手机号码
	public void inputCellPhone(String CustomerCellPhone) {
		driver.sendKeys(By.xpath("//*[@id='creditForm']//input[@name='relavants[0].mobile']"), CustomerCellPhone);
//		driver.jsExecutor("document.getElementByName(\"relavants[0].borrowerRelationship\").value='4';");
	}
	//资信文件上传
	public void inputimages() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='creditForm']/div[3]/div/div[2]/div[3]/div[1]/button"));
		driver.pause(1000);
		win32guibyau3.fileUpload("打开","C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg",1);
	}
	
	/**
	 * 是否添加关系人
	 * @param addreationship 关系人，1表示添加，2表示不添加
	 * @param guarantor 1表示担保人，2表示反担保人
	 */
	public void addReationship(int addreationship,int guarantor,int maritalStatus){
		if(addreationship==1&&maritalStatus==1){
			driver.click(By.id("addParty"));
			driver.pause(3000);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[3].fullName']"), "关系人");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[3].cardId']"), "130103198701018896");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[3].mobile']"), "13000000000");
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[3].borrowerRelationship']"), 10);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[3].guaranteeRelationship']"), guarantor);
		}else{
			logger.debug("不需要添加关系人");
		}
		if(addreationship==1&&maritalStatus!=1){
			driver.click(By.id("addParty"));
			driver.pause(3000);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].fullName']"), "关系人");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].cardId']"), "130103198701018896");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].mobile']"), "13000000000");
			driver.pause(1000);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].borrowerRelationship']"), 10);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].guaranteeRelationship']"), guarantor);
		}else{
			logger.debug("不需要添加关系人");
		}
	}
	
	//发起征信页面部分文案校验
	public void checkContent(String customerName,String customerManagerName,String CustomerIdentifyType, String CustomerIdentify){
		boolean isSucceed = false;
//		driver.selectFrame(By.name("iframe5"), 1000);
		//获取借款人姓名
		String lgusername = (String) driver.jsReturner("return document.getElementById('name').value");
		//获取客户经理名字
		String ctname = (String) driver.jsReturner("return document.getElementsByTagName('input')[5].value"); 
		//获取证件类型
		String identifytype = (String) driver.jsReturner("return document.getElementsByTagName('input')[8].value"); 
		//获取证件号码
		String identifyno = (String) driver.jsReturner("return document.getElementsByTagName('input')[10].value"); 
		System.out.println("借款人姓名"+lgusername);
		System.out.println("客户经理名字"+ctname);
		System.out.println("证件类型"+identifytype);
		System.out.println("证件号码"+identifyno);
		System.out.println("1借款人姓名"+customerName);
		System.out.println("1客户经理名字"+customerManagerName);
		System.out.println("1证件类型"+CustomerIdentifyType);
		System.out.println("1证件号码"+CustomerIdentify);
		//判断文案是否和期望值一致
		if(lgusername.equals(customerName)&&ctname.equals(customerManagerName)&&identifytype.equals(CustomerIdentifyType)&&identifyno.equals(CustomerIdentify)){
			isSucceed = true;
			logger.debug("征信发起_校验成功");
		}else{
			logger.debug("征信发起_校验失败");
			Assert.assertTrue(isSucceed,".testLogin failed!capture");
		}
	}
	//点击保存按钮
	public void clickSaveButton() {
		driver.click(By.id("preservation"));
		driver.pause(2000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='toast-container']"),10);
		//关闭全部TAB
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}





	/**
	 * 发起征信内容输入
	 * @param customerName 客户名称
	 * @param CustomerIdentifyType 证件类型
	 * @param CustomerIdentify 证件号码
	 * @param CustomerCellPhone 借款人手机号码
	 * @param maritalStatus 婚姻状态
	 * @param investigationBank 调查银行
	 * @return
	 */
	public HomePage StartCredit(String customerName, int CustomerIdentifyType, String CustomerIdentify,String CustomerCellPhone,
			int maritalStatus,String investigationBank,String CustomerManagerName,String identifyNoMarry,int addreationship,int guarantor) {
		driver.pause(1000);
		//转化下1为身份证
		String sfz = null;
		if(CustomerIdentifyType==1){
			sfz="身份证";
		}else{
			sfz="其他";
		}
		//传过来的investigationBank不用，重新定义一个值标示所要选择的银行
		int investbank = 2;
		//发起征信
		clickStartCreditButton();
		inputCustomerName(customerName);
		chooseCustomerIdentify(CustomerIdentifyType);
		inputCustomerIdentify(CustomerIdentify);
		inputmaritalStatus(maritalStatus,identifyNoMarry);
		inputinvestigationBank(investbank);		
		inputCellPhone(CustomerCellPhone);
		inputimages();
		addReationship(addreationship,guarantor,maritalStatus);
		checkContent(customerName, CustomerManagerName, sfz, CustomerIdentify);
		clickSaveButton();
		return new HomePage(driver);
	}


}
