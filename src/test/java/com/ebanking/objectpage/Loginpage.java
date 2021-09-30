package com.ebanking.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver ldriver;
	
public Loginpage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
}
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtuesrname;
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	public void setusername(String uname)
	{
		txtuesrname.sendKeys(uname);	
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void clicksubmit() 
	{
		btnLogin.click();
	}
	
	
	
	
	
	
	
	
	
	
}
