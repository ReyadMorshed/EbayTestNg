package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonLandingPage extends AmazonBasePage {
	
	@FindBy(id = "nav-search-bar-form")
	private WebElement searchTextBox;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;
	
	public AmazonLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonLandingPage(Actions actions) {
		super(actions);
	}
	
	public boolean validatePageHasLoaded() {
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.searchTextBox);
		elementList.add(this.searchButton);
		Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
		return validateElementsAreVisible(elementList);
	}
	
}
