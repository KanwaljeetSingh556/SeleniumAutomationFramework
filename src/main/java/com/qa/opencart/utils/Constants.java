package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public final static String LOGIN_PAGE_TITLE="Account Login";
	public final static String ACCT_PAGE_TITLE="My Account";
	public final static int ACCT_HEADER_COUNT = 4;
	public final static String USER_REGISTRATION_DATA="userRegistrationData";
	
	public static List<String> expectedHeaderList(){
		List<String> expHeaderList = new ArrayList<String>();
		expHeaderList.add("My Account");
		expHeaderList.add("My Orders");
		expHeaderList.add("My Affiliate Account");
		expHeaderList.add("Newsletter");
		System.out.println(expHeaderList);
		return expHeaderList;
	}
}
