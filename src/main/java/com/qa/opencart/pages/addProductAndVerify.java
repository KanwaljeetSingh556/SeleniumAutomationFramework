package com.qa.opencart.pages;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.ElementUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class addProductAndVerify
{
    WebDriver driver;
    DriverFactory dr;
    ElementUtil e;
    AmazonLogin a;


    public addProductAndVerify()
    {
        dr = new DriverFactory();
        driver = dr.init_driver("chrome");
//     SessionId session = ((RemoteWebDriver) dr.init_driver("chrome")).getSessionId();
//     System.out.println("Session id of Contract is " +session);
        e = new ElementUtil(driver);
        a = new AmazonLogin(driver);
    }

    @Test(priority = 1)
    public void EnterProductAndClick()
    {
        a.loginAmazon();
        a.signIn();
        a.Login();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        e.doSendKeys(By.cssSelector("input#twotabsearchtextbox"), "mobile");
        e.doClick(By.cssSelector("input#nav-search-submit-button"));
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

      e.doMoveToElement(By.partialLinkText(dr.init_prop().getProperty("product1")));
      e.doClick(By.partialLinkText(dr.init_prop().getProperty("product1")));
    }

    @Test(priority = 2)
    public void addToCartProduct() {

        Set<String> s = driver.getWindowHandles();
        Iterator<String> I = s.iterator();
        while (I.hasNext()) {
            String child_window = I.next();
            driver.switchTo().window(child_window);
        }
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        e.doMoveToElement(By.cssSelector("input#add-to-cart-button"));
        e.doActionClick(By.cssSelector("input#add-to-cart-button"));
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        e.doClick(By.xpath("//form//span[@id='attach-sidesheet-view-cart-button']"));

    }

    @Test(priority = 3)
    public void verifyProduct() {

//        String ExpectedText1 = dr.init_prop().getProperty("ExpectedText1");
//        String ele = driver.findElement(By.xpath("//ul//li//span[@class='a-truncate-cut']")).getText();
//        Assert.assertEquals(ele, ExpectedText1);
        driver.navigate().back();
        e.doSendKeys(By.cssSelector("input#twotabsearchtextbox"), "Sunglasses");
        e.doClick(By.cssSelector("input#nav-search-submit-button"));
        e.doMoveToElement(By.partialLinkText(dr.init_prop().getProperty("product2")));
        e.doClick(By.partialLinkText(dr.init_prop().getProperty("product2")));

        Set<String> s = driver.getWindowHandles();
        Iterator<String> I = s.iterator();
        while (I.hasNext()) {
            String child_window = I.next();
            driver.switchTo().window(child_window);
        }
        e.doActionClick(By.cssSelector("input#add-to-cart-button"));

        e.doClick(By.cssSelector("span#sw-gtc"));


    }

    @Test(priority = 4)
    public void getElementAndVerify()
    {
        List<WebElement> eles = driver.findElements(By.className("a-truncate-cut"));
       // Iterator e = eles.iterator();
        String ExpectedText1 = dr.init_prop().getProperty("ExpectedText1");
        String ExpectedText2 = dr.init_prop().getProperty("ExpectedText2");

            Assert.assertEquals(ExpectedText1,eles.get(0).getText());
            Assert.assertEquals(ExpectedText2,eles.get(1).getText());

            driver.quit();

    }

}
