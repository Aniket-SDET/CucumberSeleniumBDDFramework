package stepdefinitions;

import org.junit.Assert;

import com.pages.WelcomePageFreeCrm;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelcomePageSteps {

	private String title;
	private WelcomePageFreeCrm welcomePage = new WelcomePageFreeCrm(DriverFactory.getDriver());

	@Given("user is on welcome page")
	public void user_is_on_welcome_page() {

		String welcomepagetext = welcomePage.getWelcomePageText();
		System.out.println("welcome page text is "+welcomepagetext);
		Assert.assertTrue(welcomepagetext.contains("Free CRM Software"));

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		
		title = welcomePage.getPageTitle();
		System.out.println("welcome page title is "+title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String WelcomePageTitle) {	
		Assert.assertTrue(title.contains(WelcomePageTitle));
	}

	@Then("Login button should be present")
	public void Login_button_should_be_present() {	
		Assert.assertTrue(welcomePage.isLoginButtonEnabledOnWelcomePage());
	}


}
