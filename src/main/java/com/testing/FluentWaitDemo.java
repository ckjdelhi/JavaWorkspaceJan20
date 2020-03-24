package com.testing;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.drivers.DriverFactory;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getBrowser("chrome");
		driver.get("https://www.google.com/");
		
		/*Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
		.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText("How Search works"));
			}
		});*/
		
		new WebDriverWait(driver, 10)
		.pollingEvery(2, TimeUnit.SECONDS)
		.withTimeout(10, TimeUnit.SECONDS)
		.until(ExpectedConditions.invisibilityOf(driver.findElement(By.linkText("How Search works"))));

	}

}
