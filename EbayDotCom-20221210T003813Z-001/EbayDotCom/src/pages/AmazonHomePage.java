package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonHomePage extends AmazonBasePage {

	@FindBy(css = "#nav-link-accountList")
	private WebElement accountList;
	
	@FindBy(css = "#nav-item-signout")
	private WebElement signOutLinkText;
	
	@FindBy(css = "#twotabsearchtextbox")
	private WebElement searchTextBox;
	
	public AmazonHomePage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonHomePage(Actions actions) {
		super(actions);
	}
	
	public AmazonSearchResultPage searchForProduct(String keyword) throws Exception {
		Thread.sleep(3000);
		getActions().sendKeys(this.searchTextBox, keyword + Keys.ENTER).build().perform();
		return newPage(AmazonSearchResultPage.class, getDriver());
	}

	public boolean validatePageHasLoaded() {
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.accountList);
		getActions().moveToElement(this.accountList).build().perform();
		elementList.add(this.signOutLinkText);
		Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
		return validateElementsAreVisible(elementList);
	}

}
