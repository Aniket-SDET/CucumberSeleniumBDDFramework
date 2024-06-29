package stepDefinitions;


import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealsDataTableMaps {

	WebDriver driver;

	@Given("User is on FreeCRM login page")
	public void user_is_on_free_crm_login_page() {

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");

	}

	@When("user enters correct credentials")
	public void user_enters_correct_credentials(DataTable credentials) {

		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

		for(Map<String, String> loginData : credentials.asMaps()) {

			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(loginData.get("Username"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginData.get("Password"));

		}

	}

	@And("clicks on login btn")
	public void clicks_on_login_btn() {

		driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button']")).click();

	}

	@Then("user is logged in successfully")
	public void user_is_logged_in_successfully() {

		String title =  driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);

	}

	@And("mouse hovers on menu tab and clicks on add button to create new deal")
	public void mouse_hovers_on_menu_tab_and_clicks_on_add_button_to_create_new_deal() throws InterruptedException {

		Thread.sleep(5000);

		WebElement dealsIcon = driver.findElement(By.xpath("//div[@id='ui']//div//div[@id='main-nav']//div[1]"));

		Actions action = new Actions(driver);
		action.moveToElement(dealsIcon).build().perform();

		driver.findElement(By.xpath("//div[@id='main-nav']//div[5]//a//following-sibling::button[@class='ui mini basic icon button']")).click();


	}

	@Then("Create new deal webpage opens")
	public void create_new_deal_webpage_opens() {

		String titlElement =driver.findElement(By.xpath("//span[@class='selectable ']")).getText();
		Assert.assertEquals("Create new Deal", titlElement);

	}

	@And("user enters required deal details")
	public void user_enters_required_deal_details(DataTable data) throws InterruptedException {

		for(Map<String,String> dealsData : data.asMaps()) {

			WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(30));
			myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='title']")));

			driver.findElement(By.xpath("//input[@name='title']")).click();
			driver.findElement(By.xpath("//input[@name='title']")).sendKeys(dealsData.get("Deal_Title"));
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(dealsData.get("Description"));
			driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(dealsData.get("Amount"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			driver.findElement(By.xpath("//div[@name='type' and @role='listbox']//i")).click();
			driver.findElement(By.xpath("//div[@name='type' and @role='listbox']//div[@class='visible menu transition']//div//span[contains(text(),'"+dealsData.get("Type")+"')]")).click();

			//Save Deal steps
			driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();

			//Assert steps to verify deal is created with expected deal title
			myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='selectable ']//i[@class='large money red icon']")));

			String dealActualTitle = driver.findElement(By.xpath("//div[@class='ui label' and contains(text(),'Title')]//following-sibling::div[@class='edit-in-place-holder' or @class='edit-in-place']//div//p")).getText();
			Assert.assertEquals(dealsData.get("Deal_Title"), dealActualTitle);

			//Hovers on deal icon to create a new deal again
			myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ui']//div//div[@id='main-nav']//div[1]")));
			WebElement dealsIcon = driver.findElement(By.xpath("//div[@id='ui']//div//div[@id='main-nav']//div[1]"));

			Actions action = new Actions(driver);
			action.moveToElement(dealsIcon).build().perform();

			WebElement dealPlusSign = driver.findElement(By.xpath("//div[@id='main-nav']//div[5]//a//following-sibling::button[@class='ui mini basic icon button']"));
			myWait.until(ExpectedConditions.elementToBeClickable(dealPlusSign));
			dealPlusSign.click();

		}


	}

	@Then("user closes the browser")
	public void user_closes_the_browser() {

		driver.findElement(By.xpath("//button[@class='ui button']")).click();

		driver.close();
		driver.quit();

	}


}
