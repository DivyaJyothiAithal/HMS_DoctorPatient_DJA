package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.GenericUtility.FileUtility;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class QueryDetails {

	WebDriver driver;
	public FileUtility fileUtil=new FileUtility();
	public ExcelUtility excelLib=new ExcelUtility();
	public WebDriverUtility wdlib=new WebDriverUtility();
	
	public QueryDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name = "adminremark")
	private WebElement adminRemark;
	
	@FindBy(name = "update")
	private WebElement update;
	
	public void addRemark() throws Throwable
	{
		adminRemark.sendKeys(excelLib.getCellData("ContactUs", 1, 0));
		update.click();
		//handle Alert
		wdlib.handleAlert(driver);	
	}
	
}
