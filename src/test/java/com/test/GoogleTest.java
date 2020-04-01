package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.drivers.DriverFactory;

public class GoogleTest extends BaseTest {
	static WebDriver driver = DriverFactory.getBrowser("chrome");
	public GoogleTest() {
		super(driver);
	}
	
  @Test
  public void canOpenGoogleURL() {
	String title= driver.getTitle();
	Assert.assertEquals(title, "Google");
  }
  
  @Test
  public void canSearchSeleniumHQ() {
	  WebElement findElement = driver.findElement(By.xpath("//*[@name='q']"));
	findElement.sendKeys("SeleniumHQ");
	findElement.submit();
	Assert.assertEquals(driver.getTitle().toLowerCase(), "seleniumhq - Google Search".toLowerCase());
  }
}
