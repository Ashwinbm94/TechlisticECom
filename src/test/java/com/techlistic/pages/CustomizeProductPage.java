/**
 * 
 */
package com.techlistic.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashwin BM
 *
 */
public class CustomizeProductPage extends BasePage {

	public CustomizeProductPage(WebDriver driver) {
		super(driver);
	}

	private By increaseQty = By.xpath("//i[@class='icon-plus']");
	private By selectSizeDropdown = By.xpath("//select[@id='group_1']");
	private By colorOrange = By.xpath("//a[@name='Orange']");
	private By colorBlue = By.xpath("//a[@name='Blue']");
	private By addToCart = By.xpath("//button[@name='Submit']//span[contains(text(),'Add to cart')]");

	private By proceedToCheckoutBtn = By.xpath("//a[@title='Proceed to checkout']//span");

	// Get Customize Product Page title
	public String getCustomizeProductPageTitle() {
		return getPageTitle();
	}

	public WebElement getIncreaseProductQty() {
		return getWebElement(increaseQty);
	}

	public WebElement getProductSize() {
		return getWebElement(selectSizeDropdown);
	}

	public WebElement getProductColorOrange() {
		return getWebElement(colorOrange);
	}

	public WebElement getProductColorBlue() {
		return getWebElement(colorBlue);
	}

	// Choose the Quantity of products to be purchased
	public void increaseProductQty(int quantity) {
		int count = 1;
		if (quantity == count) {
			System.out.println("Quantity of the product is unaltered");
		} else {
			for (int i = 1; i < quantity; i++) {
				getIncreaseProductQty().click();
			}
		}
	}

	// Choose size of the product from the drop down
	public void selectSize(String size) {
		Select select = new Select(getProductSize());
		select.selectByVisibleText(size);
	}

	// Select Color of the product
	public void selectColor(String color) throws Exception {
		if (color.equalsIgnoreCase("blue")) {
			getProductColorBlue().click();
		} else if (color.equalsIgnoreCase("orange")) {
			getProductColorOrange().click();
		} else {
			throw new Exception("Color Provided is not available, please select only the availabe color");
		}
	}

	// Click on Add to Cart
	public WebElement getAddToCart() {
		return getWebElement(addToCart);
	}

	/*
	 * // Click on Proceed to Checkout public void proceedToCheckout() { String
	 * parentWindow = driver.getWindowHandle(); Set<String> windowHandles =
	 * driver.getWindowHandles(); Iterator<String> it = windowHandles.iterator();
	 * while (it.hasNext()) { String currentWindow = it.next(); if
	 * (!parentWindow.equals(currentWindow)) {
	 * driver.switchTo().window(currentWindow);
	 * getWebElement(proceedToCheckoutBtn).click(); } }
	 * driver.switchTo().defaultContent(); }
	 */
	public WebElement getProceedToCheckout() {
		return getWebElement(proceedToCheckoutBtn);
	}

	public void waitTillVisibilityofProceedToCheckout() {
		waitForWebElementVisibility(proceedToCheckoutBtn);
	}

	// Customize and Add Product to cart
	public CheckOutPage customizeAndAddProductToCart(int quantity, String size, String color) {
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		increaseProductQty(quantity);
		selectSize(size);
		try {
			selectColor(color);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getAddToCart().click();
		waitTillVisibilityofProceedToCheckout();
		getProceedToCheckout().click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		return getInstance(CheckOutPage.class);
	}

}
