package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MIT.HMS_DJ.GenericUtility.FileUtility;

public class AdminLoginPage {
	
	WebDriver driver;
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(name = "username")
	private WebElement username;
	
	public WebElement getUsername() {
		return username;
	}

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(name = "submit")
	private WebElement login;
	
	@FindBy(linkText = "Bacto Home Page")
	private WebElement backToHome;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getBackToHome() {
		return backToHome;
	}

	public void login() throws Throwable
	{
		FileUtility fileUtil=new FileUtility();
		String USERNAME=fileUtil.getDataFromPropertiesFile("username");
		String PASSWORD=fileUtil.getDataFromPropertiesFile("password");
		
		System.out.println("login method of AdminLoginPage called ===================");
		//Thread.sleep(5000);
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		login.click();
	}
	
	public void clickBackToHomeLink()
	{
		backToHome.click();
	}
	
	
}
