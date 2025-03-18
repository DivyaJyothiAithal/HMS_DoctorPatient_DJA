package com.MIT.HMS_DJ;

import org.testng.annotations.Test;

import com.MIT.HMS_DJ.BaseTest.BaseClassHMS;
import com.MIT.HMS_DJ.ObjectRepository.AdminDashboard;
import com.MIT.HMS_DJ.ObjectRepository.HomePage;
import com.MIT.HMS_DJ.ObjectRepository.ManageReadQueries;
import com.MIT.HMS_DJ.ObjectRepository.ManageUnreadQueries;
import com.MIT.HMS_DJ.ObjectRepository.QueryDetails;

public class TC_02_ContactUs_SystemTest extends BaseClassHMS {
	String name;

	@Test(groups = "RegressionTest",priority=1)
	public void addContactQueryTest() throws Throwable
	{
		AdminDashboard adDash=new AdminDashboard(driver);
		HomePage home= new HomePage(driver);

		//AddContactQuery	
		home.clickContactUsLink();		
		 name=home.addContactMessage();
		 
		//logout
		adDash.logout();
	}
	
	@Test(groups = "RegressionTest",priority=2)
	public void unreadQueryTest() throws Throwable
	{
		HomePage home= new HomePage(driver);		
		AdminDashboard adDash=new AdminDashboard(driver);
		ManageUnreadQueries unreadQuery=new ManageUnreadQueries(driver);
		QueryDetails queryDet=new QueryDetails(driver);
		ManageReadQueries readQuery=new ManageReadQueries(driver);
		
		home.Adminlogin();		
		
		//ContactUsQuerries/unreadQuery
		adDash.unreadQuery();		
		unreadQuery.viewUnreadQuery(name);		
		queryDet.addRemark();		
		readQuery.viewReadQueries(name);		
		//logout
		adDash.logout();
	}
	
	
	@Test(groups = "RegressionTest",priority=3)
	public void readQueryTest() throws Throwable
	{
		AdminDashboard adDash=new AdminDashboard(driver);
		ManageReadQueries readQuery=new ManageReadQueries(driver);
		//ContactUsQuerries/readQuery
		adDash.readQuery();
		readQuery.viewReadQueries(name);
		
		//logout
		adDash.logout();
	}
}
