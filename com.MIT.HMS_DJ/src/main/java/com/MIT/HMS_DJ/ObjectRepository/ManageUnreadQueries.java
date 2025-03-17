package com.MIT.HMS_DJ.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MIT.HMS_DJ.GenericUtility.FileUtility;

public class ManageUnreadQueries {
	
	WebDriver driver;
	public FileUtility fileUtil=new FileUtility();
	
	public ManageUnreadQueries(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void viewUnreadQuery(String name)
	{
		WebElement viewQueryFile=driver.findElement(By.xpath("//td[text()='"+name+"']/..//a//i[@class='fa fa-file']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(viewQueryFile)); 
//		  viewQueryFile.click();
				
	       JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView(true);", viewQueryFile);
           viewQueryFile.click();
	}
	
}
