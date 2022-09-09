package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;	

	By searchArea = By.xpath("//input[@name='search']");
	By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
	By acctHeaders = By.xpath("//div[@id='content']//h2");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getAcctHomePageTitle() {
		 return elementUtil.waitForTitleIsToLoad(15, "My Account");
	}
	
	public int getAcctPageHeaders() {
		return elementUtil.getElements(acctHeaders).size();
	}
	
	public List<String> getAcctPageHeadersList() {
		List<WebElement> acctHeadersList = elementUtil.getElements(acctHeaders);
		List<String> headersList = new ArrayList<>();
		
		for(WebElement list : acctHeadersList) {
			headersList.add(list.getText());
		}
		
		return headersList;
	}
}
