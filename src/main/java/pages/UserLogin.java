package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogin extends PageBase {

	public UserLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "username")
	WebElement usernameText;
	
	@FindBy(id = "password")
	WebElement passwordText;
	
	@FindBy(className = "radius")
	WebElement loginButton;
	
	@FindBy(id = "flash")
	WebElement invalidMessage;


	public void Enter_Credentials(String username, String Password)
	{
		setTextElementText(usernameText, username);
		setTextElementText(passwordText, Password);
		clickButton(loginButton);
	}
	
	public String RetrieveInvalidMessage()
	{
		return invalidMessage.getText();
	}
	
}
