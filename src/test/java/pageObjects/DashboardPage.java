package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage


{
	public DashboardPage(WebDriver driver)
	{
		
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement actualText;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clickLogout;

	public boolean isMyAccountPageExists() {
	    try {
	        return actualText.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public void clickLogout() 
	{
		
	    clickLogout.click();
	}
	}
