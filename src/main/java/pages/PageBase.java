package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected static WebDriver driver;
	Actions action ;
	//WebDriverWait wait;
	
	
	public PageBase(WebDriver driver) {
		PageBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button) {
		button.click();
	}
	
	protected static void sendText(WebElement textBox, String text) {
		textBox.clear();
		textBox.sendKeys(text);
	}
	
	protected static void scrollToElement(WebElement element) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	protected static void selectDropDownByTxt(WebElement element, String text) {
		Select select;
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
}
