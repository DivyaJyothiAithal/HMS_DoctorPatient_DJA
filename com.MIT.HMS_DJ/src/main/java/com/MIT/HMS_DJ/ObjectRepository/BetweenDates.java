package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetweenDates {
	WebDriver driver;

	public BetweenDates(WebDriver driver) {
	PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	@FindBy(id = "fromdate")
	private WebElement fromDate;

	@FindBy(id = "todate")
	private WebElement toDate;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	
	public void enterDates()
	{
		fromDate.sendKeys("20-03-2025");
		toDate.sendKeys("28-03-2025");
		submit.click();
	}
}
