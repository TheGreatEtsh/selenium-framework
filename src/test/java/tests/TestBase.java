package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	public WebDriverWait wait;

	public static ChromeOptions chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		/*
		 * HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		 * chromePrefs.put("profile.default.content_settings.popups", 0);
		 * chromePrefs.put("download.default_directory", downloadPath);
		 * option.setExperimentalOption("prefs", chromePrefs);
		 * option.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		 */
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", Helper.downloadPath); // set download folder
		prefs.put("download.prompt_for_download", false); // auto-download without prompt
		prefs.put("download.directory_upgrade", true);
		prefs.put("safebrowsing.enabled", true);
		options.setExperimentalOption("prefs", prefs);

		return options;
	}

	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			// + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeOptions());

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			// + "\\drivers\\chromedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.get("https://demo.nopcommerce.com/");
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult methodResult) throws IOException {
		if (methodResult.getStatus() == ITestResult.FAILURE) {
			Helper.takeScreenShot(driver, methodResult.getName());
		}
	}
	

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
}
