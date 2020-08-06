/**
 * 
 */
package com.techlistic.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.techlistic.pages.BasePage;
import com.techlistic.pages.Page;
import com.techlistic.utility.BrowserFactory;
import com.techlistic.utility.ConfigFileReader;
import com.techlistic.utility.Utility;

/**
 * @author Ashwin BM
 *
 */
public class BaseTest {
	public WebDriver driver;
	public Page page;

	public ExtentReports extentReport;
	public static ExtentTest logger;

	@BeforeTest
	public void setExtentReport() {
		extentReport = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/Techlistic" + Utility.getCurrentDateTime() + ".html", true);
	}

	@BeforeMethod
	public void setUpTest() {
		ConfigFileReader config = new ConfigFileReader();
		driver = BrowserFactory.startApplication(driver, config.getBrowserName(), config.getAppURL());
		page = new BasePage(driver);
	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test case Failed is: " + result.getName());
			logger.log(LogStatus.FAIL, "Test case Failed is: " + result.getThrowable());
			logger.log(LogStatus.FAIL, result.getName(),
					logger.addScreenCapture(Utility.captureScreenshot(driver, result.getName())));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test case Passed is: " + result.getName());
			logger.log(LogStatus.PASS, result.getName(),
					logger.addScreenCapture(Utility.captureScreenshot(driver, result.getName())));
		}

		extentReport.endTest(logger);
		BrowserFactory.quitBrowser(driver);
	}

	@AfterTest
	public void endreport() {
		extentReport.flush();
		extentReport.close();
	}

}
