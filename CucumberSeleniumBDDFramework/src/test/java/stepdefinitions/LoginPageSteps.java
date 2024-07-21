package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPageFreeCrm;
import com.pages.WelcomePageFreeCrm;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private WelcomePageFreeCrm welcomePage = new WelcomePageFreeCrm(DriverFactory.getDriver());
	private LoginPageFreeCrm loginPage;

	@Given("user clicks on login button on welcome page")
	public void user_clicks_on_login_button_on_welcome_page() {	
		
		loginPage = welcomePage.clickLoginButtonWelcomePage();
	}
	
	@Given("user is on Login page")
	public void user_is_on_Login_page() {
		
		String titleString = loginPage.getPageTitle();
		System.out.println("Title of the pags is "+titleString);
		
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		
		Assert.assertTrue(loginPage.isForgotPasswordPresent());
	}

	@Then("user enters username {string}")
	public void user_enters_username(String username) {
		
		loginPage.enterUsername(username);
		
	}
	@Then("user enters password {string}")
	public void user_enters_password(String password) {
		
		loginPage.enterPassword(password);
		
	}

	@Then("user clicks on login button on login page")
	public void user_clicks_on_login_button_on_login_page() {
		
		loginPage.clickLoginButtonLoginPage();
		
	}
	



}
