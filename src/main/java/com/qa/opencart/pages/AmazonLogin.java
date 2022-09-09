package com.qa.opencart.pages;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.ElementUtil;
import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

public class AmazonLogin
{
    WebDriver driver;
    ElementUtil util;
    public AmazonLogin(WebDriver driver)
    {
      //  DriverFactory fac = new DriverFactory();
       // driver =  fac.init_driver("chrome");
        this.driver = driver;

        util  = new ElementUtil(driver);

    }

    @BeforeTest
    public  void loginAmazon()
    {

        driver.get("https://www.amazon.in/");
    }

    @Test
    public  void signIn()
    {
       By Loc = By.xpath("//a[.='Sign in']");
        util.doMoveToElement(By.cssSelector("span#nav-link-accountList-nav-line-1"));
        util.waitForElementPresent(Loc,3 );
        util.doClick(Loc);

    }
    @AfterTest
    public void Login()
    {
        util.doSendKeys(By.xpath("//input[@type='email']"),"kawaljeetsingjj@gmail.com");
        util.doClick(By.cssSelector("input#continue"));
        util.doSendKeys(By.cssSelector("input#ap_password"),"Chopalsagar");
        util.doClick(By.cssSelector("input#signInSubmit"));

    }

}
