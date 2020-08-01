package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.MyWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utils.GlobalVars;

public class Logger{ // extends MyWebDriver{
	
	WebDriver driver = null;
	public Logger(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	private static ExtentReports extentReport;
	private static ExtentTest extenttest;
	private static String strDir = System.getProperty("user.dir");
	
	private  String getSreenShot() throws IOException {
		String strScreenShotPath = "";
		//GlobalVars globalVars = new GlobalVars();
		//System.out.println("Before GlobalVars webdriver value:"+globalVars.gdriver);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		strScreenShotPath = strDir +"/ErrorScreens/"+System.currentTimeMillis()+"_Screen.png";	
		File destFile = new File(strScreenShotPath);
		FileUtils.copyFile(srcFile, destFile);

		return strScreenShotPath;
	}
	
	public static void initReport(String strModuleName) {
		//extentReport = new ExtentReports(strDir +"/ErrorScreens/"+System.currentTimeMillis()+strModuleName+"Report.html");
		try {
			extentReport = new ExtentReports(strDir +"/ErrorScreens/index_Report.html");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testStart(String strTestcaseName, String strTestcaseDesc) {
		//extentReport = new ExtentReports(strDir +"/ErrorScreens/"+System.currentTimeMillis()+"Report.html");		
		//extentReport = new ExtentReports(strDir+"/"+System.currentTimeMillis()+"_ExtentReportResults.html");	
		extenttest = extentReport.startTest(strTestcaseName, strTestcaseDesc);
	}
	
	public  void logMsg(String strFlag, String strTestLogMsg){
	//public static void logMsg(STATUS status, String strTestLogMsg){
		try {
			//System.out.println("inside logMsg");
			if (strFlag.equalsIgnoreCase("PASS")) {
				extenttest.log(LogStatus.PASS, strTestLogMsg); 
				GlobalVars.softAssert.assertEquals(true, true, strTestLogMsg); }
			else if (strFlag.equalsIgnoreCase("FAIL")) {
				extenttest.log(LogStatus.FAIL, strTestLogMsg); 
				GlobalVars.softAssert.assertEquals(false, true, strTestLogMsg);}
			else if (strFlag.equalsIgnoreCase("INFO"))
				extenttest.log(LogStatus.INFO, strTestLogMsg); 
			else if (strFlag.equalsIgnoreCase("ERROR")) {
				extenttest.log(LogStatus.ERROR, strTestLogMsg); 
				extenttest.log(LogStatus.ERROR, extenttest.addScreenCapture(getSreenShot())); 
			}
			else if (strFlag.equalsIgnoreCase("WARNING"))
				extenttest.log(LogStatus.WARNING, strTestLogMsg); 
			else if (strFlag.equalsIgnoreCase("SKIP"))
				extenttest.log(LogStatus.SKIP, strTestLogMsg); 
		}
		catch(Exception e) {
			//System.out.println("ERROR in logMsg: "+e.getMessage());
		}
	}
	
	public static void closeReport() {
		extentReport.endTest(extenttest);
		extentReport.flush();
	}
}

enum STATUS{
	PASS, FAIL, INFO, ERROR, WARNING, SKIP;
	
}
