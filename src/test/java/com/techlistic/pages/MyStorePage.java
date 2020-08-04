/**
 * 
 */
package com.techlistic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Ashwin BM
 *
 */
public class MyStorePage extends BasePage {

	public MyStorePage(WebDriver driver) {
		super(driver);
	}

	private By productTshirt = By.xpath("//ul[@class='product_list grid row']/li[1]");
	private By moreButton = By.xpath("//ul[@class='product_list grid row']/li[1]//span[contains(text(),'More')]");

	// Get My Store Page title
	public String getMyStorePageTitle() {
		return getPageTitle();
	}

	public WebElement getProductTshirt() {
		return getWebElement(productTshirt);
	}

	public WebElement getMoreButton() {
		return getWebElement(moreButton);
	}

	public void waitTillPresenceofTshirts() {
		waitForWebElementPresent(productTshirt);
	}

	public void waitTillVisibilityofMoreBtn() {
		waitForWebElementVisibility(moreButton);
	}

	// Click on More button on Product - Tshirt
	public CustomizeProductPage clickOnCustomizeProduct() {
		waitTillPresenceofTshirts();
		Actions action = new Actions(driver);
		action.moveToElement(getProductTshirt()).build().perform();
		waitTillVisibilityofMoreBtn();
		getMoreButton().click();

		return getInstance(CustomizeProductPage.class);
	}

}
