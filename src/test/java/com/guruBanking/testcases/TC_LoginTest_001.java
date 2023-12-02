package com.guruBanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guruBanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	void loginTest() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(usn);
		logger.info("enterUSN");
		lp.setpass(psw);
		logger.info("passwor entered");
		lp.clickbtn();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		logger.info("login passed");
		}
		else 
		{
			captureScreen(driver, "Login test");
			Assert.assertTrue(false);
		logger.info("failed");
		}
	}
	
}
