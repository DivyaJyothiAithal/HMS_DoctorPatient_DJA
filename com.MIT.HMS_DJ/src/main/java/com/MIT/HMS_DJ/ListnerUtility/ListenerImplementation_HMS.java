package com.MIT.HMS_DJ.ListnerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation_HMS implements ITestListener,ISuiteListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
	
		String timestamp=new Date().toString().replace(" ", " _ ").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/Report_"+timestamp+".html");
		spark.config().setDocumentTitle("MIT_HMS TestSuite Results");
		spark.config().setReportName("MIT_HMS");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-100");	
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
	test=report.createTest(result.getMethod().getMethodName());
	test.log(Status.INFO, result.getMethod().getMethodName()+"_Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"_PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String TestName=result.getMethod().getMethodName();
		
		TakesScreenshot tks=(TakesScreenshot)BaseClassHMS.sdriver;
		String filepath=tks.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", " _ ").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,TestName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"_Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+"_Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
	}
	
}
