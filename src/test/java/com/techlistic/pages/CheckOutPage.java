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
public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	private By proceedToCheckoutbtn = By
			.xpath("//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]");
	private By pageHeading = By.xpath("//h1[@class='page-heading']");
	private By termsOfService = By.xpath("//input[@id='cgv']");
	private By paybyBankWire = By.xpath("//a[@title='Pay by bank wire']");
	private By confirmOrderbtn = By.xpath("//button[@type='submit']/span[contains(text(),'I confirm my order')]");
	private By OrderConfSuccessMsg = By
			.xpath("//strong[@class='dark'][contains(text(),'Your order on My Store is complete.')]");

	public String getCheckoutPageTitle() {
		return getPageTitle();
	}

	public String getOrderConfirmationPageTitle() {
		return getPageTitle();
	}

	public String getCartHeading() {
		return getPageHeader(pageHeading);
	}

	public WebElement getnavigateToDeliveryAddress() {
		return getWebElement(proceedToCheckoutbtn);
	}

	public WebElement getnavigateToShipping() {
		return getWebElement(proceedToCheckoutbtn);
	}

	public WebElement getacceptTermsofService() {
		return getWebElement(termsOfService);
	}

	public WebElement getnavigateToPayment() {
		return getWebElement(proceedToCheckoutbtn);
	}

	public WebElement getpayByBankWire() {
		return getWebElement(paybyBankWire);
	}

	public WebElement getConfirmOrder() {
		return getWebElement(confirmOrderbtn);
	}

	public WebElement getOrderSuccessMsg() {
		return getWebElement(OrderConfSuccessMsg);
	}

	public void waitTillShoppingCartPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	public String orderCheckout() {
		getnavigateToDeliveryAddress().click();
		waitTillShoppingCartPageLoads();
		getnavigateToShipping().click();
		waitTillShoppingCartPageLoads();
		getacceptTermsofService().click();
		getnavigateToPayment().click();
		waitTillShoppingCartPageLoads();
		getpayByBankWire().click();
		waitTillShoppingCartPageLoads();
		getConfirmOrder().click();
		waitTillShoppingCartPageLoads();
		String successMsg = getOrderSuccessMsg().getText();
		return successMsg;
	}

}
