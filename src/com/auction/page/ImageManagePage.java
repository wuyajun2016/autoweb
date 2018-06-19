package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * 影像管理页面
 * @author Administrator
 *
 */
public class ImageManagePage extends BasePage{
	private Logger logger = Logger.getLogger(ImageManagePage.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public ImageManagePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in 【ImageManagePage】");
	}


	/**
	 * 内勤录入中还有个切换iframe的单独放在MyTaskOfficeDetailToDo类中
	 * @param i 循环对象
	 * @param type 1普通贷款，2二手车发起
	 */
	public void ImageManage(int i,int type) {
		if(type==1){
			driver.click(By.xpath("//*[@href='#detail']"));
		}
		else{
			driver.pause(1000);
			driver.selectFrame(By.name("iframe_undefined"));
			driver.click(By.id("tab2"));
			driver.pause(1000);
		}

		try{
			driver.pause(1000);
			driver.click(By.id("tree_"+i+"_span"));

			if(type==1){
				driver.click(By.xpath("//*[@id='detail']/div/div[1]/div[2]/div/div[2]/ul/li[2]/a"));
			}
			else{
				driver.click(By.xpath("//*[@id='done']/div/div[1]/div[2]/div/div[2]/ul/li[2]/a"));
			}


			driver.click(By.xpath("//*[@id='upImage']/span"));

			win32guibyau3.fileUpload("打开","C:\\Users\\Public\\Pictures\\Sample Pictures\\"+(int)Math.rint(Math.random()*30)+".jpg",1);

			driver.click(By.xpath("//*[@id='upload']/span"));
			driver.pause(2000);
		}catch(Exception e){
			logger.debug("未找到节点元素");

		}
		
	}
	
	//查看图片
	public void CheckImage() {
		driver.pause(1000);
		driver.click(By.xpath("//a[@href='#detail']"));
		driver.pause(1000);
		driver.click(By.id("tree_4_span"),3);
		driver.click(By.xpath("//*[@id='documentList']/div/div/div[1]"),3);
		driver.pause(2000);
		driver.selectDefaultFrame();
		driver.click(By.xpath("//*[@id='imageSwitch']//button[@class='close']"),3);
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
	}

	public HomePage PageOfImageManage(int i,int type) {
		ImageManage(i,type);
		return new HomePage(driver);
	}


}
