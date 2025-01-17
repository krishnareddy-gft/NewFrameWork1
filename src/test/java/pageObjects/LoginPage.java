package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage

{
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	
	
	public void txtEmail(String email)
	{
		
		txtEmail.sendKeys(email);
	}
	
	public void txtPassword(String pass)
	{
		
		txtPassword.sendKeys(pass);
	}
	
	public void btnLoginl()
	{
		
		btnLogin.click();
	}

}
