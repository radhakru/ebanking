package com.ebanking.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebanking.objectpage.Loginpage;
import com.ebanking.utilities.XLUtile;

public class TC_Logintest_002 extends Baseclass
{
@Test(dataProvider="LoginData")	
public void testdata(String userna,String passw) 
{
Loginpage lp=new Loginpage(driver);
lp.setusername(userna);
logger.info("set username");
lp.setpassword(passw);
logger.info("set password");
lp.clicksubmit();
logger.info("submit");

logger.info("enter in alert page");
if(ispresentalert()==true)
{
driver.switchTo().alert().accept();
driver.switchTo().defaultContent();
Assert.assertTrue(true);
logger.info("Accept the alert");
}
else
{
Assert.assertTrue(false);	
}



}
public boolean ispresentalert()
{
try
{
	driver.switchTo().alert();
	return true;
}
catch(NoAlertPresentException e)
{
	return false;
}
}	

@DataProvider(name="LoginData")
String [][] getdata() throws IOException
{
	String ph=System.getProperty("user.dir")+"/src/test/java/com/ebanking/testdata/etest1.xlsx";//store the file path as string. 
	int rowcount=XLUtile.getRowCount(ph,"Sheet1");
	int cellcount=XLUtile.getCellCount(ph,"Sheet1",1);
System.out.println(rowcount);
System.out.println(cellcount);
	String logindata[][]=new String[rowcount][cellcount];
for(int i=0;i<rowcount;i++)
{
	for(int j=0;j<cellcount;j++)
	{
		logindata[i][j]=XLUtile.getCellData(ph,"Sheet1",i,j);
		
	}
}
return logindata;


}
	
	
	
	
}
