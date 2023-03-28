package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonProductDetailsPage extends AmazonBasePage {
	
	@FindBy(css = "#add-to-cart-button")
	private WebElement addToCartButton;
	
	@FindBy(css = "#buy-now-button")
	private WebElement buyNowButton;
	
	@FindBy(css = "#quantityRelocate_feature_div [id='quantity']")
	private WebElement quantityDropDown;
	
	public AmazonProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonProductDetailsPage(Actions actions) {
		super(actions);
	}
	
	public AmazonPostCheckoutPage updateQuantityAndAddToCart(String quantity) throws Exception {
		Thread.sleep(3000);
		selectFromDropDown(this.quantityDropDown, quantity);
		getActions().click(this.addToCartButton).build().perform();
		return newPage(AmazonPostCheckoutPage.class, getDriver());
	}
	
	public boolean validatePageHasLoaded() {
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.addToCartButton);
		elementList.add(this.buyNowButton);
		Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
		return validateElementsAreVisible(elementList);
	}
	
}
