package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	
     public AccountPage(WebDriver driver)
     {
    	 super(driver);
    	 
     }

	@FindBy(xpath= "//input[@id='input-firstname']")
	WebElement  txtFirstName;
	
	@FindBy(xpath= "//input[@id='input-lastname']")
	WebElement  txtLastName;
	
	@FindBy(xpath= "//input[@id='input-email']")
	WebElement  txtEmail;
	
	@FindBy(xpath= "//input[@id='input-telephone']")
	WebElement  txtPhone;
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement  txtPassword;
	
	@FindBy(xpath= "//input[@id='input-confirm']")
	WebElement  txtConfirmPassword;
	
	@FindBy(xpath= "//label[normalize-space()='Yes']")
	WebElement  checkBoxYes;
	
	@FindBy(xpath= "//input[@name='agree']")
	WebElement  checkBoxAgree;
	
	@FindBy(xpath= "//input[@value='Continue']")
	WebElement  clickContinue;
	
	@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement  getConfirmation;

	
	public void txtFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void txtLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void txtEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void txtPhone(String phone)
	{
		txtPhone.sendKeys(phone);
	}
	
	public void txtPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void txtConfirmPassword(String pass)
	{
		txtConfirmPassword.sendKeys(pass);
	}
	
	public void checkBoxYes()
	{
		checkBoxYes.click();
	}
	
	public void checkBoxAgree()
	{
		checkBoxAgree.click();
	}
	
	public void clickContinue()
	
	{
		clickContinue.click();
	}
	
	public String getConfirmation()
	{
		try 
		{
		return(getConfirmation.getText());
		}
		catch(Exception e) 
		{
			return(e.getMessage());
		}
	}
	
	
}
