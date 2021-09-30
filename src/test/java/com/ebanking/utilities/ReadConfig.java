package com.ebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
			
		}catch(Exception e){
			System.out.println("Exception message"+e.getMessage());
	
		}
	
	}
	
public String getApplicationurl()
{
	String url=pro.getProperty("baseurl");
	return url;
}
public String getUsername()
{
	String fullname=pro.getProperty("username");
	return fullname;
}
public String getPassword()
{
String pass=pro.getProperty("password");
return pass;
}
public String getChromepath()
{
	String chromep=pro.getProperty("chromepath");
	return chromep;
}
public  String getFirefoxpath()
{
String firefoxp=pro.getProperty("firefoxpath");	
return firefoxp;
}
public String getIEpath()
{
	String iep=pro.getProperty("iepath");
	return iep;
}




















}
