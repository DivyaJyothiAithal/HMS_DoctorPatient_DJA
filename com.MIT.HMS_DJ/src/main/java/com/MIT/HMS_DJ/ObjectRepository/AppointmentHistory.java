package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AppointmentHistory {
	WebDriver driver;

	public AppointmentHistory(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//tr[2]//td[8]")
	private WebElement status;
	
	public void confirmAppointment()
	{
		String currentStatus=status.getText();
		
		SoftAssert as=new SoftAssert();
		as.assertEquals(currentStatus, "Active","#####Status not active#####");
		as.assertAll();
	}
	
	public void ValidateTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Patients | Appointment History","Viewing Patients | Appointment History Failed ========");
	}

}
