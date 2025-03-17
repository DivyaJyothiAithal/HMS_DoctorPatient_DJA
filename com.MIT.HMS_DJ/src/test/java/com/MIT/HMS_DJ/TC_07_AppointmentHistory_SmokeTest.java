package com.MIT.HMS_DJ;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.AppointmentHistory;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;

public class TC_07_AppointmentHistory_SmokeTest extends BaseClassHMS {
	
	@Test(groups = "SmokeTest")
	public void AppointmentHistoryTest() throws Throwable
	{
		HomePage home=new HomePage(driver);
		AdminDashboard adDash=new AdminDashboard(driver);
		AppointmentHistory appHis=new AppointmentHistory(driver);
		
		//Login		
		home.Adminlogin();	
		
		adDash.AppointmentHistory();
		
		appHis.ValidateTitle();	
	}

}
