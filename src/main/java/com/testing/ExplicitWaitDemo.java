package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.drivers.DriverFactory;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getBrowser("chrome");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.google.com/");

		/*By linkText = By.linkText("How Search works");
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkText));
		driver.findElement(linkText).click();*/
		
		WebElement linkText = driver.findElement(By.linkText("How Search works"));
		wait.until(ExpectedConditions.invisibilityOf(linkText));
		linkText.click();

	}

}
