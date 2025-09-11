package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterResultPage extends PageBase{
	
	public RegisterResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.result")
	public WebElement resultMsg;
	
	@FindBy(linkText = "Log out")
	WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;
	
	public String registerationSuccessful = "Your registration complete";
	
	public void logoutAccount() {
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}
}
