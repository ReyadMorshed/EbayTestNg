package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import actions.AmazonCustomerActions;
import base.BaseTest;
import pages.AmazonLandingPage;
import pages.AmazonLoginPage;
import pages.BasePage;

public class AmazonCustomerLoginTest extends BaseTest {

	//	Login and add a product to the cart
	@Test
	public void amazonUserAddsProductsToCart() throws Exception {
		// Validate landing page has loaded
		var amazonLandingPage = BasePage.newPage(AmazonLandingPage.class, getDriver());
		Assert.assertTrue(amazonLandingPage.validatePageHasLoaded(), "Landing Page Has Loaded Successfully.");
		
		// Go to Login page
		var amazonLoginPage = (AmazonLoginPage) amazonLandingPage.goToAmazonLoginPage();
		Assert.assertTrue(amazonLoginPage.validatePageHasLoaded(), "Login Page Has Loaded Successfully.");
		
		// Login to your account
		var amazonHomePage = amazonLoginPage.login("woodcrewteam@gmail.com", "woodcrewteam321@#");
		Assert.assertTrue(amazonHomePage.validatePageHasLoaded(), "Home Page Has Loaded Successfully.");
		
		// Instantiate AmazonCustomerActions object
		var amazonCustomerActions = new AmazonCustomerActions(getDriver());
		
		// Search for any product
		var amazonSearchResultPage = amazonCustomerActions.searchForProduct(amazonHomePage, "Laptop Core i7");
		Assert.assertTrue(amazonSearchResultPage.validatePageHasLoaded(), "Search Result Page Has Loaded Successfully.");
		
		// Choose any from the products list
		var amazonProductDetailsPage = amazonCustomerActions.clickOnChoosedProduct(amazonSearchResultPage);
		Assert.assertTrue(amazonProductDetailsPage.validatePageHasLoaded(), "Product Details Page Has Loaded Successfully.");
		
		// Update quantity and add the product to the cart
		var amazonPostCheckoutPage = amazonCustomerActions.addtoCart(amazonProductDetailsPage, "3");
		Assert.assertTrue(amazonPostCheckoutPage.validateIfAlertMessageAppears(), "Added to Cart alert is displayed");
		Assert.assertTrue(amazonPostCheckoutPage.validatePageHasLoaded(), "Proceed to Checkout Page Has Loaded Successfully.");
		
		// Go to cart option
		var amazonCartViewPage = amazonCustomerActions.goToCart(amazonPostCheckoutPage);
		Assert.assertTrue(amazonCartViewPage.validatePageHasLoaded(), "Shopping Cart Page Has Loaded Successfully.");
		
		
		// Validate product added to the cart successfully
	}
	
}
