package com.ebanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestResult tr) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp(java)
		String repname = "Test-report-"+timestamp+".html";
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Envirnoment","QA");
		extent.setSystemInfo("user","gulu");

		htmlreporter.config().setDocumentTitle("internetBanking Test Project");
		htmlreporter.config().setReportName("Fuctional Test Report");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {

		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String Screenshotpic = System.getProperty("user.dir") + "\\Screenshot\\" + tr.getName() +".png";
		File f = new File(Screenshotpic);

		if (f.exists()) {
			try {
				logger.fail("screenshort is below:" + logger.addScreenCaptureFromPath(Screenshotpic));
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE));

	}

	public void onFinish(ITestResult tr) {
		extent.flush();
	}

}
