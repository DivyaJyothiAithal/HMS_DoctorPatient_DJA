package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;

public class EditDoctorDetails {
	JavaUtility jlib=new JavaUtility();
	WebDriver driver;
	
	public EditDoctorDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name = "Doctorspecialization")
	private WebElement Doctorspecialization;
	
	@FindBy(name = "docfees")
	private WebElement docfees;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	public void updateDoctorSpecialization() throws Throwable
	{
		Select sel = new Select(Doctorspecialization);
		sel.selectByValue("Obstetrics and Gynecology");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);
		//submit.click();
		

	}
	
	
	public void updateDoctorDetails()
	{
		docfees.clear();
		docfees.sendKeys("9876567"+jlib.getRandomNumber());		
		submit.click();
		
	}
	
	public void verifyUpdation()
	{
		WebElement mssg=driver.findElement(By.xpath("(//h5)[1]"));
		SoftAssert sas=new SoftAssert();
		sas.assertEquals(mssg.getText().trim(), "Doctor Details updated Successfully");
	}
	
}
