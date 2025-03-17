package com.MIT.HMS_DJ;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.MIT.HMS_DJ.GenericUtility.ExcelUtility;
import com.MIT.HMS_DJ.GenericUtility.FileUtility;
import com.MIT.HMS_DJ.WebDriverUtility.JavaUtility;
import com.MIT.HMS_DJ.WebDriverUtility.WebDriverUtility;

public class TestTheTest {
	@Test
	public void sampleTest() throws Throwable
	{
		
		 FileUtility fileUtil=new FileUtility();
		 ExcelUtility excelLib=new ExcelUtility();
		 JavaUtility jlib=new JavaUtility();
		 WebDriverUtility wblib=new WebDriverUtility();
		
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
			driver.get("http://49.249.28.218:8081/AppServer/Hospital_Doctor_Patient_Management_System/");
			
			driver.findElement(By.linkText("Logins")).click();//logins
			
			driver.findElement(By.xpath("(//button[@class='btn btn-success btn-sm'])[3]")).click();//Admin login
			
			Set<String> wid = driver.getWindowHandles();
			
			for (String string : wid) {
				driver.switchTo().window(string);
			}
			
			driver.findElement(By.name("username")).sendKeys("admin");//username
			driver.findElement(By.name("password")).sendKeys("Test@12345");//password
			driver.findElement(By.name("submit")).click();//submit
			
		 
		 
		 Thread.sleep(3000);
			driver.quit();

	}

}
