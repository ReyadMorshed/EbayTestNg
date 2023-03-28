package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

public class AmazonBasePage extends BasePage {
	
	@FindBy(css = "#nav-link-accountList")
	private WebElement accountList;
	
	@FindBy(xpath = "//a[@data-nav-ref='nav_signin']")
	private WebElement signInLinkText;
	
	@FindBy(css = ".nav-signin-tt a.nav-action-button")
	private WebElement signInButton;
	
	public AmazonBasePage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonBasePage(Actions actions) {
		super(actions);
	}
	
	public AmazonLoginPage goToAmazonLoginPage() throws Exception {
		try {
			Thread.sleep(3000);
			getActions().moveToElement(this.accountList).build().perform();
			getActions().click(this.signInLinkText).build().perform();
		} catch (Exception e) {
			getActions().click(this.signInButton).build().perform();
		}
		
		Reporter.log("Clicking on Login link -> Login");
		return newPage(AmazonLoginPage.class, getDriver());
	}

	protected boolean validateElementsAreVisible(List<WebElement> elements) {
		while(elements.size() > 0) {
			if(isDisplayed(elements.get(0))) {
				elements.remove(0);
				validateElementsAreVisible(elements);
			}
		}
		return true;
	}
}
