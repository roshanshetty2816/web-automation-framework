package Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				Util.captureScreenShot();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestStart(ITestResult result) {
		LogHandler.info("Execution of " + result.getMethod().getMethodName() + " started.");
	}
}
