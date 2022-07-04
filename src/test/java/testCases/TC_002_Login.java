package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
  @Test(groups= {"sanity","master"})
  public void test_login() 
  {
	  logger.info("starting Tescase_002_Login");
	  
	  try
	  {
		  driver.get(rb.getString("appURL"));
		  logger.info("Home page displayed");
		  
		  driver.manage().window().maximize();
		  
		  HomePage hp=new HomePage(driver);
		  hp.clickMyaccount();
		  logger.info("Clicked on MyAccount");
		  hp.clickLogin();
		  logger.info("Clicked on Login");
		  
		  LoginPage lp=new LoginPage(driver);
		  
		  lp.setEmail(rb.getString("email"));
		  logger.info("Email id provided");
		  
		  lp.setPassword(rb.getString("password"));
		  logger.info("Password provided");
		  
		  lp.clickLogin();
		  logger.info("Login button clicked");
		  
		  boolean targetpage=lp.isMyAccountPageExists();
		  
		  if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver, "test_Login"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		  
	  }
	  catch(Exception e)
	  {
		  logger.fatal("Login Failed ");
		  Assert.fail();
	  }
	  
	  logger.info(" Finished TC_002_Login ");
  }
	
}
