package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	 
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	
	 @FindBy(xpath="//input[@id='input-email']")
	 WebElement txtemailaddress;
	 
	 @FindBy(xpath="//input[@id='input-password']") 
	 WebElement txtpassword;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 WebElement loginbtn;
	 
	 @FindBy(xpath="//h2[text()='My Account']")
	 WebElement msgHeading;
	 
	 public void setEmail(String email)
	 {
		 txtemailaddress.sendKeys(email);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 txtpassword.sendKeys(pwd);
	 }
	 
	 public void clickLogin()
	 {
		 loginbtn.click();
	 }
	 
	 public boolean isMyAccountPageExists()
	 {
		 try
		 {
			 return(msgHeading.isDisplayed());
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
}
