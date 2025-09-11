package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderMaleRdioBx;

	@FindBy(id = "FirstName")
	WebElement firstNametxtBx;

	@FindBy(id = "LastName")
	WebElement lastNametxtBx;

	@FindBy(id = "Email")
	WebElement emailTxtBx;

	@FindBy(id = "Password")
	WebElement passwordTxtBx;

	@FindBy(id = "ConfirmPassword")
	WebElement cnfrmdPsswrdTxtBx;

	@FindBy(id = "register-button")
	WebElement rgistrBtn;

	public void registerUser(String firstName, String lastName, String email, String password) {
		clickButton(genderMaleRdioBx);
		sendText(firstNametxtBx, firstName);
		sendText(lastNametxtBx, lastName);
		sendText(emailTxtBx, email);
		sendText(passwordTxtBx, password);
		sendText(cnfrmdPsswrdTxtBx, password);
		clickButton(rgistrBtn);
	}
}
