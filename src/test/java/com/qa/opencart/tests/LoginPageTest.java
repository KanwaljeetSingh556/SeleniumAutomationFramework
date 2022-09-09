package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is : " + title);
		Assert.assertEquals(title, "Account Login");
	}

	@Test(priority = 2)
	public void forgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordDisplayed());
	}

	@Test(priority = 3)
	public void doLoginTest() {
		loginPage.doLogin();
	}
}
