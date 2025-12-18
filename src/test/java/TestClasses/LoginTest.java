package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageClasses.LoginPage;

public class LoginTest extends BaseClass{
	
	
	@Test(priority=2)
	public void verifyLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.clickMyAccount();
		lp.clickLogin();
		lp.enterMail("qaraj123@gmail.com");
		lp.enterPassword("12345678");
		lp.clickSubmitButton();
		
		String Title = driver.getTitle();
		
		String title = driver.getTitle();
		Assert.assertTrue(
		    title.equals("My Account") || title.equals("Account Login")
		);

		
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
