package com.opcbiz.fxprimus.testscript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.opcbiz.fxprimus.dto.OpcDto;
import com.opcbiz.fxprimus.utils.ReportUtil;

public class BaseTest {
	protected WebDriver driver;
	public static ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@BeforeSuite
	//@Parameters({"paraName"})
	public void beforeSuite(
			//String paraName
			) {
//		System.out.println(paraName);
		extentReport = new ExtentReports();
		extentReport.attachReporter(ReportUtil.getExtentHtmlReporter());
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Automation Tool ", "Selenium");
		extentReport.setSystemInfo("Build Automation Tool", "Maven");
	
	}
	
	@AfterSuite
	public void afterSuite() {
//		driver.quit();
	}
	
 
	@AfterClass
	public void afterClass() {
		
	}

//	@AfterMethod
//	public void afterMethod(Method method, ITestResult testResult) {
//	
//	}

	public void log(String message) {
		System.out.println(message);
	}
	public void log(String message, String suffix) {
		for(int i =0;i<9;i++) {
			message+=suffix;
		}
		System.out.println(message);
	}
	// after caas

	public String pass;
	public boolean xaviReturn(String dtoId) {
		if(pass.equals("pique")) {
			if( dtoId.endsWith("2") ||  dtoId.endsWith("3")   ) {
				return true;
			}
		}
		if(pass.equals("rakitic")) {
			if( dtoId.endsWith("8") ||  dtoId.endsWith("9") ||  
					dtoId.endsWith("7")  ) {
				return true;
			}
		}
		if(pass.equals("busquets")) {
			if( dtoId.endsWith("4") ||  
					dtoId.endsWith("5") ||  dtoId.endsWith("6")    ) {
				return true;
			}
		}
		if(pass.equals("dejong")) {
			if( dtoId.endsWith("0") ||    dtoId.endsWith("1")    ) {
				return true;
			}
		}
		return false;
	}
	
	public void pause(long timer) {
		try {
			System.out.println("wait: " + timer);
			Thread.sleep(timer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
