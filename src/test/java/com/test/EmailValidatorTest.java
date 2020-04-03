package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailValidatorTest {
	private EmailValidator emailValidator=null;
	
	@BeforeClass
	public void setUp() {
		emailValidator=new EmailValidator();
	}
	@Test
	public void canTestEmailIDWhenInputIsBlank() {
		boolean isValid = emailValidator.isValid("");
		Assert.assertFalse(isValid);
	}
	
	@Test(dependsOnMethods = "canTestEmailIDWhenInputIsBlank")
	public void canTestEmailIDWhenInputIsNull() {
		boolean isValid = emailValidator.isValid(null);
		Assert.assertFalse(isValid);
	}
	@Test(dependsOnMethods = "canTestEmailIDWhenInputIsNull")
	public void canTestEmailIDWhenInputIsWithoutAtTheRate() {
		boolean isValid = emailValidator.isValid("chandan.krkgmail.com");
		Assert.assertEquals(isValid, false);
	}
	@Test(dependsOnMethods = "canTestEmailIDWhenInputIsWithoutAtTheRate")
	public void canTestEmailIDWhenInputValid() {
		boolean isValid = emailValidator.isValid("chandan.krk@gmail.com");
		Assert.assertTrue(isValid);
	}
	@Test(dependsOnMethods = "canTestEmailIDWhenInputValid", enabled = false)
	public void canTestEmailIDWhenInputInvalid2() {
		boolean isValid = emailValidator.isValid("chandan@krk@gmail.com");
		Assert.assertFalse(isValid);
	}
}
