package com.MIT.HMS_DJ.BaseTest;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.GenericUtility.FileUtility;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.AdminLoginPage;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;


public class BaseClassHMS {

	//Object Creation
		public WebDriver driver=null;
		public FileUtility fileUtil=new FileUtility();
		public ExcelUtility excelLib=new ExcelUtility();
		public JavaUtility jlib=new JavaUtility();
		public WebDriverUtility wblib=new WebDriverUtility();
		
		public static WebDriver sdriver;
		
		
		@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
		public void BeforeSuiteImplementation()
		{
			System.out.println("Database connected.......");
		}
		
		@Parameters("Browser")
		@BeforeClass (groups = {"SmokeTest","RegressionTest"})
		public void BeforeClassImplementation(@Optional("chrome") String browser) throws Throwable 
		{
			String BROWSER=browser;
			//String BROWSER=fileUtil.getDataFromPropertiesFile("browser");
			
			String URL=fileUtil.getDataFromPropertiesFile("url");
			//Launch Browser		
			driver=wblib.LaunchEmptyBrowser(driver, BROWSER);
			wblib.WaitForPageToLoad(driver, 20);
			wblib.MaximizeWindow(driver);		
			//navigate to url
			wblib.NavigateToWebPage(driver, URL);
			
			sdriver=driver;
		}
		
		@BeforeMethod (groups = {"SmokeTest","RegressionTest"})
		public void BeforeMethodImplementation() throws Throwable
		{
			System.out.println("Welcome.......");
		}
		
		@AfterMethod(groups = {"SmokeTest","RegressionTest"})
		public void AfterMethodImplementation()
		{
			System.out.println("Thankyou.......");
		}		
		
		@AfterClass(groups = {"SmokeTest","RegressionTest"})
		public void AfterClassImplementation() throws Throwable
		{
			wblib.quit(driver);
		}
		
		@AfterSuite(groups = {"SmokeTest","RegressionTest"})
		public void AfterSuiteImplementation()
		{
			System.out.println("Database disconnected.......");
		}
}
