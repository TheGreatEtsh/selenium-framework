package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import utilities.Helper;

public class ParallelTestBase {

	public static final String USERNAME = LoadProperties.saucelabsUserData.getProperty("username");
	public static final String ACCESS_KEY = LoadProperties.saucelabsUserData.getProperty("accessKey");
	public static final String BUILD = LoadProperties.saucelabsUserData.getProperty("build");
	public static final String TEST_NAME = LoadProperties.saucelabsUserData.getProperty("testName");
	public static final String sauceURL = LoadProperties.saucelabsUserData.getProperty("URL");

	public static String baseURL = "https://demo.nopcommerce.com/";

	protected ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

	@Parameters({ "browser", "usage", "platform" })
	@BeforeClass
	public void openDriver(@Optional("chrome") String browser, @Optional("saucelabs") String usage,
			@Optional("Windows 10") String platform) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		if (usage.equalsIgnoreCase("saucelabs")) {
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("username", USERNAME);
			sauceOptions.put("accessKey", ACCESS_KEY);
			sauceOptions.put("build", BUILD);
			sauceOptions.put("name", TEST_NAME);
			sauceOptions.put("platform", platform);
			sauceOptions.put("screenResolution", "1920x1080");

			caps.setCapability("sauce:options", sauceOptions);
			URL url = new URL(sauceURL);
			drivers.set(new RemoteWebDriver(url, caps));

		} else {
			drivers.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		}

		getDriver().get(baseURL);
	}

	public WebDriver getDriver() {
		return drivers.get();
	}

	@AfterClass
	public void stopDriver() {
		RemoteWebDriver driver = (RemoteWebDriver) getDriver();
		if (driver != null) {
			driver.quit();
			drivers.remove();
		}
	}

	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult methodResult) throws IOException {
		if (methodResult.getStatus() == ITestResult.FAILURE) {
			Helper.takeScreenShot(getDriver(), methodResult.getName());
		}
	}
}
