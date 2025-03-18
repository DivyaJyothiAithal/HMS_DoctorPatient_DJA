package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;

import net.bytebuddy.asm.Advice.Argument;

public class ManageUsers {
	JavaUtility jlib=new JavaUtility();
	ExcelUtility elib=new ExcelUtility();
	
	WebDriver driver;
	public ManageUsers(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath = "(//tr[2]//i)[1]")
	private WebElement deleteIcon;
	
	
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}
	
	public void validateUserPage()
	{
		Assert.assertEquals(driver.getTitle(), "Admin | Manage Users","Wrong Page !!!!!!!!!!!");
	}
	
	public void deleteEntry()
	{
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		jse.executeScript(argument[1].click(), deleteIcon)
		deleteIcon.click();
	}
	
	public void validateDelete()
	{
		String messag=driver.findElement(By.xpath("//p[contains(text(),'data deleted !!')]")).getText().trim();
		Assert.assertEquals(messag, "data deleted !!","delete Mesage not matching !!!!!!!!");
	}
}
