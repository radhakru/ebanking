package com.ebanking.testcases;




import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.objectpage.Loginpage;


public class TC_Logintest_001 extends Baseclass 
{

	@Test
	public void Logintest() throws IOException
	{
	
	
	Loginpage dc=new Loginpage(driver);
	dc.setusername(uname);
	logger.info("Enter username");
	
	dc.setpassword(pwd);
	logger.info("Enter password");
	
	
	dc.clicksubmit();
	
	
	driver.switchTo().alert().accept();
	System.out.println(driver.getTitle());
	if(driver.getTitle().equals("Guru99 Bank Home Page"))
	{
	Assert.assertTrue(true);	
	}
	else
	{
	captureScreen(driver,"Logintest");
	Assert.assertTrue(false);
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
