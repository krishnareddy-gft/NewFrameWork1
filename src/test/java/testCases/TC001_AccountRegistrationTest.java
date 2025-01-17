package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;

import org.testng.AssertJUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_AccountRegistrationTest  extends BaseClass
{
	
	
	
	@Test(groups={"Sanity"," Regression"})
	public void accountRegitrationTest() 
	{
		try 
		{
		logger.info("this test case started");
		
		HomePage hp= new HomePage(driver);
		hp.linkMyAccount();
		hp.linkRegister();
		
		AccountPage ap= new AccountPage(driver);
		logger.info("Customer deatails being entered");
		ap.txtFirstName("krishna");
		ap.txtLastName("Reddy");
		ap.txtEmail(randomeString() + "@gmail.com");
		
		String pswd=randomAlphaNum();
		
		ap.txtPassword(pswd);
		ap.txtConfirmPassword(pswd);
		ap.txtPhone("0420324891");
		ap.checkBoxYes();
		ap.checkBoxAgree();
		ap.clickContinue();
		
		logger.info("Validation expected text");
		
		
		String TextCOnfirm =ap.getConfirmation();
		
		if(TextCOnfirm.equals("Your Account Has Been Created!"))
				{
			AssertJUnit.assertTrue(true);
		        }
		else
		{
			logger.info("Test Failed");
			logger.debug("Debug Logs");
			AssertJUnit.assertFalse(true);
		}
		//Assert.assertEquals(TextCOnfirm, "Your Account Has Been Created!");
		
	}
		
	catch(Exception e)
		{
		
		AssertJUnit.fail();
	    }
		
		logger.info("Test Finished");
	
	}
	
	   
	
	   
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatednum=RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	 
	public String randomAlphaNum() 
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatednum=RandomStringUtils.randomNumeric(2);
		return (generatedString+"@"+ generatednum);
	}
	
	    
		
	
	

}
