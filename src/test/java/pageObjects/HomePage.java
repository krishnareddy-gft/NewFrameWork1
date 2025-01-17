package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage

{
	
    public HomePage( WebDriver driver) 
    
    {
	
	super(driver);
	
    }
    
    
    @FindBy(xpath= "//a[@title='My Account']")
    WebElement linkMyAccount;
    
    @FindBy(xpath= " //a[normalize-space()='Register']")
    WebElement linkRegister;
    
    @FindBy(xpath="(//a[normalize-space()='Login'])[1]")
    WebElement linkLogin;
    
    public void linkMyAccount( ) 
    {
    	linkMyAccount.click();
    }
    
    public void linkRegister()
    {
    	linkRegister.click();
    }
    
    public void linkLogin() 
    {
    	linkLogin.click();
    }
    
    
}
