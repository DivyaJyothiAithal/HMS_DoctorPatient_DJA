package com.MIT.HMS_DJ;

import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.GenericUtility.FileUtility;
import com.MIT.HMS_DJ.ObjectRepository.AddDoctor;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.AdminLoginPage;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class TC_05_AddDoctor_SmokeTest  extends BaseClassHMS {
	FileUtility flib=new FileUtility();
	
	@Test(groups = "SmokeTest")
	public void addDoctorSmoke() throws Throwable
	{
		System.out.println("addDoctorSmoke entered ===================");
		HomePage home=new HomePage(driver);
		AdminDashboard adDash=new AdminDashboard(driver);
		AddDoctor adDoctor=new AddDoctor(driver);
		WebDriverUtility wdlib=new WebDriverUtility();
		
		//Login		
		home.Adminlogin();		
		
    	//addDoctor
		adDash.addDoctor();
		adDoctor.addDoctorDetails();
		
		//handle alert	
		wdlib.handleAlert(driver);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Admin | Manage Doctors","Adding Doctor Failed ========");	
	}
	
	
	

}
