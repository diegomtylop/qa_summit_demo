package com.globant.qasummit.framework;

import com.globant.qasummit.framework.config.GlobalConfigMgr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver getDriver( BrowserType browserType ){
        if( browserType.equals( BrowserType.CHROME)){
            //Single point of reference & singleton
            String chromePath = GlobalConfigMgr.getInstance().getProperty("chrome.driver.path");
;           System.setProperty("webdriver.chrome.driver",chromePath);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }

        if( browserType.equals( BrowserType.FIREFOX)){
            WebDriver driver = new FirefoxDriver();
            return driver;
        }
        return null;
    }

}
