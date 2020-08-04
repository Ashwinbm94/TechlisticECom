/**
 * 
 */
package com.techlistic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Ashwin BM
 *
 */
public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getWebElement(locator).getText();
	}

	@Override
	public WebElement getWebElement(By locator) {
		WebElement ele = null;
		try {
			ele = driver.findElement(locator);
			return ele;
		} catch (Exception e) {
			System.out.println("Error occoured while finding the Element" + locator.toString());
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void waitForWebElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Exception occured while waiting for the WebElement" + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Exception occured while waiting for the Page Title" + title);
			e.printStackTrace();
		}
	}

	@Override
	public void waitForWebElementVisibility(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Exception occured while waiting for the WebElement" + locator.toString());
			e.printStackTrace();
		}
	}

}
