package com.MIT.HMS_DJ;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.GenericUtility.FileUtility;
import com.MIT.HMS_DJ.ObjectRepository.AddDoctor;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManagePatients;
import com.MIT.HMS_DJ.ObjectRepository.ViewPatients;

public class TC_06_ManagePatients_SmokeTest extends BaseClassHMS  {
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	
	
	@Test(groups = "SmokeTest")
	public void managePatientsSmoke() throws Throwable
	{
		System.out.println("ManagePatientsSmoke entered ===================");
		HomePage home=new HomePage(driver);
		AdminDashboard adDash=new AdminDashboard(driver);
		ViewPatients viewPat=new ViewPatients(driver);
		ManagePatients manPat=new ManagePatients(driver);
		
		//Login		
		home.Adminlogin();	

		//viewIconClick
		adDash.managePatients();
		viewPat.viewIconClick();
				
		//validate Page
		manPat.validate();

	}	
}
