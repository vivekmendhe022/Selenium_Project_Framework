package com.generic.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationUtlity implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Execution Started");
		test = reports.createTest(methodName);
		test.log(Status.INFO, methodName + " Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script passed");
		test.log(Status.INFO, methodName + " Script Passed");
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script failed");
		System.out.println(result.getThrowable());
		test.log(Status.FAIL, methodName + " Script Failed");
		test.log(Status.WARNING, result.getThrowable());

		// Take Screen Shot
		String src = methodName + " - " + new JavaUtility().getSystemDateInFormate();
		WebDriverUtility wutil = new WebDriverUtility();
		try {
			String path = wutil.takeScreenShot(BaseClass.SDriver, src);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " Test Script Skipped");
		System.out.println(result.getThrowable());
		test.log(Status.SKIP, methodName + " Script: Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		System.out.println("Execution Start");
		String path = "";
		ExtentSparkReporter html = new ExtentSparkReporter(path);
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("App Extent Report");
		html.config().setReportName("Reporter Name");

		reports = new ExtentReports();
		reports.attachReporter(html);
		reports.setSystemInfo("Base Browser", "chrome");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base Platform", "Windows 11");
		reports.setSystemInfo("Reporter Name", "Me");

	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		reports.flush();
	}

}
