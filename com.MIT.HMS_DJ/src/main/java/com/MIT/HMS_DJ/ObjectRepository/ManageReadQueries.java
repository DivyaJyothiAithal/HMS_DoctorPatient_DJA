package com.MIT.HMS_DJ.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class ManageReadQueries {
	WebDriver driver;
	WebDriverUtility wdlib=new WebDriverUtility();
	
	public ManageReadQueries(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy()
	private WebElement viewQuery;
	
	public void viewReadQueries(String name)
	{
		WebElement viewQueryFile=driver.findElement(By.xpath("//td[text()='"+name+"']/..//a//i[@class='fa fa-file']"));
		//viewQueryFile.click();
		wdlib.javascriptClick(driver, viewQueryFile);
	}

}
