package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonLoginPage extends AmazonBasePage {
	
	@FindBy(css = "input#continue")
	private WebElement continueButton;
	
	@FindBy(css = "#createAccountSubmit")
	private WebElement createYourAmazonAccountButton;
	
	@FindBy(css = "#ap_email")
	private WebElement emailTextBox;
	
	@FindBy(css = "#ap_password")
	private WebElement passwordTextBox;
	
	@FindBy(css = "#signInSubmit")
	private WebElement signInButton;
	
	public AmazonLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonLoginPage(Actions actions) {
		super(actions);
	}
	
	public AmazonHomePage login(String email, String password) throws Exception {
		Thread.sleep(3000);
		getActions().sendKeys(this.emailTextBox, email).build().perform();
		getActions().click(this.continueButton).build().perform();
		Thread.sleep(3000);
		getActions().sendKeys(this.passwordTextBox, password).build().perform();
		Thread.sleep(3000);
		getActions().click(this.signInButton).build().perform();
		return newPage(AmazonHomePage.class, getDriver());
	}
	
	public boolean validatePageHasLoaded() {
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.continueButton);
		elementList.add(this.createYourAmazonAccountButton);
		Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
		return validateElementsAreVisible(elementList);
	}

}
