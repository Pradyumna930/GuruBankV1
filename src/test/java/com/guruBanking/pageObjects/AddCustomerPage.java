package com.guruBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcustomer;
	
	
	
	@FindBy(name="name")
	@CacheLookup
	WebElement custName;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement mRadbtn;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement fRadbtn;
	
	@FindBy(xpath = "//*[@id='dob']")
	@CacheLookup
	WebElement DOBtbx;
	
	@FindBy(name ="addr")
	@CacheLookup
	WebElement addressTAF;
	
	@FindBy(name ="city")
	@CacheLookup
	WebElement citytbx;
	
	@FindBy(name ="state")
	@CacheLookup
	WebElement statetbx;
	
	@FindBy(name ="pinno")
	@CacheLookup
	WebElement pintbx;
	
	@FindBy(name ="telephoneno")
	@CacheLookup
	WebElement mobnotbx;
	
	@FindBy(name ="emailid")
	@CacheLookup
	WebElement emailtbx;
	
	@FindBy(name ="password")
	@CacheLookup
	WebElement pswtbox;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement subbtn;
	
	public void addNewCustomer()
	   {
		   newcustomer.click();;
	   }
	
	
	public void enterCustmerName(String cname)
	   {
		   custName.sendKeys(cname);
	   }
	
	public void selectGender(String gen)
	   {
		  if(gen.equals("male"))
		  {
			  mRadbtn.click();
		  }
		  else
		  {
			  fRadbtn.click();
		  }
	   }
	
	public void enterdob(String mm,String dd,String yyyy)
	   {
		   DOBtbx.sendKeys(mm);
		   DOBtbx.sendKeys(dd);
		   DOBtbx.sendKeys(yyyy);
	   }
	
	public void enterCustaddress(String add)
	   {
           addressTAF.sendKeys(add);
	   }
	
	public void enterCity(String cty)
	   {
           citytbx.sendKeys(cty);
	   }

	public void enterState(String st)
	   {
          statetbx.sendKeys(st);
	   }
	
	public void enterPinNo(String pin)
	   {
          pintbx.sendKeys(pin);
	   }
	
	public void enterMobNo(String mob)
	   {
          mobnotbx.sendKeys(mob);
	   }
	
	public void enterEmail(String email)
	   {
          emailtbx.sendKeys(email);
	   }
	
	public void enterPassword(String psw)
	   {
          pswtbox.sendKeys(psw);
	   }
	
	public void clickSubmit()
	   {
           subbtn.click();
	   }
	
	
	
	
	
	
	
}
