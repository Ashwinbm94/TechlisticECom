/**
 * 
 */
package com.techlistic.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
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

		logger = extentReport.startTest("TC_Techlistic_001", "Place An Order");

		String indexPageTitle = page.getInstance(IndexPage.class).getPageTitle();
		Assert.assertEquals(indexPageTitle, "My Store", "Error in innitiating Application");
		logger.log(LogStatus.INFO, "Starting the Application TechListic: " + indexPageTitle);
		LoginPage loginPage = page.getInstance(IndexPage.class).clickSignIn();

		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Login - My Store", "Error in Navigating to Login Page");
		logger.log(LogStatus.INFO, "Navigaing to Login Page: " + loginPageTitle);
		MyAccountPage myAccountPage = loginPage.doLogin("ashwinbm94@gmail.com", "@Hassan18");

		String myAccountPagetitle = myAccountPage.getMyAccountPageTitle();
		Assert.assertEquals(myAccountPagetitle, "My account - My Store", "Error in Login to the application");
		logger.log(LogStatus.INFO, "Logged in Successfully: " + myAccountPagetitle);
		MyStorePage myStorePage = myAccountPage.clickOnWomensTshirts();

		String myStorePagetitle = myStorePage.getMyStorePageTitle();
		Assert.assertEquals(myStorePagetitle, "T-shirts - My Store", "Error in finding the Products");
		logger.log(LogStatus.INFO, "Searching Products: " + myStorePagetitle);
		CustomizeProductPage customizeProductPage = myStorePage.clickOnCustomizeProduct();

		CheckOutPage checkoutPage = customizeProductPage.customizeAndAddProductToCart(2, "L", "Blue");
		String expectedConfirmationMsg = checkoutPage.orderCheckout();

		String confirmationPageTitle = checkoutPage.getOrderConfirmationPageTitle();
		Assert.assertEquals(confirmationPageTitle, "Order confirmation - My Store", "Error in confirming the order");
		logger.log(LogStatus.INFO, "Order Confirmed: " + confirmationPageTitle);

		Assert.assertEquals(expectedConfirmationMsg, "Your order on My Store is complete.",
				"Unable to place the order");
		logger.log(LogStatus.PASS, "Order Completed and the expected Message is: " + expectedConfirmationMsg);

	}

}
