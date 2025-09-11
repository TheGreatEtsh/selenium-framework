package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class SendProductViaEmailTest extends TestBase{
	String yourEmail = "test17@gmail.com";
	String theirEmail = "test100@test.com";
	String password = "KGWouhqofgWOUW";
	String message = "This is for you";
	
	HomePage homeObject;
	ProductPage productObject;
	LoginPage loginObject;
	EmailFriendPage emailFriendObject;
	
	String productName = "Apple iPhone 16 128GB";
	String searchTxt = "Apple";
	
	@Test(priority = 1)	
	public void testLoginAccount() {
		homeObject = new HomePage(driver);
		homeObject.openLogInPage();

		loginObject = new LoginPage(driver);
		loginObject.loginAccount(yourEmail, password);

		Assert.assertTrue(homeObject.logoutLink.isDisplayed());
	}


	@Test(dependsOnMethods = "testLoginAccount")
	public void searchUsingAutoSuggestTest() {
		homeObject = new HomePage(driver);
		productObject = new ProductPage(driver);
		
		homeObject.searchUsingAutoSuggest(searchTxt, productName);
		Assert.assertEquals(productObject.getProductName(), productName);
	}
	
	@Test(dependsOnMethods = "searchUsingAutoSuggestTest")
	public void sendProductViaEmailTest() {
		productObject = new ProductPage(driver);
		emailFriendObject = new EmailFriendPage(driver);
		
		productObject.openEmailFriendPage();
		emailFriendObject.emailFriend(theirEmail, message);
		
		Assert.assertTrue(emailFriendObject.isResultMessageDisplayed());
		
	}
	
}
