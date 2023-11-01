package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{   //declaration
	@FindBy(id="user-name")
	private WebElement user;
	
	@FindBy(id="password")
	private WebElement pass;
	
	@FindBy(id="login-button")
	private WebElement button;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getUsername()
	{
		return user;
	}
	
	public WebElement getPassword()
	{
		return pass;
	}
	
	public WebElement getLoginButton()
	{
		return button;
	}
	
	//business libraries
	public void loginToApp(String username, String password)
	{
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
	}
}
