package com.qa.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.testBase.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		logger.info("Test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test execution success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test execution failed");
		Screenshot.takeScreenshot(result.getName() + System.currentTimeMillis());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test execution skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
