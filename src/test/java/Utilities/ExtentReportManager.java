package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import TestBase.BaseClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	private static ExtentTest test;
	private static String reportPath;

	// Initialize Extent Report
	public void onStart(ITestContext testContext) {
		// Create reports directory if not exists
		String reportsDir = System.getProperty("user.dir") + "/reports";
		File directory = new File(reportsDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		// Create report filename with timestamp
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
		reportPath = reportsDir + "/ExtentReport_" + timestamp + ".html";
		sparkReporter = new ExtentSparkReporter(reportPath);

		// Configure Extent Report
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("Functional Testing Report");
		sparkReporter.config().setTheme(Theme.DARK);

		// Attach Reporter and add System Info
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Practice Automation Testing");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("OS", testContext.getCurrentXmlTest().getParameter("os"));
		extent.setSystemInfo("Browser", testContext.getCurrentXmlTest().getParameter("browser"));
		extent.setSystemInfo("User", System.getProperty("user.name"));

		List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includeGroups.isEmpty()) {
			extent.setSystemInfo("Test Groups", includeGroups.toString());
		}
	}

	// Test Case Passed
	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName() + " - " + result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + " executed successfully.");
	}

	// Test Case Failed - Capture Screenshot
	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName() + " - " + result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " failed.");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			BaseClass base = (BaseClass) result.getInstance();
			String imgPath = base.captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Test Case Skipped
	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName() + " - " + result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " was skipped.");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	// Flush Report at the End
	@Override
	public void onFinish(ITestContext testContext) {
		if (extent != null) {
			extent.flush();
		}
	}
}
