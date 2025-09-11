package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxtBx;
	
	@FindBy(id = "YourEmailAddress")
	WebElement yourEmailTxtBx;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTxtBx;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	WebElement resultMsg;
	
	public void emailFriend(String firendEmail, String personalMsg) {
		sendText(friendEmailTxtBx, firendEmail);
		sendText(personalMessageTxtBx, personalMsg);
		clickButton(sendEmailBtn);
	}
	
	public boolean isResultMessageDisplayed() {
		return resultMsg.isDisplayed();
	}
}
