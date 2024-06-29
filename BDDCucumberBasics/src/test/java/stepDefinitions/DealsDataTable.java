package stepDefinitions;



import java.time.Duration;

import java.util.List;

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
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DealsDataTable {

	public static WebDriver driver;
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//String userDir = System.getProperty("user.dir");
	
	
	//Before and After once declared in any step definition, Cucumber will run it for any of the feature file
//	@Before
//	public void setup() {
//
//		System.out.println("Before annotation is executed");
//		
//		ChromeOptions options = new ChromeOptions();
//		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://freecrm.com/");
//	}
//
//	@After
//	public void tearDown() {
//		
//		System.out.println("after annotation is executed");
//		driver.quit();
//	}


	@Given("User is on login FreeCRM page")
	public void user_is_on_login_free_crm_page() {

		String title =  driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);


	}
	@When("user enters proper credentials")
	public void user_enters_proper_credentials(DataTable credentials) {

		List<List<String>> loginData = credentials.asLists();
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(loginData.get(0).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginData.get(0).get(1));


	}
	@And("clicks on login button")
	public void clicks_on_login_button() {

		driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button']")).click();

	}
	@Then("user is logged in successfully to home page")
	public void user_is_logged_in_successfully_to_home_page() {

		String title =  driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);

	}
	@And("user mouse hovers on icon tab and clicks on add button to create new deal")
	public void user_mouse_hovers_on_icon_tab_and_clicks_on_add_button_to_create_new_deal() throws InterruptedException {

		//myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ui']//div//div[@id='main-nav']//div[1]")));

		Thread.sleep(5000);
		WebElement dealsIcon = driver.findElement(By.xpath("//div[@id='ui']//div//div[@id='main-nav']//div[1]"));

		Actions action = new Actions(driver);
		action.moveToElement(dealsIcon).build().perform();

		driver.findElement(By.xpath("//div[@id='main-nav']//div[5]//a//following-sibling::button[@class='ui mini basic icon button']")).click();

		action.moveByOffset(-15, 0).build().perform();

	}

	@Then("Create new deal page opens")
	public void create_new_deal_page_opens() {

		String titlElement =driver.findElement(By.xpath("//span[@class='selectable ']")).getText();
		Assert.assertEquals("Create new Deal", titlElement);

	}
	@And("user enters deal details")
	public void user_enters_deal_details(DataTable data) {

		List<List<String>> dealsData = data.asLists();

		myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='title']")));
		//Deal title
		driver.findElement(By.xpath("//input[@name='title']")).click();
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(dealsData.get(0).get(0));
		//Product
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(dealsData.get(0).get(1));
		//Amount
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(dealsData.get(0).get(2));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		driver.findElement(By.xpath("//div[@name='type' and @role='listbox']//i")).click();
		driver.findElement(By.xpath("//div[@name='type' and @role='listbox']//div[@class='visible menu transition']//div//span[contains(text(),'"+dealsData.get(0).get(3)+"')]")).click();

	}

	@Then("saves the deal")
	public void saves_the_deal() throws InterruptedException {


		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
		myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='selectable ']//i[@class='large money red icon']")));

		String dealActualTitle = driver.findElement(By.xpath("//div[@class='ui label' and contains(text(),'Title')]//following-sibling::div[@class='edit-in-place-holder' or @class='edit-in-place']//div//p")).getText();
		Assert.assertEquals("Aniket Deal", dealActualTitle);
	}

}
