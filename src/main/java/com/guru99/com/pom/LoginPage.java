package com.guru99.com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "uid")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//*[@name='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//*[@name='btnLogin']")
	private WebElement btnLoginButton;
	
	@FindBy(xpath = "//*[@name='btnReset']")
	private WebElement btnResetButton;
	
	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickOnLoginButton() {
		btnLoginButton.click();
	}
	public void clickOnResetButton() {
		btnResetButton.click();
	}
	
}
