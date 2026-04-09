package com.xml1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebShop {
	
WebDriver driver;
	
	@BeforeSuite(groups="newsletter")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Laptop\\Desktop\\Chrome-exe's\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before Suite ----- Open Browser");
	}
	
	@BeforeTest(groups="newsletter")
	@Parameters({"url"})
    public void enterURL(String url)
	{
		driver.get(url);
		System.out.println("Before Test ------ Open URL's");
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
	
	@Test
	@Parameters({"firstname","lastname","email","password","confirmps"})
	public void demoWebShopRegister(String fn, String ln, String email, String ps, String cps)
	{
		System.out.println("Actual Test Method ---- Demo Web Shop Register: ");
		driver.findElement(By.className("forcheckbox")).click();
		driver.findElement(By.name("FirstName")).sendKeys(fn);
		driver.findElement(By.name("LastName")).sendKeys(ln);	
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(ps);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(cps);
		driver.findElement(By.name("register-button")).click();	
	}
	
	@Test(groups="newsletter")
	@Parameters({"subscribe"})
	public void subscribe(String subs)
	{
		driver.findElement(By.xpath("//*[@id=\"newsletter-email\"]")).sendKeys(subs);
		System.out.println("Test ---- Subscribe");
	}

	@AfterMethod(groups="newsletter")
	public void captureScreenshot() throws IOException
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Laptop\\Desktop\\CJC Study Material\\CaptureScreenshot\\WebShopDemo.jpeg"));
		System.out.println("After Method --- Screenshot capture is done, please check the folder CaptureScreenshot");
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
	
	@AfterSuite(groups="newsletter")
	public void browserClose()
	{
		System.out.println("After Suite -- Browser Close");
		driver.close();
	}

}
