package com.globant.qasummit.tests;

import com.globant.qasummit.pages.BasePage;
import com.globant.qasummit.framework.BrowserType;
import com.globant.qasummit.framework.DriverFactory;
import com.globant.qasummit.framework.PageManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Example of "template method" pattern
 */
public class BaseTest {

    private PageManager pageManager;

    @BeforeMethod
    public void setUp(){
        //Initializes the driver
        WebDriver driver =
                new DriverFactory().getDriver( BrowserType.CHROME );

        pageManager = new PageManager( driver );
    }

    @AfterMethod
    public void tearDown(){
        pageManager.dispose();
    }

    public BasePage getInitialPage(){
        return pageManager.getInitialPage();
    }
}
