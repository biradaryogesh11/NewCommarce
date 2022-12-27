package com.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.testBase.BaseClass;

public class Screenshot extends BaseClass {

	public static void takeScreenshot(String filename) {
		String path="C:\\Users\\MANGESH PC\\newCommerce\\V4\\Screenshot";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des= new File(path+filename+".png");
		try {
			FileHandler.copy(src, des);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
