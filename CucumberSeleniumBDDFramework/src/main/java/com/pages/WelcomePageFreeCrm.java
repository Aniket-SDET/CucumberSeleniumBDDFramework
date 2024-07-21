package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePageFreeCrm {

	private WebDriver driver;
	
	//Locators
	@FindBy (xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']") 
	private WebElement loginButtonHomePage;

	@FindBy (xpath = "//h1[@class='txt-white']")
	private WebElement welcomePageText;

	//Constructor
	public WelcomePageFreeCrm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Page Actions : featurs of the page in the form of methods
	public String getWelcomePageText() {
		return welcomePageText.getText();
	}


	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isLoginButtonEnabledOnWelcomePage() {
		return loginButtonHomePage.isEnabled();
	}

	public LoginPageFreeCrm clickLoginButtonWelcomePage() {
		loginButtonHomePage.click();
		return new LoginPageFreeCrm(driver);
	}


}
