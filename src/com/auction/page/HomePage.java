package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.DocDelivery.DocDeliveryContractCopyDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryDataFileDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryDataReVerifyDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryDataVerifyDetailToDo;
import com.auction.page.DocDelivery.DocDeliveryStartDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskAcceptCreditDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskInputCreditDetailToDo;
import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.businessfiles.BusinessFilesPage;
import com.auction.page.customermanage.CustomerManageChangePage;
import com.auction.page.customermanage.CustomerManagePage;
import com.auction.page.insurancemanage.InsuranceRegisterDetailToDo;
import com.auction.page.mytask.MyTaskAutoFinanceDetailToDo;
import com.auction.page.mytask.MyTaskBranchCompanyAccountDetailToDo;
import com.auction.page.mytask.MyTaskBranchCompanyManagerDetailToDo;
import com.auction.page.mytask.MyTaskFinanceDepartmentAccountDetailToDo;
import com.auction.page.mytask.MyTaskFinanceDepartmentHeadDetailToDo;
import com.auction.page.mytask.MyTaskFinanceManagerDetailToDo;
import com.auction.page.mytask.MyTaskLoanStartDetailToDo;
import com.auction.page.mytask.MyTaskMainSignBillInvestDetailToDo;
import com.auction.page.mytask.MyTaskMiddleCheckDetailToDo;
import com.auction.page.mytask.MyTaskOfficeDetailToDo;
import com.auction.page.mytask.MyTaskPrimaryCheckDetailToDo;
import com.auction.page.mytask.MyTaskSecondSignBillInvestDetailToDo;
import com.auction.page.mytask.MyTaskSignBillDistributionDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarEvaluateStartDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarPreEvaluationDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarReEvaluationDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarTransferDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarTransferReportDetailToDo;
import com.auction.page.secondcar.MyTaskSecondCarTransferVerifyDetailToDo;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 所有进入主入口的方法都放在这里
 * @author 10066611
 *
 */
