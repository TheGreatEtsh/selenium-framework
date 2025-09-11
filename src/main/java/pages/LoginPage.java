package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "Email")
	WebElement emailTxtBx;

	@FindBy(id = "Password")
	WebElement passwordTxtBx;

	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;


	public void loginAccount(String email, String password) {
		sendText(emailTxtBx, email);
		sendText(passwordTxtBx, password);
		clickButton(loginBtn);
	}
	
	

}
