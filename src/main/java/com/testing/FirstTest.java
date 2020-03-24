package com.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Chandan\\Desktop\\Batch Jan 20\\selenium\\htmlForm.html");
		String title= driver.getTitle();
		if(title.equals("Registration Form")) {
			//Textbox
			
			WebElement firstNameEl=driver.findElement(By.xpath("/html/body/input[1]"));
			//WebElement firstNameEl=driver.findElement(By.name("firstName"));
			firstNameEl.sendKeys("Automation");
			driver.findElement(By.id("lastName")).sendKeys("Testing");
			
			//Radio button
			driver.findElements(By.name("gender")).get(1).click();
			/*List<WebElement> genders=driver.findElements(By.name("gender"));
			System.out.println(genders.size()); //2
			
			//genders.get(0).click();//Male
			genders.get(1).click();//Female
			*/
			//Dropdown/combobox
			WebElement countryEl = driver.findElement(By.name("country"));
			Select allCountries=new Select(countryEl);
			allCountries.selectByValue("PAK");
			//allCountries.selectByVisibleText("Nepal");
			//allCountries.selectByIndex(3);
			
			//Checkbox
			driver.findElement(By.id("hindi")).click();
			driver.findElement(By.id("english")).click();
			
			//submit
			driver.findElement(By.id("save")).click();
			
			//anchor tag(link tag)
			//driver.findElement(By.linkText("Google Link")).click();
			driver.findElement(By.partialLinkText("Google")).click();
			
		}else {
			System.out.println("This is not correct website to automate");
		}
		
	}
}
