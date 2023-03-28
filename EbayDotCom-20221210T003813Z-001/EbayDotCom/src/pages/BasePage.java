package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class BasePage extends BaseTest {

	public static Robot robot;
	
	public BasePage(WebDriver driver) {
		
	}
	
	public BasePage(Actions actions) {
		
	}

	protected static void selectFromDropDown(WebElement element, String desired) {
		Select select = new Select(element);
		select.selectByVisibleText(desired);
	}

	protected static String getText(WebElement element) {
		return element.getText();
	}

	protected static Boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	protected static Boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	protected static Boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	protected static void zoomIn() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	protected static void zoomOut() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	protected static void takeSnapshot(WebDriver driver, String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
	}

	protected static WebDriverWait applyExplicitWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(30));
	}

	public static <T> T newPage(Class<T> testClass, WebDriver driver) {
		return PageFactory.initElements(driver, testClass);
	}

//	public static <T> T newPage(Class<T> testClass) throws Exception {
//		return testClass.getDeclaredConstructor().newInstance();
//	}
}
