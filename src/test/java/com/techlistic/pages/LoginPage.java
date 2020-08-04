/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ashwin BM
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By emailID = By.id("email");
	private By passwd = By.id("passwd");
	private By loginButton = By.xpath("//button[@id='SubmitLogin']/span");

	private By loginPageHeader = By.xpath("//h1[@class='page-heading']");

	// get Email Id field WebElement
	public WebElement getEmailIdWebElement() {
		return getWebElement(emailID);
	}

	// get Password field WebElement
	public WebElement getPasswdWebElement() {
		return getWebElement(passwd);
	}

	// get Submit button WebElement
	public WebElement getSubmitWebElement() {
		return getWebElement(loginButton);
	}

	// Get Login Page Title
	public String getLoginPageTitle() {
		return getPageTitle();
	}

	// Get Login Page Header
	public String getLoginPageheader() {
		return getPageHeader(loginPageHeader);
	}

	// Login to application
	public MyAccountPage doLogin(String email, String password) {
		waitForWebElementPresent(emailID);
		getEmailIdWebElement().sendKeys(email);
		getPasswdWebElement().sendKeys(password);
		getSubmitWebElement().click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		return getInstance(MyAccountPage.class);
	}
}
