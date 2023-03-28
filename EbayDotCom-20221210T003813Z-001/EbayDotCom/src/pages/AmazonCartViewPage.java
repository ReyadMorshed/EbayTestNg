package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonCartViewPage extends AmazonBasePage {
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartText;
	
	@FindBy(xpath = "//*[contains(text(),'Your Items')]")
	private WebElement yourItemsText;
	
	public AmazonCartViewPage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonCartViewPage(Actions actions) {
		super(actions);
	}
	
	public boolean validatePageHasLoaded() {
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.shoppingCartText);
		elementList.add(this.yourItemsText);
		Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
		return validateElementsAreVisible(elementList);
	}
	
}
