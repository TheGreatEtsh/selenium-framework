package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ChangeCurrencyTest extends TestBase{
	String customerCurrency = "US Dollar";
	
	HomePage homeObject;
	
	@Test
	public void changeCurrencyTest() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency(customerCurrency);
		Assert.assertTrue(homeObject.isCurrencyChanged(customerCurrency));
	}
}
