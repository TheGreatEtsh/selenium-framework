package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase{

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxtBx;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTxtBx;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTxtBx;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changePasswordBtn;
	
	@FindBy(css = "#bar-notification > div > p")
	public WebElement changePasswordResult;
	
	@FindBy(css = "#bar-notification > div > span")
	WebElement changePasswordXBtn;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "bar-notification")
	public WebElement barNotification;
	
	public String changePasswordSuccessfulTxt = "Password was changed";
	
	public void changePassword(String oldPassowrd, String newPassword) {
		sendText(oldPasswordTxtBx, oldPassowrd);
		sendText(newPasswordTxtBx, newPassword);
		sendText(confirmNewPasswordTxtBx, newPassword);
		clickButton(changePasswordBtn);
	}
	
	public void logout() {
		clickButton(logoutLink);
	}
	
	public void closeMsg() {
		// TODO Auto-generated method stub
		clickButton(changePasswordXBtn);
	}
}
