package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class CheckOutOrderTest extends TestBase{

	HomePage homeObject;
	LoginPage loginObject;
	ProductPage productObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage checkOutObject;
	
	String firstName = "john";
	String email = "test01@test.com";
	String password = "4613054143";
	String searchTxt = "apple";
	private String productName = "Apple iPhone 16 128GB";
	private String quantity = "1";
	private String lastName = "doe";
	private String city = "test";
	private String address = "test";
	private String stateProvinceId = "Alaska";
	private String zipCode = "test";
	private String phoneNumber = "test";
	
	@Test(priority = 1)
	public void login() {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		
		homeObject.openLogInPage();
		loginObject.loginAccount(email, password);
	}
	
	@Test(dependsOnMethods = "login")
	public void addProductToCart() {
		homeObject = new HomePage(driver);
		productObject = new ProductPage(driver); 
		
		homeObject.searchUsingAutoSuggest(searchTxt, productName);
		productObject.addToCart(quantity);
		Assert.assertTrue(productObject.isProductAddedToCart());
		productObject.closeNotificationBar();
		wait.until(ExpectedConditions.invisibilityOf(productObject.getSuccessMsgElement()));
		
	}
	
	@Test(dependsOnMethods = "addProductToCart")
	public void checkoutOrderTest() {
		productObject = new ProductPage(driver);
		shoppingCartObject = new ShoppingCartPage(driver);
		checkOutObject = new CheckOutPage(driver);
		
		productObject.openShoppingCartPage();
		shoppingCartObject.openCheckoutPage();
		checkOutObject.addCheckOutDetails(wait ,firstName, lastName, email, city, address, stateProvinceId, zipCode, phoneNumber);
	
		
		Assert.assertTrue(checkOutObject.confirmationMsgDisplayed(wait));
		checkOutObject.openOrderDetailsPage();
		
		
	}
}
