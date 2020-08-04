/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Ashwin BM
 *
 */
public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	private By womenMenu = By.xpath("//a[@title='Women']");
	private By womenTshirtsSubMenu = By
			.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='T-shirts']");

	private By myAccountPageHeader = By.xpath("//h1[@class='page-heading']");

	// Get My Account Page Title
	public String getMyAccountPageTitle() {
		return getPageTitle();
	}

	// Get My Account Page Header
	public String getMyAccountPageHeader() {
		return getPageHeader(myAccountPageHeader);
	}

	public void waitTillVisibilityofTshirtSubMenu() {
		waitForWebElementVisibility(womenTshirtsSubMenu);
	}

	public WebElement getWomenMenu() {
		return getWebElement(womenMenu);
	}

	public WebElement getWomenTshirtsSubMenu() {
		return getWebElement(womenTshirtsSubMenu);
	}

	public MyStorePage clickOnWomensTshirts() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(getWomenMenu()).build().perform();
		waitTillVisibilityofTshirtSubMenu();
		getWomenTshirtsSubMenu().click();

		return getInstance(MyStorePage.class);
	}

}
