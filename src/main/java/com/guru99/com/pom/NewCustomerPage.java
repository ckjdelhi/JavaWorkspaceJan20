package com.guru99.com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	public NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@name='name']")
	private WebElement txtCustomerName;
	
	@FindBys(@FindBy(xpath = "//*[@name='rad1']"))
	private List<WebElement> selectGender;
	
	@FindBy(xpath = "//*[@id='dob']")
	private WebElement txtDateOfBirth;
	
	@FindBy(xpath = "//*[@name='addr']")
	private WebElement txtAddress;
	
	public void setCustomerName(String customerName) {
		txtCustomerName.sendKeys(customerName);
	}
	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("male"))
			selectGender.get(0).click();
		else
			selectGender.get(1).click();
	}
	public void setDateOfBirth(String dateOfBirth) {
		txtDateOfBirth.sendKeys(dateOfBirth);
	}
	public void setAddress(String address) {
		txtAddress.sendKeys(address);
	}
}
