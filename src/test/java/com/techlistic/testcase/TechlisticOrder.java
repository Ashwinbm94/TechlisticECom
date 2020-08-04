/**
 * 
 */
package com.techlistic.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techlistic.pages.CheckOutPage;
import com.techlistic.pages.CustomizeProductPage;
import com.techlistic.pages.IndexPage;
import com.techlistic.pages.LoginPage;
import com.techlistic.pages.MyAccountPage;
import com.techlistic.pages.MyStorePage;

/**
 * @author Ashwin BM
 *
 */
public class TechlisticOrder extends BaseTest {

	@Test
	public void placeAnOrder() {
		String indexPageTitle = page.getInstance(IndexPage.class).getPageTitle();
		System.out.println(indexPageTitle);
		Assert.assertEquals(indexPageTitle, "My Store", "Error in innitiating Application");
		LoginPage loginPage = page.getInstance(IndexPage.class).clickSignIn();

		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println(loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Login - My Store", "Error in Navigating to Login Page");
		MyAccountPage myAccountPage = loginPage.doLogin("ashwinbm94@gmail.com", "@Hassan18");

		String myAccountPagetitle = myAccountPage.getMyAccountPageTitle();
		System.out.println(myAccountPagetitle);
		Assert.assertEquals(myAccountPagetitle, "My account - My Store", "Error in Login to the application");
		MyStorePage myStorePage = myAccountPage.clickOnWomensTshirts();

		String myStorePagetitle = myStorePage.getMyStorePageTitle();
		System.out.println(myStorePagetitle);
		Assert.assertEquals(myStorePagetitle, "T-shirts - My Store", "Error in Login to the application");
		CustomizeProductPage customizeProductPage = myStorePage.clickOnCustomizeProduct();

		CheckOutPage checkoutPage = customizeProductPage.customizeAndAddProductToCart(2, "L", "Blue");
		String expectedConfirmationMsg = checkoutPage.orderCheckout();

		String confirmationPageTitle = checkoutPage.getOrderConfirmationPageTitle();
		Assert.assertEquals(confirmationPageTitle, "Order confirmation - My Store", "Error in confirming the order");
		System.out.println("Order Confirmed: " + confirmationPageTitle);

		Assert.assertEquals(expectedConfirmationMsg, "Your order on My Store is complete.",
				"Unable to place the order");
		System.out.println("Order Completed: " + expectedConfirmationMsg);

	}

}
