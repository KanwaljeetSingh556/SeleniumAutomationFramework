package com.qa.opencart.utils;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;
	private Actions action;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		action = new Actions(this.driver);
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public void doSendKeys(By locator, String value) {
		System.out.println("Finding the element using locator : " + locator);
		System.out.println("Sending the value : " + value);
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public String doGetText(By locator) {
		System.out.println("The text of the element is :");
		return getElement(locator).getText();
	}

	public void doClick(By locator) {
		System.out.println("Element which has to be clicked : " + locator);
		getElement(locator).click();
	}

	public boolean doIsDisplayed(By locator) {
		System.out.println("Element to be displayed is : " + locator);
		return getElement(locator).isDisplayed();
	}

	public WebElement getLinkElement(String linkClass, String text) {

		String linkpath = "//a[@class='" + linkClass + "' and text()='" + text + "']";
		System.out.println(linkpath);

		return driver.findElement(By.xpath(linkpath));

	}
	
	public void doLinkClick(By locator, String linkText) {
		List<WebElement> langLinks = getElements(locator);
		System.out.println("total links : "+langLinks.size());
		for(WebElement langLink:langLinks) {
			String text = langLink.getText();		
			if(text.equals(linkText)) {
				System.out.println(text);
				langLink.click();
				break;
			}
		}
	}
	
	//select class
	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}

	
	public void doSelectWithoutSelectClass(By locator, String value) {
		List<WebElement> optionList = getElements(locator);
		for(WebElement option : optionList) {
			if(option.getText().equals(value)) {
				System.out.println("option selected is : "+option.getText());
				option.click();
				break;
			}
		}
	}
	
	//Actions class
	public void doMoveToElement(By locator) {
		System.out.println("Moving element using actions class");
		action.moveToElement(getElement(locator)).perform();
	}
	
	
	public void doActionClick(By locator) {
		System.out.println("Clicking element using the action class");
		action.click(getElement(locator)).perform();
	}
	
	public void doActionSendKeys(By locator, String keys) {
		System.out.println("Sending data to input field using action class");
		action.sendKeys(getElement(locator),keys).perform();
	}

	// WebDriverWait utility
	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public Alert waitForAlertPresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);	
		return  wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertTextUsingWDW(int timeout) {
		String alertText = waitForAlertPresent(timeout).getText();
		acceptAlert(timeout);
		return alertText;
	}

	public void acceptAlert(int timeout) {
		waitForAlertPresent(timeout).accept();
	}
	
	public void dismisAlert(int timeout) {
		waitForAlertPresent(timeout).dismiss();
	}
	
	
	public String waitForTitleContainsToLoad(int timeout, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public String waitForTitleIsToLoad(int timeout, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
}
