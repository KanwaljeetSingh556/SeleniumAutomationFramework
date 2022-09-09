package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	
	
	@BeforeClass
	public void registerSetUp() {
		registerPage = loginPage.navigatingToRegisterPage();
	}
	
	/*
	 * @Test public void userRegitrationTest() {
	 * Assert.assertTrue(registerPage.userRegistration("Madhu", "LastName",
	 * "madhu03435@gmail.com", "4554365425", "test@2345")); }
	 */

	@DataProvider
	public Object[][] getRegisterData(){
		Object data[][] = ExcelUtil.getTestData(Constants.USER_REGISTRATION_DATA);
		return data;
	}
	
	@Test(dataProvider="getRegisterData")
	public void userRegisterData(String firstname, String lastname, String email, String telephone,
			String password) {
		Assert.assertTrue(registerPage.userRegistration(firstname, lastname, email, telephone, password));
	}
	
	
}
