package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import PageClasses.LoginPage;

public class LoginTest extends baseClass{
	
	
	@Test(priority=2)
	public void verifyLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickMyAccount();
		lp.clickLogin();
		lp.enterMail("qaraj123@gmail.com");
		lp.enterPassword("12345678");
		lp.clickSubmitButton();
		
		String actualTitle = driver.getTitle();
		String expectedTitle ="My Account";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test(priority=1)
	public void verifyInvalidLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickMyAccount();
		lp.clickLogin();
		lp.enterMail("qaraj123@gmail.com");
		lp.enterPassword("123456789");
		lp.clickSubmitButton();
		
		String errorMessage = lp.getLoginErrorMessage();
		
		 Assert.assertTrue(
			        errorMessage.contains("No match for E-Mail"),
			        "Incorrect error message displayed for invalid login"
			    );
		
	}

}
