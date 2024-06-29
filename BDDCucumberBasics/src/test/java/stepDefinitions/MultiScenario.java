package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiScenario {

	
	@Before("@Smoke")
	public void beforeMethod() {
		System.out.println("This is before hook");
	}

	@AfterStep("@Smoke")
	public void afterStepMethod() {
		System.out.println("This is after Step method hook");
	}
	
	@Given("User is on login page of FreeCRM") 
	public void User_is_on_login_page_of_FreeCRM() {

	}

	@Then("User inputs correct credentials") 
	public void User_inputs_correct_credentials() {

	}

	@And("User is loggedin successfully to homepage of FreeCRM") 
	public void User_is_loggedin_successfully_to_homepage_of_FreeCRM() {

	}

	@When("user mouse hovers on menu tab and clicks on new task button")
	public void user_mouse_hovers_on_menu_tab_and_clicks_on_new_task_button() {

	}
	@Then("user enters tasks details")
	public void user_enters_tasks_details() {

	}
	@And("saves the new task")
	public void saves_the_new_task() {

	}



	@When("user mouse hovers on menu tab and clicks on new contact button")
	public void user_mouse_hovers_on_menu_tab_and_clicks_on_new_contact_button() {

	}
	@Then("user enters contacts details")
	public void user_enters_contacts_details() {

	}
	@And("saves the new contact")
	public void saves_the_new_contact() {

	}



	@When("user mouse hovers on menu tab and clicks on new deal button")
	public void user_mouse_hovers_on_menu_tab_and_clicks_on_new_deal_button() {

	}
	@Then("user enters all deal details")
	public void user_enters_all_deal_details() {

	}
	@And("saves the new deal")
	public void saves_the_new_deal() {

	}

}
