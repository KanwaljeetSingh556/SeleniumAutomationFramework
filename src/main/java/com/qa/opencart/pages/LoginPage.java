package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	//1. create all the locators and 2. perform the action (Creating various methods)
	
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginBtn = By.xpath("//input[@value='Login']");
	By forgotPassword = By.xpath("//div[@class='form-group']/a");
	By registerLink = By.xpath("//div[@class='list-group']/a[text()='Register']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		
	}
	
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIsToLoad(5, Constants.LOGIN_PAGE_TITLE);
	}
		
	public boolean isForgotPasswordDisplayed() {
		return elementUtil.doIsDisplayed(forgotPassword);
	} 
	
	public AccountPage doLogin() {
		elementUtil.doSendKeys(username, "madhu01@gmail.com");
		elementUtil.doSendKeys(password, "madhu@123");
		elementUtil.doClick(loginBtn);
		
		return new AccountPage(driver);
	}
	
	public RegisterPage navigatingToRegisterPage() {
		elementUtil.doClick(registerLink);
		
		return new RegisterPage(driver);
	}
}
