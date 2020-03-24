package com.guru99.com.basic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.drivers.DriverFactory;

public class MainTestCases {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = DriverFactory.getBrowser("chrome");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/index.php");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("uid")).sendKeys("mgr123");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("mgr!23");
		driver.findElement(By.name("btnLogin")).click();
		/*Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();*/
		System.out.println(driver.getTitle());
		//driver.findElement(By.linkText("New Customer")).click();
		driver.findElement(By.cssSelector(".menusubnav > li:nth-of-type(2) > a")).click();
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("scroll(0,400)", "");
		
		driver.findElement(By.name("name")).sendKeys("chandan kumar");
		driver.findElements(By.name("rad1")).get(0).click();
		driver.findElement(By.xpath("//*[@id='dob']")).sendKeys("04012019");
		driver.findElement(By.name("addr")).sendKeys("New Delhi");
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Chandan\\Desktop\\Batch Jan 20\\selenium\\guru99Page.jpg"));
	}

}
