package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_LoginTest extends BaseClass
{
   @Test(groups="Regression")
	public void LoginTest()
	{
		
		try {
	
	logger.info("Clicked acount Icon");
		HomePage hp=new HomePage(driver);
		
		hp.linkMyAccount();
		hp.linkLogin();
		
		logger.info("entered emial and Password Icon");
		
		
		
		LoginPage lp=new LoginPage(driver);
		lp.txtEmail(p.getProperty("email"));
		lp.txtPassword(p.getProperty("password"));
		lp.btnLoginl();
		
		
		DashboardPage dp=new DashboardPage(driver);
		
		boolean targetpPage=dp.isMyAccountPageExists();
		 
		Assert.assertEquals(targetpPage, true, "Login failed");
		logger.info("Test Passed");
		}
		catch(Exception e) {
			
			Assert.fail();
			logger.info("Test failed");
			
		}
		
		
		
			
			
				
		
	}
	
}
