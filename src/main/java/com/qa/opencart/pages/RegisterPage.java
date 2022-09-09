package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPass = By.id("input-confirm");
	private By privacyPolicy = By.xpath("//input[@name='agree']");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	
	private By succesMsg = By.xpath("//div[@id='content']/h1");
	private By logoutBtn = By.xpath("//div[@class='list-group']/a[text()='Logout']");
	private By registerLink = By.linkText("Register");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public boolean userRegistration(String firstname, String lastname, String email, String telephone,String password) {
		
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(confirmPass, password);
		
		elementUtil.doClick(privacyPolicy);
		elementUtil.doClick(continueBtn);
		
		elementUtil.waitForElementPresent(this.succesMsg, 10);
		String msg = elementUtil.doGetText(this.succesMsg);
		
		if(msg.contains("Your Account Has Been Created!")) {
			System.out.println(msg);
			
			elementUtil.doClick(logoutBtn);
			elementUtil.doClick(registerLink);
			return true;
		}
		else {
			return false;
		}
	}
	
}
