package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;

public class SearchUsingSearchButtonTest extends TestBase{
	String productName = "Apple iPhone 16 128GB";
	String searchTxt = "Apple";
	
	HomePage homeObject;
	SearchResultPage searchResultObject;
	ProductPage productObject;
	
	@Test
	public void searchUsingSearchBtn() {
		homeObject = new HomePage(driver);
		searchResultObject = new SearchResultPage(driver);
		productObject = new ProductPage(driver);
		
		homeObject.searchUsingSeachBtn(searchTxt);
		searchResultObject.findProduct(productName);
		Assert.assertEquals(productObject.getProductName(), productName);
	}
	
}
