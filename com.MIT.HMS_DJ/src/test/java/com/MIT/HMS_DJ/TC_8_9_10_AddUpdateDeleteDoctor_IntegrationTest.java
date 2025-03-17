package com.MIT.HMS_DJ;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.ObjectRepository.AddDoctor;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.EditDoctorDetails;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManageDoctors;
import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class TC_8_9_10_AddUpdateDeleteDoctor_IntegrationTest extends BaseClassHMS
{
	WebDriverUtility wdlib=new WebDriverUtility();
	
	String doctorName;
	
	@Test(priority = 1)
	public void addDoctorTest() throws Throwable
	{		
		AdminDashboard adDash=new AdminDashboard(driver);
		HomePage home=new HomePage(driver);
		AddDoctor adDoctor=new AddDoctor(driver);
		ManageDoctors mgDoc=new ManageDoctors(driver);
		
		//Login		
		home.Adminlogin();
		
		adDash.addDoctor();		
		
		doctorName=	adDoctor.doctorName();
	
		adDoctor.addDoctorDetails(doctorName);		
		//handle alert		
		wdlib.handleAlert(driver);	
		
		//validation of Integration	
		mgDoc.validateTitle();		
		mgDoc.validateAddDoctor(doctorName);
	}
	
	@Test(dependsOnMethods = "addDoctorTest",priority = 2)
	public void UpdateDoctorTest() throws Throwable
	{	
		AdminDashboard adDash=new AdminDashboard(driver);
		ManageDoctors mgDoc=new ManageDoctors(driver);
		EditDoctorDetails editDoctor=new EditDoctorDetails(driver);
		
		adDash.manageDoctors();		
		
		mgDoc.clickEditButton(doctorName);		
		
		editDoctor.updateDoctorSpecialization();
		editDoctor.verifyUpdation();
		
		//validation of Integration	
		adDash.manageDoctors();
		mgDoc.validateUpdateDoctor(doctorName);		
	}
	
	@Test(dependsOnMethods = "addDoctorTest",priority = 3)
	public void DeleteDoctorTest() throws Throwable
	{		
		AdminDashboard adDash=new AdminDashboard(driver);
		ManageDoctors mgDoc=new ManageDoctors(driver);
		
		adDash.manageDoctors();		
		
		mgDoc.clickDeleteButton(doctorName);
		
		wblib.handleAlert(driver);
		
		//verify
		mgDoc.verifyDeleteMsg();
		
		//validation of Integration	
		adDash.manageDoctors();
		//verify doctor deletion
		mgDoc.ValidateDelete(doctorName);		
	}	
}
