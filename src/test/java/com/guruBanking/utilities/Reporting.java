package com.guruBanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlRepoter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
	String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String repName="Test-Report"+timeStamp+".html";
	htmlRepoter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	htmlRepoter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent =new ExtentReports();
	
	extent.attachReporter(htmlRepoter);
	extent.setSystemInfo("Host name", "local host");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("user", "Pradyumna");
	
	htmlRepoter.config().setDocumentTitle("Guru Bank Test Project");
	htmlRepoter.config().setReportName("Functional report");
	htmlRepoter.config().setTheme(Theme.DARK);
	
	}

	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenShotPath=System.getProperty("user.dir")+"/screenshots/"+tr.getName()+".png";
		File f =new File(screenShotPath);
		
		if(f.exists())
		{
			try
			{
				logger.fail("Screenshot is below"+logger.addScreenCaptureFromBase64String(screenShotPath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}	
		
	}
	
	public void OnTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
	}
	
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
  }
