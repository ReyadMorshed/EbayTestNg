package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonPostCheckoutPage extends AmazonBasePage {
	
	@FindBy(css = "#attach-view-cart-button-form")
	private WebElement cartForm;
	
	@FindBy(css = "#attach-sidesheet-checkout-button")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(css = "[name='proceedToRetailCheckout']")
	private WebElement proceedToCheckoutButton2;
	
	@FindBy(css = "[id='sw-subtotal']")
	private WebElement addToCartLinkText;
	
	@FindBy(xpath = "//*[@id='attachDisplayAddBaseAlert']//*[text()='Added to Cart']")
	private WebElement addedToCartAlertText;
	
	@FindBy(xpath = "//*[@id='sw-atc-confirmation']//div[@id='add-to-cart-confirmation-image']")
	private WebElement addedToCartAlertText2;
	
	public AmazonPostCheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonPostCheckoutPage(Actions actions) {
		super(actions);
	}
	
	public AmazonCartViewPage clickOnCartForm() throws Exception {
		Thread.sleep(3000);
		getActions().click(this.cartForm).build().perform();
		return newPage(AmazonCartViewPage.class, getDriver());
	}
	
	public boolean validateIfAlertMessageAppears() {
		try {
			return isDisplayed(this.addedToCartAlertText); 
		} catch (Exception e) {
			return isDisplayed(this.addedToCartAlertText2); 
		}
	}
	
	public boolean validatePageHasLoaded() {
		boolean visible = false;
		try {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.cartForm);
			elementList.add(this.proceedToCheckoutButton);
			Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
			boolean visibility = validateElementsAreVisible(elementList);
			if (visibility == true) {
				visible = visibility;
			}
			else {
				throw new NoSuchElementException();
			}
		} catch (Exception e) {
			List<WebElement> elementList = new ArrayList<>();
			elementList.add(this.addToCartLinkText);
			elementList.add(this.proceedToCheckoutButton2);
			Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
			boolean visibility = validateElementsAreVisible(elementList);
			if (visibility == true) {
				visible = visibility;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
		return visible;
	}
	
}
