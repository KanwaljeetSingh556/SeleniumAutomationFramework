package com.qa.opencart.tests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ErrorHandler;

public class AccountPageTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(AccountPageTest.class);
	
	@BeforeClass
	public void acctSetUp() {
		acctPage = loginPage.doLogin();
	}
	
	@Test(priority = 1)
	public void acctHomePageTitleTest() {
		String acctPageTitle = acctPage.getAcctHomePageTitle();
		Assert.assertEquals(acctPageTitle, Constants.ACCT_PAGE_TITLE);
		
		logger.info("Testing");
		logger.error("testing error logs");
	}

	@Test(priority = 2)
	public void acctPageHeaderCountTest() {
		int totalHeaders = acctPage.getAcctPageHeaders();
		Assert.assertEquals(totalHeaders, Constants.ACCT_HEADER_COUNT,ErrorHandler.ACCT_PAGE_HEADER_COUNT_MSG);
		
	}
	
	@Test(priority = 3)
	public void acctPageHeaderListTest() {
		List<String> actualHeaderList = acctPage.getAcctPageHeadersList();
		System.out.println(actualHeaderList);
		Assert.assertEquals(actualHeaderList, Constants.expectedHeaderList());
	}
}
