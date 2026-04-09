package com.dataprovider;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDP {
	
	WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Laptop\\Desktop\\Chrome-exe's\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before Suite ----- Open Browser");
	}
	
	@BeforeTest
	@Parameters({"url"})
	public void enterURL(String ur)
	{
		driver.get(ur);
		System.out.println("Before Test ------ Open URL");
	}
	
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
		System.out.println("Before Class ---- maximize the window");
	}
	
	@BeforeMethod
	public void dbConnect()
	{
		System.out.println("Before Method ------ DB Connection");
	}
	
	@Test(dataProvider="getData")
	public void mercryTourLogin(String un, String ps) throws InterruptedException
	{
		System.out.println("Actual Test Method ---- Mercury Tours Sign-ON: ");
		driver.findElement(By.name("userName")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(ps);
		driver.findElement(By.name("submit")).click();
		System.out.println("this is test method");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.name("userName")).clear();
	}
	
	@AfterMethod
	public void captureScreenshot() throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Laptop\\Desktop\\CJC Study Material\\CaptureScreenshot\\mercurytourslogin.jpeg"));
		System.out.println("After Method --- Screenshot capture is done, please check the folder");
	}
	
	@AfterClass
	public void dbClose()
	{
		System.out.println("After Class ---- DB Close");
	}
	
	@AfterTest
	public void delCookies()
	{
		System.out.println("After Test --- Delete Cookies");
	}
	
	@AfterSuite
	public void browserClose()
	{
		System.out.println("After Suite -- Browser Close");
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"Ashwini","aaaa"},
			{"Nishant","nnnn"},
			{"Kavita","kkkk"}
				};
		
	}
}
