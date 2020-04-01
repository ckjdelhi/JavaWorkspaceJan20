package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	WebDriver driver;
	public BaseTest(WebDriver driver) {
		this.driver=driver;
	}
	@BeforeSuite
	public void setUp() {
		driver.get("https://www.google.com/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Before first method");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
