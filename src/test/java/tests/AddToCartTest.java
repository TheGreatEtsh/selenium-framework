package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class AddToCartTest extends TestBase{

	String productName1 = "Apple iPhone 16 128GB";
	String product1Quantity = "4";
	String productName2 = "Apple MacBook Pro";
	String product2Quantity = "3";
	
	HomePage homeObject;
	ProductPage productObject;
	ShoppingCartPage shoppingCartObject;
	
	@Test
	public void addToCartTest() {
		
		homeObject = new HomePage(driver);
		productObject = new ProductPage(driver);
		shoppingCartObject = new ShoppingCartPage(driver);
		
		homeObject.searchUsingAutoSuggest(productName1, productName1);
		productObject.addToCart(product1Quantity);
		Assert.assertTrue(productObject.isProductAddedToCart());
		productObject.closeNotificationBar();
		wait.until(ExpectedConditions.invisibilityOf(productObject.getSuccessMsgElement()));
		
		homeObject.searchUsingAutoSuggest(productName2, productName2);
		productObject.addToCart(product2Quantity);
		Assert.assertTrue(productObject.isProductAddedToCart());
		productObject.closeNotificationBar();
		wait.until(ExpectedConditions.invisibilityOf(productObject.getSuccessMsgElement()));
		
		productObject.openShoppingCartPage();
		Assert.assertTrue(shoppingCartObject.isProductQuantityTrue(productName1, product1Quantity));
		Assert.assertTrue(shoppingCartObject.isProductQuantityTrue(productName2, product2Quantity));
	}
}
