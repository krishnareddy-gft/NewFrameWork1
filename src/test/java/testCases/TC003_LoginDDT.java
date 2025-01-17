package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass


{
	
	@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class)
	public void LoginDDT( String email, String pswd, String exp) 
	{
	
		
		logger.info("Clicked acount Icon");
		HomePage hp=new HomePage(driver);
		
		hp.linkMyAccount();
		hp.linkLogin();
		
		logger.info("entered emial and Password Icon");
		
		
		
		LoginPage lp=new LoginPage(driver);
		lp.txtEmail(email);
		lp.txtPassword(pswd);
		lp.btnLoginl();
		
		
		DashboardPage dp=new DashboardPage(driver);
		
		boolean targetPage=dp.isMyAccountPageExists();
		
		
		if(exp.equalsIgnoreCase("valid"))
		
		{
			if(targetPage==true) 
			{
				dp.clickLogout();
				Assert.assertTrue(true);
				
					
			}
			else 
			{
				Assert.fail();;
			}
			
		}
		 
		if(exp.equalsIgnoreCase("Invalid")) 
	     {
	  	
	       if(targetPage==false) 
	       {
	    	   Assert.assertTrue(true);
	       }
	       else 
	       {
	    	   Assert.fail();
	       }
	
	       	
	     }
	
		
		}
	}
