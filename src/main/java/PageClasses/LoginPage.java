package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//LOCATORS
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	
	@FindBy(id="input-email")
	WebElement email;
	
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger') and contains(text(),'No match for E-Mail')]")
	WebElement loginErrorMessage;
	
	//Actions
	
	public void clickMyAccount()
	{
		myAccount.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public void enterMail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSubmitButton()
	{
		submit.click();
	}
	
	/*public String getPageTitle() {
        return driver.getTitle();
    } */
	
	
	public String getLoginErrorMessage()
	{
		return loginErrorMessage.getText();
	}
	
	

}
