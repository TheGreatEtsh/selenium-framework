package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OrderDetailsPage;
import utilities.Helper;

public class DownloadInvoiceTest extends TestBase{

	HomePage homeObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	OrderDetailsPage orderDetailsObject;
	private String email = "test16@gmail.com";
	private String password = "KGWouhqofgWOUW";
	
	@Test(priority = 1)
	public void login() {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
		
		homeObject.openLogInPage();
		loginObject.loginAccount(email, password);
	}
	
	@Test(priority = 2)
	public void downloadInvoice() throws InterruptedException {
		homeObject = new HomePage(driver); 
		myAccountObject = new MyAccountPage(driver);
		orderDetailsObject = new OrderDetailsPage(driver); 
		
		homeObject.openMyAccountPage();
		myAccountObject.openOrderDetialsPage(wait);
		orderDetailsObject.downloadInvoice();
		Helper.waitForNewFile();
		
		
	}
}
