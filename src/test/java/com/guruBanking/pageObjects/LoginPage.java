package com.guruBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
   @FindBy(name="uid")
   @CacheLookup
   WebElement usnTxtBox;
   @FindBy(name="password")
   @CacheLookup
   WebElement passTxtBox;
   @FindBy(name="btnLogin")
   @CacheLookup
   WebElement loginBtn;
   
   @FindBy(xpath = "//a[.=\"Log out\"]")
   @CacheLookup
   WebElement logout;
   
   
   public void setUserName(String usn)
   {
	   usnTxtBox.sendKeys(usn);
   }
   public void setpass(String pass)
   {
	   passTxtBox.sendKeys(pass);
   }
   public void clickbtn()
   {
	   loginBtn.click();
   }
   
   public void clicklogout() 
   {
	   logout.click();
   }
   
}
