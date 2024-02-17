package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReport;

	public static ExtentReports setupExtentReports() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date curDate = new Date();
		String formattedDate = dateFormat.format(curDate);

		sparkReporter = new ExtentSparkReporter(".//Reports//ExtentReport " + formattedDate + ".html");
		extentReport = new ExtentReports();

		sparkReporter.config().setTheme(Theme.STANDARD);
		extentReport.attachReporter(sparkReporter);
		return extentReport;
	}
}
