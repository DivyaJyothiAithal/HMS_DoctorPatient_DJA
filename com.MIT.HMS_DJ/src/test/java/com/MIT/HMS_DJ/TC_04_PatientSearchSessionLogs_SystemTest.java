package com.MIT.HMS_DJ;

import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.AppointmentHistory;
import com.MIT.HMS_DJ.ObjectRepository.BetweenDates;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManagePatients;
import com.MIT.HMS_DJ.ObjectRepository.ViewPatients;

public class TC_04_PatientSearchSessionLogs_SystemTest extends BaseClassHMS{

	
	@Test(groups = "RegressionTest")
	public void Patient_SystemTest() throws Throwable
	{
		HomePage home= new HomePage(driver);
		AdminDashboard adDash=new AdminDashboard(driver);

		//Login
		home.Adminlogin();	
		
		//viewPatientHistory
		adDash.PatientHistory();
	}
	
	@Test(groups = "RegressionTest")
	public void SearchDoctorSessionLogs_SystemTest() throws Throwable
	{
		AdminDashboard adDash=new AdminDashboard(driver);
	
		//View DoctorSessionLogs
		adDash.DoctorSessionLogs();
	}
	
	@Test(groups = "RegressionTest")
	public void SearchUserSessionLogs_SystemTest() throws Throwable
	{
		AdminDashboard adDash=new AdminDashboard(driver);
		//View UserSessionLogs
		adDash.UserSessionLogs();		
	}	
}
