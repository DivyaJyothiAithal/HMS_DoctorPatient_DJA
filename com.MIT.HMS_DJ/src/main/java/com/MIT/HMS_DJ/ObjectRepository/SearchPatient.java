package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPatient {
	
	WebDriver driver;

	public SearchPatient(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="searchdata")
	private WebElement searchBox;
	
	@FindBy(id="submit")
	private WebElement search;
	
	
	public void searchPatients()
	{
		searchBox.sendKeys("ss");
		search.click();
	}

}
