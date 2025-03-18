package com.MIT.HMS_DJ.ObjectRepository;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;

public class HomePage {
	WebDriver driver;
	ExcelUtility elib=new ExcelUtility();
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(linkText = "Home")
	private WebElement home;
	
	@FindBy(linkText = "Services")
	private WebElement services;
	
	@FindBy(linkText = "About Us")
	private WebElement AboutUs;
	
	@FindBy(linkText = "Gallery")
	private WebElement Gallery;
	
	@FindBy(linkText = "Contact Us")
	private WebElement ContactUs;
	
	@FindBy(linkText = "Logins")
	private WebElement Logins;
	
	@FindBy(linkText = "Book an Appointment")
	private WebElement BookAnAppointment;
	
	@FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[3]")
	private WebElement AdminLogin;
	
	@FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[2]")
	private WebElement DoctorsLogin;
	
	@FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[1]")
	private WebElement PatientLogin;
	
	@FindBy(name = "fullname")
	private WebElement name;
	
	@FindBy(name = "emailid")
	private WebElement email;
	
	@FindBy(name = "mobileno")
	private WebElement number;
	
	@FindBy(name = "description")
	private WebElement message;
	
	@FindBy(name = "submit")
	private WebElement sendMessage;
	
	
	
//	@FindBy(linkText = "Sign Out")
//	private WebElement signOut;
	
	
	public void Adminlogin() throws Throwable
	{
		Logins.click();
		AdminLogin.click();
		
		Set<String> wid = driver.getWindowHandles();
		
		for (String string : wid) {
			driver.switchTo().window(string);
		}
		
		AdminLoginPage adLog=new AdminLoginPage(driver);
		adLog.login();
	}
	
	public String addContactMessage() throws Throwable
	{
		String contactName=elib.getCellData("Home", 3, 1);
		name.sendKeys(contactName);
		email.sendKeys(elib.getCellData("Home", 3, 2));
		number.sendKeys(elib.getCellData("Home", 3, 3));
		message.sendKeys(elib.getCellData("Home", 3, 4));
		
		sendMessage.click();
		
		//handle alert
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.alertIsPresent()); // Wait until alert is present
          driver.switchTo().alert().accept();;
          // Accept the alert
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present on the page.");
            e.printStackTrace();
        }

		
		return contactName;
		
	}
	
	public WebElement getAdminLogin() {
		return AdminLogin;
	}

	public WebElement getDoctorsLogin() {
		return DoctorsLogin;
	}

	public WebElement getPatientLogin() {
		return PatientLogin;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getServices() {
		return services;
	}

	public WebElement getAboutUs() {
		return AboutUs;
	}

	public WebElement getGallery() {
		return Gallery;
	}

	public WebElement getContactUs() {
		return ContactUs;
	}

	public WebElement getLogins() {
		return Logins;
	}

	public WebElement getBookAnAppointment() {
		return BookAnAppointment;
	}

	public void clickHomeLink()
	{
		home.click();
	}
	
	public void clickServicesLink()
	{
		services.click();
	}
	
	public void clickAboutUsLink()
	{
		AboutUs.click();
	}
	
	public void clickGalleryLink()
	{
		Gallery.click();
	}
	
	public void clickContactUsLink()
	{
		ContactUs.click();
	}
	
	public void clickLoginsLink()
	{
		Logins.click();
	}
	public void clickAdminLoginLink()
	{
		AdminLogin.click();
	}
	
	public void clickDoctorLoginLink()
	{
		DoctorsLogin.click();
	}
	
	public void clickPatientLoginLink()
	{
		PatientLogin.click();
	}
	
	public void clickBookAnAppointmentLink()
	{
		BookAnAppointment.click();
	}

}
