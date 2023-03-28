package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AmazonSearchResultPage extends AmazonBasePage {
	
	@FindBy(xpath = "//*[text()='RESULTS']")
	private WebElement resultsText;
	
	@FindBy(css = "[data-component-type='s-result-info-bar']")
	private WebElement resultsInfoBar;
	
	@FindBy(css = "[data-component-type='s-search-result']")
	private List<WebElement> listOfResults;
	
	public AmazonSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public AmazonSearchResultPage(Actions actions) {
		super(actions);
	}
	
	public AmazonProductDetailsPage chooseFromProductList() throws Exception {
		int min = 1;
		int numberOfResults = this.listOfResults.size();
		int any = (int) (Math.random() * (numberOfResults - min + 1) + min);
		WebElement item = getDriver().findElement(By.xpath("//div[@data-component-type='s-search-result'][" + any + "]//span[@data-component-type='s-product-image']//img"));
//		WebElement item = this.listOfResults.get(any);
		getActions().scrollToElement(item).build().perform();
		Thread.sleep(3000);
		getActions().click(item).build().perform();
		return newPage(AmazonProductDetailsPage.class, getDriver());
	}
	
	public boolean validatePageHasLoaded() {
		List<WebElement> elementList = new ArrayList<>();
		elementList.add(this.resultsText);
		elementList.add(this.resultsInfoBar);
		Reporter.log("Waiting for " + getClass().getSimpleName() + " elements visibility.");
		return validateElementsAreVisible(elementList);
	}
	
}
