package com.guru99.com.pom;

import org.openqa.selenium.WebDriver;

import com.drivers.DriverFactory;

public class RunTestCase {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getBrowser("chrome");
		driver.get("http://demo.guru99.com/v4/");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("mgr123");
		loginPage.setPassword("mgr!23");
		loginPage.clickOnLoginButton();
		
		ManagerHomePage managerHomePage=new ManagerHomePage(driver);
		managerHomePage.clickOnNewCustomerLink();
		
		NewCustomerPage newCustomerPage=new NewCustomerPage(driver);
		newCustomerPage.setCustomerName("Prasanthi");
		newCustomerPage.setGender("female");
		newCustomerPage.setDateOfBirth("10122000");
		newCustomerPage.setAddress("US");
		

	}

}
