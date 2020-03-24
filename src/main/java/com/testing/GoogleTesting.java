package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.drivers.DriverFactory;

public class GoogleTesting {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandan\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		WebDriver driver = DriverFactory.getBrowser("chrome");
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.google.com/");
		//driver.findElement(By.xpath("//*[@name='q']")).sendKeys("automation testing");
		
		By linkText = By.linkText("How Search works");
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkText));
		driver.findElement(linkText).click();
	}

}
