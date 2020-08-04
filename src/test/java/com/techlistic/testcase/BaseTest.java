/**
 * 
 */
package com.techlistic.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.techlistic.pages.BasePage;
import com.techlistic.pages.Page;
import com.techlistic.utility.BrowserFactory;
import com.techlistic.utility.ConfigFileReader;

/**
 * @author Ashwin BM
 *
 */
public class BaseTest {
	WebDriver driver;
	public Page page;

	@BeforeMethod
	public void setUpTest() {
		ConfigFileReader config = new ConfigFileReader();
		driver = BrowserFactory.startApplication(driver, config.getBrowserName(), config.getAppURL());
		page = new BasePage(driver);
	}

	@AfterMethod
	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}

}
