package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	
	//This method is used to initialize the thread local driver on the basis of given driver
	public WebDriver init_browser(String browser) {

		System.out.println("browser value is : "+browser);

		if(browser.equals("chrome")) {

			tldriver.set(new ChromeDriver());

		}
		if(browser.equals("firefox")) {

			tldriver.set(new FirefoxDriver());

		}
		if(browser.equals("safari")) {

			tldriver.set(new SafariDriver());

		}

		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	//This is used to get the driver with thread local
	public static synchronized WebDriver getDriver() {
		
		return tldriver.get();
	}



}
