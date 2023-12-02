package com.guruBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig() 
	
	  {
		
		File src = new File(System.getProperty("user.dir")+"/Configeration/config.properties");
		
		try
		  {
		
			FileInputStream fis =new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		  }
		
		catch (Exception e)
		
		  {
			System.out.println("exception is " + e.getMessage());
		  }
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername()
	{
		String username =pro.getProperty("usn");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("psw");
		return password;
	}
	
	public String getchromepath()
	{
		String chromePath =pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getfirefoxpath()
	{
		String firefoxPath =pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getfirefoxDriver()
	{
		String firefoxDriver =pro.getProperty("firefoxDriver");
		return firefoxDriver;
	}
	public String getChromeDriver()
	{
		String ChromeDriver =pro.getProperty("chromeDriver");
		return ChromeDriver;
	}
}
