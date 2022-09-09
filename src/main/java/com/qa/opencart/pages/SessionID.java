package com.qa.opencart.pages;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SessionID
{

    DriverFactory dr;
    WebDriver driver;


    public SessionID()
    {
        WebDriverManager.chromedriver().setup();
         ChromeDriver driver  = new ChromeDriver();
      //  driver = dr.init_driver("chrome");
        driver.get("https://www.amazon.com");


    }
   @Test
    public void getSessionID()
    {
        SessionId session = ((ChromeDriver)driver).getSessionId();
        System.out.println("Session id: " + session.toString());

    }


}
