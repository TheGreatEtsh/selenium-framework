package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductMenuPage;

public class SelectFromProductMenuTest extends TestBase{

	HomePage homeObject;
	ProductMenuPage productMenuObject;
	
	String productName = "Notebooks";
	
	@Test
	public void selectProductFromDropdownMenuTest() {
		homeObject = new HomePage(driver);
		productMenuObject= new ProductMenuPage(driver);
		
		homeObject.openNotebooksPage(productName);
		
		Assert.assertTrue(productMenuObject.isProductPageCorrect(productName));
	}
}
