package com.guruBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
 
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[3]/a")
	private WebElement editCustomerlink;
	
	@FindBy(name="cusid")
	private WebElement Customeridtbx;  //Edit Customer Form  
	
	@FindBy(name="AccSubmit")
	private WebElement subBtn;
	

	@FindBy(name="addr")
	private WebElement eadd;
	
	@FindBy(name="city")
	private WebElement Ecity;
	
	@FindBy(name="state")
	private WebElement Estate;
	
	
	@FindBy(name="pinno")
	private WebElement epin;
	
	@FindBy(name="telephoneno")
	private WebElement emob;
	
	@FindBy(name="emailid")
	private WebElement email;
	
	@FindBy(name="sub")
	private WebElement finalSub;
	
	public void clickEditCustLink()
	{
		editCustomerlink.click();
	}
	
	public void enterCustId(String id)
	{
		Customeridtbx.sendKeys(id);
	}
	
	public void clickSubIDbtn() 
	{
		subBtn.click();
	}
	
	public void editCitytbx(String city)
	{
		eadd.clear();
		eadd.sendKeys(city);
	}
	
	public void editAddress(String add)
	{
		Ecity.clear();
		Ecity.sendKeys(add);
	}
	
	public void editStatetbx(String state)
	{ 
		Estate.clear();
		Estate.sendKeys(state);
	}
	
	public void editpin(String pin)
	{
		epin.clear();
		epin.sendKeys(pin);
	}
	
	
	public void editMobNo(String mob)
	{
		emob.clear();
		emob.sendKeys(mob);
	}
	
	public void editEmail(String mail)
	{
		email.clear();
		email.sendKeys(mail);
	}
	
	public void clickfinalSubmit()
	{
		finalSub.click();
	}
	
	
	
	
}
