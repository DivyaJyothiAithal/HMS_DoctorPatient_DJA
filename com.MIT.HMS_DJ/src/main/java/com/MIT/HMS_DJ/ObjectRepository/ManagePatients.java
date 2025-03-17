package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManagePatients {
	WebDriver driver;

	public ManagePatients(WebDriver driver) {
	PageFactory.initElements(driver,this);
		this.driver = driver;
	}

	public void validateTitle()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Admin | View Patients","Wrong !!! , not ViewPatients");
	}
	
	public void validate()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Doctor | Manage Patients","Managing patients Failed ========");
	}

}
