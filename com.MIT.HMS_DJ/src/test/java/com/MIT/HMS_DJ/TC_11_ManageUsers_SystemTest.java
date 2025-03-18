package com.MIT.HMS_DJ;

import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.ObjectRepository.AddDoctor;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManageUsers;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class TC_11_ManageUsers_SystemTest  extends BaseClassHMS {
	public WebDriverUtility wdlib=new WebDriverUtility();
	
	
	@Test(groups =  {"SmokeTest","RegressionTest"},priority=1)
	public void addDoctorTest()throws Throwable
	{
		 AdminDashboard adDash=new AdminDashboard(driver);
		 HomePage home=new HomePage(driver);
		 ManageUsers mgUser=new ManageUsers(driver);
		 
		//Login		
		home.Adminlogin();
		
		adDash.manageUsers();
		mgUser.validateUserPage();
		mgUser.deleteEntry();
		
		wdlib.handleAlert(driver);
		
		mgUser.validateDelete();
		
		//logout
		adDash.logout();
		
	}	
}
