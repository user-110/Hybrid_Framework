package com.orangehrm.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener {

	ExtentReports er;
	ExtentTest etest;

	@Override
	public void onStart(ITestContext context) {
		try {
			er = ExtentReporterClass.createExtentReport();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();
		etest = er.createTest(testName);
		etest.log(Status.INFO, testName + " execution started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		etest.log(Status.PASS, testName + " was sucessfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		try {
			etest.addScreencastFromPath(destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		etest.log(Status.INFO, result.getThrowable());
		etest.log(Status.FAIL, testName + " got failed");

	}

//	@Override
//	public void onTestSkipped(ITestResult result) {
//
//	}
//
	@Override
	public void onFinish(ITestContext context) {
		er.flush();
	}

}
