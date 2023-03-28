package base;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	private static WebDriver driver;
	public Actions actions;

	public static WebDriver getDriver() {
		return driver;
	}
	
	public Actions getActions() {
		return actions = new Actions(driver);
	}

	// Setup system property for browser like CHROME, FIREFOX, etc.
	@BeforeSuite
	public static void driverSetUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}

//	Maximize the browser
	@BeforeTest
	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

//	Apply Implicitly Wait
	@BeforeClass
	public static void applyImplicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

//	Navigate to Application
	@BeforeMethod
	public static void navigatetoApplication() {
		driver.navigate().to("https://www.amazon.com/");
	}

//	Login and add a product to the cart
//	@Test
//	public void amazonUserAddsProductsToCart() {
//		// Validate landing page has loaded
//		
//		// Login to your account
//		// Validate login page has loaded successfully
//		
//		// Search for a specific product
//		// Validate search result page has loaded successfully
//		
//		// Choose any from the products list
//		// Validate product details page has loaded successfully
//		// Add quantity for that product
//		
//		// Add the product to the cart
//		// Go to cart option
//		// Validate cart page has loaded successfully
//		
//		// Validate product added to the cart successfully
//	}

//	Logout
	@AfterMethod
	public static void logout() {
		// Logout from your account
	}

//	@BeforeMethod -- Navigate to Application
//	@Test -- Login and update quantity of product in the cart
//	@AfterMethod -- Logout

//	@BeforeMethod -- Navigate to Application
//	@Test -- Login and cancel the order from the cart
//	@AfterMethod -- Logout

//	Delete all cookies
	@AfterClass
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

//	Close the browser
	@AfterTest
	public static void closeBrowser() {
		//driver.close();
	}

//	Quit the driver
	@AfterSuite
	public static void driverQuit() {
		//driver.quit();
	}
}
