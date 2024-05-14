package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;


public class ReportConfiguration implements ITestListener

{

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/IdentifyCoursesReport.html");// specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Identify Courses");
		extent.setSystemInfo("Environment", "QEA:SDET");
		extent.setSystemInfo("Tester Name", "VEERABHADRA");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome,Firefox,Edge");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		String imgPath;
		try {
			imgPath = BaseClass.ScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test.addScreenCaptureFromPath(System.getProperty("user.dir") + result.getName() + ".png");

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		String imgPath;
		try {
			imgPath = BaseClass.ScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"/reports/IdentifyCoursesReport.html";
		File extentReport = new File(pathOfExtentReport);
		
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

