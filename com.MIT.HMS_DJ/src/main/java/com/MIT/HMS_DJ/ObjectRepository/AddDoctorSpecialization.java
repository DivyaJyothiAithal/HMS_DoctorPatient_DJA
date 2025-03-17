package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;

public class AddDoctorSpecialization {
	JavaUtility jlib=new JavaUtility();
	WebDriver driver;
	public AddDoctorSpecialization(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name = "doctorspecilization")
	private WebElement doctorspecialization;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	@FindBy(xpath = "//p[contains(text(),'Doctor Specialization')]")
	private WebElement successMsg;
	
	public void AddDoctorSpecializationdetails()
	{
		doctorspecialization.sendKeys("DJ_Specialization_"+jlib.getRandomNumber());		
		submit.click();
		
	}
	
	public void ValidateAddDocSpecialization()
	{
		Assert.assertEquals(successMsg.getText().trim(),"Doctor Specialization added successfully !!" );
	}

}
