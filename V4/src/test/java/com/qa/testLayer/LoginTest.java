package com.qa.testLayer;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.qa.testBase.BaseClass;

public class LoginTest extends BaseClass {

	public void logIntoAccount() {
		loginpage.clickOnLogin();
		logger.info(" clicked on log in");
		loginpage.enterEmailId("biradaryogesh11@gmail.com");
		logger.info("Email id is entered");
		loginpage.enterPassword("Y9421366179b@");
		logger.info("Password is entered");
		String actual_text = loginpage.getLogoutText();
		String expected_text = driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).getText();
		Assert.assertEquals(actual_text, expected_text);
	}
}
