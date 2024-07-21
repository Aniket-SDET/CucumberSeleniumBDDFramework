package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFreeCrm {
	
	
	private WebDriver driver;
	
	@FindBy (linkText = "Forgot your password?")
	private WebElement forgotPassword;
	@FindBy (xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy (xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy (xpath = "//div[@class = 'ui fluid large blue submit button']")
	private WebElement LoginButtonLoginPage;
	
	
	public LoginPageFreeCrm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordPresent() {
		return forgotPassword.isDisplayed();
	}
	
	public void enterUsername(String username) {
		email.sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLoginButtonLoginPage() {
		LoginButtonLoginPage.click();
	}
	
	public Object doLogin(String username,String pwd) {
		email.sendKeys(username);
		password.sendKeys(pwd);
		LoginButtonLoginPage.click();
		return new HomePageFreeCrm(driver);

	}
	
	

}
