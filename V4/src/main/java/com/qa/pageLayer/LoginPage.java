package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage()
	{
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement log_in;
	public void clickOnLogin()
	{
		log_in.click();
		logger.info(" clicked on log in");
	}
	@FindBy(xpath="//input[@id='Email']")
	private WebElement enter_email_id;
	public void enterEmailId(String email)//"biradaryogesh11@gmail.com"
	{
		enter_email_id.sendKeys(email);
		logger.info("Email is entered");
	}
	@FindBy(xpath="//input[@id='Password']")
	private WebElement enter_password;
	public void enterPassword(String pass)//Y9421366179b@
	{
		enter_password.sendKeys(pass);
		logger.info("Password is entered");
	}
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	private WebElement logout_sesssion;
	public String getLogoutText()
	{
		String text=logout_sesssion.getText();
		return text;
	}
	
	

}
