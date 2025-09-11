package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class SearchUsingAutoSuggestTest extends TestBase {
	String productName = "Apple iPhone 16 128GB";
	String searchTxt = "Apple";
	
	HomePage homeObject;
	ProductPage productObject;
	
	@Test
	public void searchUsingAutoSuggestTest() {
		homeObject = new HomePage(driver);
		productObject = new ProductPage(driver);
		
		homeObject.searchUsingAutoSuggest(searchTxt, productName);
		Assert.assertEquals(productObject.getProductName(), productName);
	}
}
