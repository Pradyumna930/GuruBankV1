package com.guruBanking.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guruBanking.pageObjects.AddCustomerPage;
import com.guruBanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003  extends BaseClass {
	
	
	@Test()
	public void addNewCustomer() throws IOException, InterruptedException, AWTException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(usn);
		lp.setpass(psw);
		lp.clickbtn();
		
		Thread.sleep(3000);
		AddCustomerPage acp =new AddCustomerPage(driver);
		
		acp.addNewCustomer();
		logger.info("addcustmr clicked");
		boolean yes=driver.getPageSource().contains("Add New Customer");
		if(yes==true)
		{
			logger.info("add new customerpage displayed");
		}
		else
		{
			logger.info("failed");
			driver.navigate().refresh();
			logger.info("add found refresh");
			Thread.sleep(4000);
			acp.addNewCustomer();
			
		}
		Thread.sleep(4000);
		acp.enterCustmerName("Pradyumna");
		logger.info("custmr name entered");
		acp.selectGender("male");
		Thread.sleep(2000);
		acp.enterdob("12", "09", "1998");
		logger.info("custmr dob entered");
		Thread.sleep(4000);

		acp.enterCustaddress("ujire");
		acp.enterCity("mangalore");
		acp.enterState("Karnataka");
		acp.enterPinNo("574240");
		String number=randomNumber();
		acp.enterMobNo(number);
		String mail=randomString()+"@gmail.com";
		Thread.sleep(4000);
		acp.enterEmail(mail);
		
		acp.enterPassword("jjhjj");
		acp.clickSubmit();
		logger.info("all data submitted");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) 
		{
			
		Assert.assertTrue(true);
	    }
		else 
		{
			captureScreen(driver, "add new customer");
		 Assert.assertTrue(false);	
		}
		
		
		
	}
	
	

}
