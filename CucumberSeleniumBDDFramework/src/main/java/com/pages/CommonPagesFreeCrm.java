package com.pages;

import org.openqa.selenium.WebDriver;

public class CommonPagesFreeCrm {


	private static WebDriver driver;

	public CommonPagesFreeCrm (WebDriver driver) {

		this.driver = driver;

	}

	public static String getPageTitle() {

		return driver.getTitle();
	}
}
