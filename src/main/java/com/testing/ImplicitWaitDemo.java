package com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.drivers.DriverFactory;

public class ImplicitWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("automation testing");

	}

}
