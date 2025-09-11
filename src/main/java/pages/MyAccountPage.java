package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		//wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(partialLinkText = "Orders")
	WebElement ordersLink;
	
	@FindBy(css = "button.button-2.order-details-button")
	WebElement orderDetailsBtn;
	
	public void changePassword() {
		clickButton(changePasswordLink);
	}
	
	/*
	 * TODO improve by adding order number as a parameter and search for it to access its details
	 */
	public void openOrderDetialsPage(WebDriverWait wait) {
		clickButton(ordersLink);
		wait.until(ExpectedConditions.elementToBeClickable(orderDetailsBtn));
		clickButton(orderDetailsBtn);
	}
}
