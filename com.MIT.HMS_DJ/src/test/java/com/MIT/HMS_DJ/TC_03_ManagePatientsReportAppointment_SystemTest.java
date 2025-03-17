package com.MIT.HMS_DJ;

import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.AppointmentHistory;
import com.MIT.HMS_DJ.ObjectRepository.BetweenDates;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManagePatients;
import com.MIT.HMS_DJ.ObjectRepository.ManageReadQueries;
import com.MIT.HMS_DJ.ObjectRepository.ManageUnreadQueries;
import com.MIT.HMS_DJ.ObjectRepository.QueryDetails;
import com.MIT.HMS_DJ.ObjectRepository.ViewPatients;

public class TC_03_ManagePatientsReportAppointment_SystemTest extends BaseClassHMS {
	
	@Test(groups = {"SmokeTest","RegressionTest"})
	public void ManagePatientssTest() throws Throwable
	{	
		 HomePage home= new HomePage(driver);
		 AdminDashboard adDash=new AdminDashboard(driver);
		 ViewPatients viewPat=new ViewPatients(driver);
		 ManagePatients mgPatient=new ManagePatients(driver);
		
		//Login
		home.Adminlogin();	
		
		//ManagePatients
		adDash.managePatients();
		viewPat.viewIconClick();		
		mgPatient.validateTitle();
	}
	
	@Test(groups = "RegressionTest")
	public void ReportsTest() throws Throwable
	{		
		 AdminDashboard adDash=new AdminDashboard(driver);
		 BetweenDates btwreports=new BetweenDates(driver);
		 ViewPatients viewPat=new ViewPatients(driver);
		 ManagePatients mgPatient=new ManagePatients(driver);
		
		//Report
		adDash.reports();
		btwreports.enterDates();
		viewPat.viewIconClick();		
		mgPatient.validateTitle();
	}
	
	@Test(groups = {"SmokeTest","RegressionTest"})
	public void AppointmentHistoryTest() throws Throwable
	{
		 AdminDashboard adDash=new AdminDashboard(driver);
		 AppointmentHistory apHistory=new AppointmentHistory(driver);
		 
		//AppointmentHistory
		adDash.AppointmentHistory();
		apHistory.confirmAppointment();
	}
}
	
