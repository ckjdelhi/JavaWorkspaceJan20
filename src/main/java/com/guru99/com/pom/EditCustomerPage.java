package com.guru99.com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	public EditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
