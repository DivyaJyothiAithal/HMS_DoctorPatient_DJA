package com.MIT.HMS_DJ.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class WebDriverUtility {

	public void WaitForPageToLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void MaximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public WebDriver LaunchEmptyBrowser(WebDriver driver,String BROWSER)
	{
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			 driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			 driver=new FirefoxDriver();
		}
		else {
			 driver=new ChromeDriver();
		}
		return driver;
			
	}
	
	public void handleAlert(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void javascriptClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void NavigateToWebPage(WebDriver driver,String URL)
	{
		driver.get(URL);
	}
	
	public void close(WebDriver driver)
	{
		driver.close();
	}
	
	public void quit(WebDriver driver) throws Throwable
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	public String getTitle(WebDriver driver)
	{
		return(driver.getTitle());
	}
	public void MouseOverElement(WebDriver driver,WebElement element)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void SwitchToWindowBasedOnURL(WebDriver driver, String URL)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter=windows.iterator();
		String nextWindow;
		String actUrl;
		while(iter.hasNext())
		{
			 nextWindow= iter.next();
			driver.switchTo().window(nextWindow);
			
			actUrl=driver.getCurrentUrl();
			if(actUrl.contains(URL))
			{
				//driver.close();
				break;
			}
		}
		
	}
	public void SwitchToWindowBasedOnTitle(WebDriver driver, String title)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter=windows.iterator();
		String nextWindow;
		String actUrl;
		while(iter.hasNext())
		{
			nextWindow= iter.next();
			driver.switchTo().window(nextWindow);
			
			actUrl=driver.getTitle();
			if(actUrl.contains(title))
			{
				//driver.close();
				break;
			}
		}
	}
	
	public void SelectFromDropDown(WebElement element,String Value)
	{
		Select selectobj=new Select(element);	
		selectobj.selectByValue(Value);
		
//		if(selectobj.getFirstSelectedOption().getText().trim().contentEquals(Value))
//			System.out.println(element+ " DropDown is working=======Pass");
//		else 
//			System.out.println(element+ " DropDown is not working=======Fail");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(selectobj.getFirstSelectedOption().getText().trim(), Value, "DropDown is not working=======Fail");
	}

	
	public void SelectFromDropDown(WebElement element,int index)
	{
		Select selectobj=new Select(element);	
		selectobj.selectByIndex(index);
	}
	
	public void SelectFromDropDown(WebElement element,String text,boolean variable)
	{
		Select selectobj=new Select(element);	
		selectobj.selectByVisibleText(text);
		
//		if(selectobj.getFirstSelectedOption().getText().contentEquals(text))
//			System.out.println(element+" DropDown is working=======Pass");
//		else 
//			System.out.println(element+" DropDown is not working=======Fail");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(selectobj.getFirstSelectedOption().getText(), text, "DropDown is not working=======Fail");
	}
	
}
