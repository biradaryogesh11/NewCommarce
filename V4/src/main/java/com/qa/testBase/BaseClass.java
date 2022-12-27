package com.qa.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public static LoginPage loginpage;
	
	@BeforeClass
	@Test
	public void start()
	{
	 logger= Logger.getLogger("V4");
	 PropertyConfigurator.configure("log4J.properties");
	 logger.info("==============Excution started=================");	
	}
	@AfterClass
	@Test
	public void end()
	{
		logger.info("==============Excution Ended=================");	
	}

	@Parameters("browser")
	@BeforeMethod
	@Test
	public void setProp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("browser started ");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			logger.info("browser started ");
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			logger.info("browser started ");
		}
		else  {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("browser started ");
		}
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		

		loginpage= new LoginPage();
		 
	}
	

	@AfterMethod
	@Test
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(20000);
		driver.quit();
	}
	
}
