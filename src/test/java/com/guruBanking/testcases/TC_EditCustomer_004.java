package com.guruBanking.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.guruBanking.pageObjects.AddCustomerPage;
import com.guruBanking.pageObjects.EditCustomerPage;
import com.guruBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_EditCustomer_004 extends BaseClass{
 
	 
	
	AddCustomerPage acp;
	
	@Test()
	public void editCustomer() throws AWTException, InterruptedException, IOException
	{
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(usn);
		lp.setpass(psw);
		lp.clickbtn();
		logger.info("usn and pass submitted");
		EditCustomerPage ecp =new EditCustomerPage(driver);
		ecp.clickEditCustLink();
		logger.info("edit customer link click");
		boolean b= driver.getPageSource().contains("Edit Customer Form");
		
		if(b==true)
		{
			ecp.enterCustId("63718");
			logger.info("custmr id entered");
			
		}
		else
		{
			logger.warn("add is present need to refresh ");
			driver.navigate().refresh();
			ecp.clickEditCustLink();
			ecp.enterCustId("63718");
			logger.info("edit custmr link clicked and id entered");
			
			
		}
		ecp.clickSubIDbtn();
		logger.info("id submitted");
		String add=randomString();
		ecp.editAddress(add);
		logger.info("address editted "+add);
		String city = randomString();
		ecp.editCitytbx(city);
		logger.info("city edited "+city);
		String state =randomString();
		ecp.editStatetbx(state);
		logger.info("state eddited "+state);
		String pin = randomPNumber();
		ecp.editpin(pin);
		logger.info("pin eddited "+pin);
		String num =randomNumber();
		ecp.editMobNo(num);
		logger.info("mob num eddited "+num);
	    String mail= randomString()+"@gmail.com";
	    ecp.editEmail(mail);
	    logger.info("mob mail eddited "+mail);
	    ecp.clickfinalSubmit();
	    logger.info("final sub clicked");
	    Robot r =new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	   
	    logger.info("cross checking editted fields");
	    Thread.sleep(4000);
	    
	    ecp.clickEditCustLink();
	    ecp.enterCustId("63718");
		logger.info("custmr id entered");	
		ecp.clickSubIDbtn();
		logger.info("id submitted");
		Thread.sleep(4000);
		captureScreen(driver, "Edited info");
	}
}
