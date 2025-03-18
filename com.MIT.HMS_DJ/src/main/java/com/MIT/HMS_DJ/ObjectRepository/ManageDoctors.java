package com.MIT.HMS_DJ.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class ManageDoctors {
	
	WebDriverUtility wdlib=new WebDriverUtility();
	WebDriver driver;
	
	public ManageDoctors(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void validateAddDoctor(String doctorName)
	{
		List<WebElement> DoctorNames = driver.findElements(By.xpath("//table[@id='sample-table-1']//tr//td[3]"));
		
		boolean flag=false;
		for (WebElement webElement : DoctorNames) {
			if(webElement.getText().equalsIgnoreCase(doctorName))
			{
				flag=true;
				break;
			}
		}
		 Assert.assertTrue(flag,"AddDoctorIntegration Failed");
	}
	
	public void validateTitle()
	{
		String title = wdlib.getTitle(driver);
		Assert.assertEquals(title, "Admin | Manage Doctors","Adding Doctor Failed ========");
	}
	
	public void clickEditButton(String doctorName)
	{
		WebElement element=driver.findElement(By.xpath("//td[text()='"+doctorName+"']/..//a//i[@class='fa fa-pencil']"));
		
	//	WebElement element = driver.findElement(By.xpath("//i[@class='fa fa-pencil']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void clickDeleteButton(String doctorName)
	{
		WebElement element=driver.findElement(By.xpath("//td[text()='"+doctorName+"']/..//a//i[@class='fa fa-times fa fa-white']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void validateUpdateDoctor(String doctorName)
	{
		String specialization=driver.findElement(By.xpath("//td[text()='"+doctorName+"']/..//td[2]")).getText();
		Assert.assertEquals(specialization, "Gynecologist/Obstetrician");
	}
	
	public void verifyDeleteMsg()
	{
		String msg=driver.findElement(By.xpath("//p[contains(text(),'data deleted !!')]")).getText();
		Assert.assertEquals(msg.trim(), "data deleted !!");
	}
	
	public void ValidateDelete(String doctorName)
	{		
		try {
			WebElement doctor=driver.findElement(By.xpath("//td[text()='"+doctorName+"']"));
			System.out.println("Doctor NOT deleted !!!         ");
			Assert.fail();
					
		} catch (Exception e) {
			System.out.println("Doctor Successfully deleted !!!         ");
		}
	}
/*
	//Dynamic ...use in scripts
	//td[text()='Guru_6219']/..//i[@class='fa fa-pencil']
*/
	
	
}
