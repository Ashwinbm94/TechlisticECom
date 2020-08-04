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
public class IndexPage extends BasePage {

	public IndexPage(WebDriver driver) {
		super(driver);
	}

	private By signInLink = By.className("login");

	// get Signin WebElement
	public WebElement getSignInWebElement() {
		return getWebElement(signInLink);
	}

	// Click on Signin link
	public LoginPage clickSignIn() {
		getSignInWebElement().click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		return getInstance(LoginPage.class);
	}

}
