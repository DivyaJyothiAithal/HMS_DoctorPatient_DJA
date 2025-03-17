package com.MIT.HMS_DJ.ObjectRepository;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;

public class ViewPatients {
	WebDriver driver;
	ExcelUtility elib=new ExcelUtility();
	
	public ViewPatients(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//tr[3]//a")
	private WebElement viewIcon;
	
	public void viewIconClick() throws Throwable
	{
		String data=elib.getCellData("Patients", 5, 0);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element=driver.findElement(By.xpath("//td[text()='"+data+"']/..//i"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
		//element.click();
	}

}
