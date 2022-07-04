package testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	
	@Test(groups= {"regression","master"})
	public void test_account_registration() throws IOException
	{
		logger.debug("debug logging.......");
		logger.info("Starting TC_001_AccountRegistration");
		try
		{
		logger.info("Launching Application");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		logger.info("Clicking on MyInfo --> Registration Link");
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickRegister();
		
		
		logger.info("Providing customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("Ramu");
		logger.info("Provided customer firstname");
		
		regpage.setLasttName("Test");
		logger.info("provided customer last name");
		
		regpage.setEmail(randomstring()+"@gmail.com");
		logger.info("provided customer email");
		
		regpage.setTelephone("9876543219");
		logger.info("provided customer telephone");
		
		regpage.setPassword("abcd");
		logger.info("provided customer password");
		
		regpage.setConfirmPassword("abcd");
		logger.info("provided confirm password");
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("clicked 'continue' button");
	
       String confmsg=regpage.getConfirmationMsg();
		
       logger.info("Validation started.......");
       
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Registration test passed...");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"test_account_registration");			
			logger.error("Registration test failed");
			Assert.assertTrue(false);
		}
     	}
		catch(Exception e)
		{
			//captureScreen(driver,"test_account_registration");	
			logger.fatal("Registation test failed");
			Assert.fail(); 
		}
		
		
	}
	
}
