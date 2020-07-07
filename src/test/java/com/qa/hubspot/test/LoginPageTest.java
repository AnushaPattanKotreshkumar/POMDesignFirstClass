package com.qa.hubspot.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;

	// TestNG -- unit testing framework
	// PreConditions ---> Test Cases(steps) (Act vs Exp) -- Assertions ---> Tear
	// Down
	// @BeforeTest ---> @Test --Assertions --> @AfterTest
	// launchBrowser, url --- > title test --> close the browser

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		driver = basePage.init_driver("chrome");
		loginPage = new LoginPage(driver);
	}

	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertEquals(loginPage.isSignUpLinkExist(), true);
	}

	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals(title, "HubSpot Login");
	}

	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin("anushapattan7@gmail.com", "selenium@12345");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}