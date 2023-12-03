package com.guruBanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xddf.usermodel.TileFlipMode;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guruBanking.utilities.Readconfig;

 
public class BaseClass  {
	
	Readconfig readconfig =new Readconfig();
	
	public String baseUrl= readconfig.getApplicationURL();
	public String usn = readconfig.getUsername();
	public String psw= readconfig.getPassword();
	public WebDriver driver;
	
	public static Logger logger	;	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	//public void setup()
	{
		
		logger=Logger.getLogger("gurubank_v1");
        PropertyConfigurator.configure("log4j.properties");
        
       /* System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver= new ChromeDriver();*/
        
        if(browser.equals("chrome"))
        {
        System.setProperty(readconfig.getChromeDriver(), readconfig.getchromepath());
		driver =new ChromeDriver();
        }
        else if(browser.equals("firefox"))
        {
        System.setProperty(readconfig.getfirefoxDriver(), readconfig.getfirefoxpath());
		driver =new FirefoxDriver();
        }  
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseUrl);
	}
	 
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, dst);
		System.out.println("screenshot taken");
	}
	public String randomString()
	{
		String generartedString =RandomStringUtils.randomAlphabetic(5);
		return (generartedString);
	}
	public String randomNumber()
	{
		String nmber=RandomStringUtils.randomNumeric(10);
		return (nmber);
	}
	
	public String randomPNumber()
	{
		
		String pin=RandomStringUtils.randomNumeric(6);
		return (pin);
	}

}
