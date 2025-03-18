package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;

public class AddDoctor {
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	
	WebDriver driver;
	public AddDoctor(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement DoctorspeclSelect;
	
	@FindBy(name = "docname")
	private WebElement doctorName;
	
	@FindBy(name = "clinicaddress")
	private WebElement clinicaddress;
	
	@FindBy(name = "docfees")
	private WebElement docfees;
	
	@FindBy(name = "doccontact")
	private WebElement doccontact;
	
	@FindBy(name = "docemail")
	private WebElement docemail;
	
	@FindBy(name = "npass")
	private WebElement npass;
	
	@FindBy(name = "cfpass")
	private WebElement cfpass;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	
	public String addDoctorDetails()
	{
		Select sel = new Select(DoctorspeclSelect);
		sel.selectByIndex(1);
		String DocName="DJ"+jlib.getRandomNumber();

		doctorName.sendKeys(DocName);

		clinicaddress.sendKeys("DJ 1st main 3rd cross RRNagar");

		docfees.sendKeys("1000");

		doccontact.sendKeys("986766643"+jlib.getRandomNumber());
		
		docemail.sendKeys("dj"+jlib.getRandomNumber()+"@ggdhdk.com");
		
		npass.sendKeys("dj@ggdhdk.com");
		
		cfpass.sendKeys("dj@ggdhdk.com");
		
		submit.click();
		
		return DocName;
		
	}
	
	public void addDoctorDetails(String DocName )
	{
		Select sel = new Select(DoctorspeclSelect);
		sel.selectByIndex(1);
		
		doctorName.sendKeys(DocName);

		clinicaddress.sendKeys("DJ 1st main 3rd cross RRNagar");

		docfees.sendKeys("1000");

		doccontact.sendKeys("986766643"+jlib.getRandomNumber());
		
		docemail.sendKeys("dj"+jlib.getRandomNumber()+"@ggdhdk.com");
		
		npass.sendKeys("dj@ggdhdk.com");
		
		cfpass.sendKeys("dj@ggdhdk.com");
		
		submit.click();
		
	}

	public String doctorName() throws Throwable {
		return (elib.getCellData("Doctor", 1, 0)+jlib.getRandomNumber());	
	}

	public JavaUtility getJlib() {
		return jlib;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getDoctorspeclSelect() {
		return DoctorspeclSelect;
	}


	public WebElement getDoctorName() {
		return doctorName;
	}


	public WebElement getClinicaddress() {
		return clinicaddress;
	}


	public WebElement getDocfees() {
		return docfees;
	}


	public WebElement getDoccontact() {
		return doccontact;
	}


	public WebElement getDocemail() {
		return docemail;
	}


	public WebElement getNpass() {
		return npass;
	}


	public WebElement getCfpass() {
		return cfpass;
	}


	public WebElement getSubmit() {
		return submit;
	}
	
	
	
}
