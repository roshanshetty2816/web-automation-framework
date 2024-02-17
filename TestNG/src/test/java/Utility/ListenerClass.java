package Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenerClass implements ITestListener {
	public static ExtentReports report;
	public static ExtentTest test;

	public void onStart(ITestContext context) {
		report = ExtentReportManager.setupExtentReports();
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.fail(result.getThrowable().getMessage());
				test.addScreenCaptureFromPath(Util.captureScreenShot());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestStart(ITestResult result) {
		LogHandler.info("Execution of " + result.getMethod().getMethodName() + " started.");
		test = report.createTest(result.getMethod().getMethodName());
		test.info(result.getMethod().getMethodName() + " execution started.");
	}

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() + " passed");
	}
}
