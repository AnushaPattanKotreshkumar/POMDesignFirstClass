package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// By Locators -- OR
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isSignUpLinkExist() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	public void doLogin(String username, String pwd) {
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}

}