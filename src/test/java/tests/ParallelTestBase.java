package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class ParallelTestBase {

	public static String baseURL = "https://demo.nopcommerce.com/";

	protected ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

	@Parameters(value = "browser")
	@BeforeClass
	public void openDriver(@Optional("chrome") String browser) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		drivers.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
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