public class HomePage extends BasePage {
	private Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【HomePage】");
	}

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	public LoginPage goLoginPage() {
		return new LoginPage(driver);
	}
	
	/**
	 * 注销登录
	 * @return
	 */
	public LoginPage Logincancel(){
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='page-wrapper']/div[1]/nav/div[2]/div/div/ul/li[4]/span"));
		driver.pause(1000);
		driver.click(By.id("exitSure"));
		return new LoginPage(driver);
	}
	

	/**
	 * 退出登录进入登录页面
	 * 
	 * @return
	 */
	public LoginPage logout() {
		driver.click(By.partialLinkText("注销"));
		return new LoginPage(driver);
	}
	
	/**
	 * 进入业务档案页面
	 * @return
	 */
	public BusinessFilesPage goBusinessFilesPage() {
		driver.pause(1000);
		driver.click(By.xpath("/html/body/div/div/div[3]/ul/li[2]"));
		return new BusinessFilesPage(driver);
	}
	/**
	 * 进入客户管理页面-修改
	 * @return
	 */
	public CustomerManageChangePage goCustomerManageChangePage() {
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/ul/li[2]/a"));
		driver.pause(1000);
		return new CustomerManageChangePage(driver);
	}
	
	/**
	 * 进入客户管理页面-新增
	 * @return
	 */
	public CustomerManagePage goCustomerManagePage() {
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/ul/li[2]/a"));
		driver.pause(1000);
		return new CustomerManagePage(driver);
	}
	
	/**
	 * 进入资信发起页面
	 * @return
	 */
	public StartCreditPage goStartCreditPage() {
		driver.selectDefaultFrame();
		driver.click(By.xpath("//*[@id='side-menu']/li[5]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='3001']"));
		driver.pause(1000);
		return new StartCreditPage(driver);
	}
	
	/**
	 * 进入录入征信页面
	 * @return
	 */
	public MyTaskInputCreditDetailToDo goInputCreditPage() {
		return new MyTaskInputCreditDetailToDo(driver);
	}
	
	/**
	 * 进入接受征信页面
	 * @return
	 */
	public MyTaskAcceptCreditDetailToDo goAcceptCreditPage() {
		return new MyTaskAcceptCreditDetailToDo(driver);
	}
	
	/**
	 * 进入我的任务页面
	 * @return
	 */
	public MyTaskPage goMyTaskPage(int flag) {
		driver.selectDefaultFrame();
		if(flag==1){
			driver.click(By.xpath("//*[@id='side-menu']/li[2]/a"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='side-menu']/li[2]/ul/li/a"));
			driver.pause(1000);
		}else{
			String text = driver.getAttribute(By.xpath("//*[@id='side-menu']/li[2]"), "class");
			System.out.println("---------------------1111111"+text+"222222222-----------------------");
			if(text.equals("active")){
				driver.click(By.xpath("//*[@id='side-menu']/li[2]/ul/li/a"));
				driver.pause(1000);
			}else{
				driver.click(By.xpath("//*[@id='side-menu']/li[2]/a"));
				driver.pause(1000);
				driver.click(By.xpath("//*[@id='side-menu']/li[2]/ul/li/a"));
				driver.pause(1000);
			}

		}
		return new MyTaskPage(driver);
	}
	

	
	/**
	 * 进入我的任务-征信开始页面
	 * @return
	 */
	public MyTaskStartCreditDetailToDo goMyTaskStartCreditDetailToDo() {
		return new MyTaskStartCreditDetailToDo(driver);
	}

		
	/**
	 * 进入贷款发起页面
	 * @return
	 */
	public MyTaskLoanStartDetailToDo goMyTaskLoanStartDetailToDo() {
		driver.click(By.xpath("//*[@id='side-menu']/li[5]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='3002']"));
		return new MyTaskLoanStartDetailToDo(driver);
	}
	
	/**
	 * 进入签单分配页面
	 * @return
	 */
	public MyTaskSignBillDistributionDetailToDo goMyTaskSignBillDistributionDetailToDo() {
		return new MyTaskSignBillDistributionDetailToDo(driver);
	}
	
	/**
	 * 进入主签单调查页面
	 * @return
	 */
	public MyTaskMainSignBillInvestDetailToDo goMyTaskMainSignBillInvestDetailToDo() {
		return new MyTaskMainSignBillInvestDetailToDo(driver);
	}
	
	/**
	 * 进入副签单调查页面
	 * @return
	 */
	public MyTaskSecondSignBillInvestDetailToDo goMyTaskSecondSignBillInvestDetailToDo() {
		return new MyTaskSecondSignBillInvestDetailToDo(driver);
	}
	
	/**
	 * 进入内勤录入页面
	 * @return
	 */
	public MyTaskOfficeDetailToDo goMyTaskOfficeDetailToDo() {
		return new MyTaskOfficeDetailToDo(driver);
	}
	
	/**
	 * 进入初级审核页面
	 * @return
	 */
	public MyTaskPrimaryCheckDetailToDo goMyTaskPrimaryCheckDetailToDo() {
		return new MyTaskPrimaryCheckDetailToDo(driver);
	}
	
	/**
	 * 进入中级审核页面
	 * @return
	 */
	public MyTaskMiddleCheckDetailToDo goMyTaskMiddleCheckDetailToDo() {
		return new MyTaskMiddleCheckDetailToDo(driver);
	}
	
	/**
	 * 进入分公司总经理页面
	 * @return
	 */
	public MyTaskBranchCompanyManagerDetailToDo goMyTaskBranchCompanyManagerDetailToDo() {
		return new MyTaskBranchCompanyManagerDetailToDo(driver);
	}
	
	/**
	 * 进入汽车金融部页面
	 * @return
	 */
	public MyTaskAutoFinanceDetailToDo goMyTaskAutoFinanceDetailToDo() {
		return new MyTaskAutoFinanceDetailToDo(driver);
	}
	
	/**
	 * 进入财务主管页面
	 * @return
	 */
	public MyTaskFinanceManagerDetailToDo goMyTaskFinanceManagerDetailToDo() {
		return new MyTaskFinanceManagerDetailToDo(driver);
	}
	
	/**
	 * 进入资金部主管页面
	 * @return
	 */
	public MyTaskFinanceDepartmentHeadDetailToDo goMyTaskFinanceDepartmentHeadDetailToDo() {
		return new MyTaskFinanceDepartmentHeadDetailToDo(driver);
	}
	
	/**
	 * 进入资金部出纳页面
	 * @return
	 */
	public MyTaskFinanceDepartmentAccountDetailToDo goMyTaskFinanceDepartmentAccountDetailToDo() {
		return new MyTaskFinanceDepartmentAccountDetailToDo(driver);
	}
	
	/**
	 * 进入资金部出纳页面
	 * @return
	 */
	public MyTaskBranchCompanyAccountDetailToDo goMyTaskBranchCompanyAccountDetailToDo() {
		return new MyTaskBranchCompanyAccountDetailToDo(driver);
	}
	
	/**
	 * 进入二手车评估发起页面
	 * @return
	 */
	public MyTaskSecondCarEvaluateStartDetailToDo goMyTaskSecondCarEvaluateStartDetailToDo() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[8]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='8001']"));
		return new MyTaskSecondCarEvaluateStartDetailToDo(driver);
	}
	
	/**
	 * 进入二手车过户发起页面
	 * @return
	 */
	public MyTaskSecondCarTransferDetailToDo goMyTaskSecondCarTransferDetailToDo() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[8]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='8002']"));
		return new MyTaskSecondCarTransferDetailToDo(driver);
	}
	
	/**
	 * 进入二手车评估发起页面
	 * @return
	 */
	public MyTaskSecondCarPreEvaluationDetailToDo goMyTaskSecondCarPreEvaluationDetailToDo() {
		return new MyTaskSecondCarPreEvaluationDetailToDo(driver);
	}
	
	/**
	 * 进入二手车过户审批页面
	 * @return
	 */
	public MyTaskSecondCarTransferVerifyDetailToDo goMyTaskSecondCarTransferVerifyDetailToDo() {
		return new MyTaskSecondCarTransferVerifyDetailToDo(driver);
	}
	
	/**
	 * 进入二手车过户评估报告页面
	 * @return
	 */
	public MyTaskSecondCarTransferReportDetailToDo goMyTaskSecondCarTransferReportDetailToDo() {
		return new MyTaskSecondCarTransferReportDetailToDo(driver);
	}
	
	/**
	 * 进入二手车复评页面
	 * @return
	 */
	public MyTaskSecondCarReEvaluationDetailToDo goMyTaskSecondCarReEvaluationDetailToDo() {
		return new MyTaskSecondCarReEvaluationDetailToDo(driver);
	}
	
	/**
	 * 进入文档传递页面
	 * @return
	 */
	public DocDeliveryStartDetailToDo goDocDeliveryStartDetailToDo() {
		driver.click(By.xpath("//*[@id='side-menu']/li[7]"));
		driver.click(By.xpath("//*[@id='side-menu']/li[7]/ul/li[1]"));
		return new DocDeliveryStartDetailToDo(driver);
	}
	/**
	 * 进入资料审核页面
	 * @return
	 */
	public DocDeliveryDataVerifyDetailToDo goDocDeliveryDataVerifyDetailToDo() {
		return new DocDeliveryDataVerifyDetailToDo(driver);
	}
	
	/**
	 * 进入合同抄写页面
	 * @return
	 */
	public DocDeliveryContractCopyDetailToDo goDocDeliveryContractCopyDetailToDo() {
		return new DocDeliveryContractCopyDetailToDo(driver);
	}
	/**
	 * 进入资料复核页面
	 * @return
	 */
	public DocDeliveryDataReVerifyDetailToDo goDocDeliveryDataReVerifyDetailToDo() {
		return new DocDeliveryDataReVerifyDetailToDo(driver);
	}
	/**
	 * 进入资料归档页面
	 * @return
	 */
	public DocDeliveryDataFileDetailToDo goDocDeliveryDataFileDetailToDo() {
		return new DocDeliveryDataFileDetailToDo(driver);
	}
	/**
	 * 进入保险管理页面
	 * @return
	 */
	public InsuranceRegisterDetailToDo goInsuranceRegisterDetailToDo() {
		if(driver.getAttribute(By.xpath("//*[@id='side-menu']/li[9]"), "class").equals("active")){
			driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='9001']"));
		}else{
			driver.click(By.xpath("//*[@id='side-menu']/li[9]/a"));
			driver.click(By.xpath("//*[@id='side-menu']//a[@data-index='9001']"));
		}
		return new InsuranceRegisterDetailToDo(driver);
	}
	
}
