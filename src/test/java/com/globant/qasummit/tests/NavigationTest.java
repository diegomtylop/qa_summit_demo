package com.globant.qasummit.tests;

import com.globant.qasummit.framework.BrowserType;
import com.globant.qasummit.framework.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * How test would look like with no framework
 * PLEASE DON'T DO THINGS THIS WAY!
 */
public class NavigationTest {

    @Test
    public void testRawNavigation(){
        System.out.println("Test initialized");
        System.out.println("Running test ng test");
        DriverFactory factory = new DriverFactory();
        WebDriver driver = factory.getDriver( BrowserType.CHROME );

        driver.get("http://globant.com");

        driver.findElement(By.linkText("Our Services")).click();

        //Perhaps it requires a wait at this point
        List<WebElement> studios = driver.findElements( By.cssSelector(".studio-group-slide-desktop span.studio-name"));
        List<String> studioNames = new ArrayList<>();

        for( WebElement studio : studios ){
            studioNames.add( studio.getText() );
        }

        Assert.assertEquals( studioNames.size(), 22, "All the studios were displayed");

        driver.quit();
    }
}
