package com.guruBanking.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guruBanking.pageObjects.LoginPage;
import com.guruBanking.utilities.XLUtils;

public class TC_LogingDDT_002 extends BaseClass  {
	
	
	@Test(dataProvider="loginData")
	public void loginDDT(String usn,String pwd) throws Exception
	{
	LoginPage lp=new LoginPage(driver);	
	lp.setUserName(usn);
	logger.info("user name is provided");
	lp.setpass(pwd);
	logger.info("password is provided");
	lp.clickbtn();
	
	if(isAlerIsPresent()==true)
	{
		//Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("login failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("loggin passed");
		//Thread.sleep(2000);
		lp.clicklogout();
		logger.info("logged out");
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
	}
	
	}
	
	
	public boolean isAlerIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
		
  @DataProvider(name="loginData")
  String[][] getData() throws Exception
  {
	  String path=System.getProperty("user.dir")+"/src/test/java/com/guruBanking/testData/LoginData.xlsx";
	  int rowNum=XLUtils.getRowCount(path, "Sheet1");
	  int colCount=XLUtils.getCellCount(path, "Sheet1", 1);
	  
	  String logindata [][]=new String[rowNum][colCount];
	  for (int i=1;i<=rowNum;i++)
	  {
		  for (int j=0;j<colCount;j++)
		  {
			  logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j);
		  }
	  }
	  return logindata;
  }
  
}
