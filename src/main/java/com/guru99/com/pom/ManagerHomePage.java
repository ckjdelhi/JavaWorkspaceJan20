package com.guru99.com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {
	public ManagerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "New Customer")
	private WebElement linkNewCustomer;
	
	@FindBy(xpath = "//a[text()='Edit Customer']")
	private WebElement linkEditCustomer;
	
	@FindBy(xpath = "//a[text()='Delete Customer']")
	private WebElement linkDeleteCustomer;
	
	public void clickOnNewCustomerLink() {
		linkNewCustomer.click();
	}
	public void clickOnEditCustomerLink() {
		linkEditCustomer.click();
	}
	public void clickOnDeleteCustomerLink() {
		linkDeleteCustomer.click();
	}
}
