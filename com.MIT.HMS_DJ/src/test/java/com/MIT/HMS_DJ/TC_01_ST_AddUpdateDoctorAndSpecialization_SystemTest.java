package com.MIT.HMS_DJ;

import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.ObjectRepository.AddDoctor;
import com.MIT.HMS_DJ.ObjectRepository.AddDoctorSpecialization;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.EditDoctorDetails;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManageDoctors;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class TC_01_ST_AddUpdateDoctorAndSpecialization_SystemTest extends BaseClassHMS {
	public WebDriverUtility wdlib=new WebDriverUtility();

	public 	String doctorName;
	
	@Test(groups =  {"SmokeTest","RegressionTest"},priority=1)
	public void addDoctorTest()throws Throwable
	{
		 AdminDashboard adDash=new AdminDashboard(driver);
		 HomePage home=new HomePage(driver);
		 AddDoctor adDoctor=new AddDoctor(driver);
		 
		//Login		
		home.Adminlogin();
					
		//addDoctor
		adDash.addDoctor();						
		doctorName=adDoctor.addDoctorDetails();
		
		//handle alert		
		wdlib.handleAlert(driver);	
	}
	
	@Test(groups = "RegressionTest",priority=2)
	public void updateDoctorTest() throws Throwable
	{
		 AdminDashboard adDash=new AdminDashboard(driver);
		 ManageDoctors mgDoc=new ManageDoctors(driver);
		 EditDoctorDetails editDoctor=new EditDoctorDetails(driver);	
		 
		//Update					
		adDash.manageDoctors();						
		mgDoc.clickEditButton(doctorName);						
		editDoctor.updateDoctorSpecialization();
		editDoctor.verifyUpdation();
	}
	
	@Test(groups = "RegressionTest",priority=3)
	public void AddDocSpecializationTest() throws Throwable
	{
		 AdminDashboard adDash=new AdminDashboard(driver);
		 AddDoctorSpecialization addDocSp=new AddDoctorSpecialization(driver);
		 
		//AddDocSpecialization
		adDash.doctorSpecialization();		
		addDocSp.AddDoctorSpecializationdetails();
		addDocSp.ValidateAddDocSpecialization();
		adDash.logout();
	}

}
