package actions;

import org.openqa.selenium.WebDriver;

import pages.AmazonCartViewPage;
import pages.AmazonHomePage;
import pages.AmazonPostCheckoutPage;
import pages.AmazonProductDetailsPage;
import pages.AmazonSearchResultPage;

public class AmazonCustomerActions {
	
	private final WebDriver driver;
	
	public AmazonCustomerActions(final WebDriver driver) {
		this.driver = driver;
	}
	
	public AmazonSearchResultPage searchForProduct(AmazonHomePage amazonHomePage, String keyword) throws Exception {
		return amazonHomePage.searchForProduct(keyword);
	}
	
	public AmazonProductDetailsPage clickOnChoosedProduct(AmazonSearchResultPage amazonSearchResultPage) throws Exception {
		return amazonSearchResultPage.chooseFromProductList();
	}
	
	public AmazonPostCheckoutPage addtoCart(AmazonProductDetailsPage amazonProductDetailsPage, String quantity) throws Exception {
		return amazonProductDetailsPage.updateQuantityAndAddToCart(quantity);
	}
	
	public AmazonCartViewPage goToCart(AmazonPostCheckoutPage amazonPostCheckoutPage) throws Exception {
		return amazonPostCheckoutPage.clickOnCartForm();
	}
}
