package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManageQueryDetails {
	WebDriver driver;
	
public ManageQueryDetails(WebDriver driver) {
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

@FindBy(xpath = "//th[text()='Admin Remark']/..//td")
private WebElement remark;

	public void validateRemark(String adminRemark)
	{
		String adRemark=remark.getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(adRemark,adminRemark,"Admin Remark not updated !!!" );
	}
}
