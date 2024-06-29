package stepDefinitions;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefinition {

	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
	   
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");
	   
	}
	@When("title of login page is Free CRM Power Up your Entire Business Free Forever")
	public void title_of_login_page_is_free_crm_power_up_your_entire_business_free_forever() {
		
		String title =  driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);
		//driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
	    
	}
	@Then("user enters {string} and {string}")
	public void user_enters_username_and_password(String username,String password) {
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    
	}
	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button']")).click();
	    
	}
	
	@Then("user is on home page")
	public void user_is_on_home_page() {
		
		String title =  driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);	
		//driver.close();
		
	}
	
	@Then("^user logs out$")
	public void user_logs_out() {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']")));
		
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		driver.findElement(By.xpath("//div[@role='listbox']//div//a[9]")).click();
		
		String homePage = driver.getTitle();
		Assert.assertEquals("Cogmento CRM", homePage);
		
	}
	
	@Then("^user close browser$")
	public void user_close_browser() {
		driver.quit();
	}

	
}
