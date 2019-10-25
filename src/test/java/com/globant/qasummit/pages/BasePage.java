package com.globant.qasummit.pages;

import com.globant.qasummit.framework.helpers.DateHelper;
import com.globant.qasummit.framework.config.GlobalConfigMgr;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver pDriver ){
        this.driver = pDriver;
        PageFactory.initElements( pDriver, this );
    }

    //Facade: hides implementation details to ease the use for the clients

    /**
     * Awaits until a given element is clickable before clicking it
     * @param element
     */
    public void safeClick(WebElement element ){
        //Creates an explicit wait
        getWait().until( ExpectedConditions.elementToBeClickable( element ));

        //Click the element
        element.click();
    }

    public Wait getWait(){
        int defaultTimeout = Integer.valueOf( GlobalConfigMgr.getInstance().getProperty("default.wait.timeout") );
        Wait wait = new FluentWait( driver )
                .withTimeout( Duration.ofSeconds( defaultTimeout ))
                .pollingEvery( Duration.ofMillis(500))
                .ignoring(Exception.class);
        return wait;
    }

    public Wait getWait(int timeoutInSecs, int pollingInMillis){
        Wait wait = new FluentWait( driver )
                .withTimeout( Duration.ofSeconds( timeoutInSecs ))
                .pollingEvery( Duration.ofMillis( pollingInMillis ))
                .ignoring(Exception.class);
        return wait;
    }

    public boolean isElementDisplayed( WebElement element ){
        try{
            return element.isDisplayed();
        }catch( NoSuchElementException ex){
            return false;
        }
    }

    public void scroll( String direction ){
        if( "down".equalsIgnoreCase( direction ) ) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
        }else{
            //TODO: TO IMPLEMENT
            throw new RuntimeException("Not implemented yet");
        }
    }

    /**
     * Take a screenshot of the current page
     * @param suiteName
     * @param testName
     * TODO: THIS METHOD IS COUPLED WITH THE TESTS SINCE THE SUITENAME AND TESTNAME IS REQUIRED, AN IMPROVEMENT COULD BE TO MAKE IT MORE GENERIC
     */
    public void takeScreenshot(String suiteName, String testName ) {
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        File srcFile= scrShot.getScreenshotAs(OutputType.FILE);

        String basePath =  GlobalConfigMgr.getInstance().getProperty("screenshots.directory");
        String imgPrefix =  GlobalConfigMgr.getInstance().getProperty("screenshots.file.prefix");

        String suitePath = suiteName;
        String currentDateS = DateHelper.getCurrentDateFormatted();
        String filename = testName;

        //Chain of invocation
        StringBuilder screenshotPath = new StringBuilder()
                .append( basePath )
                .append("/")
                .append(suitePath)
                .append( "/")
                .append(filename)
                .append( "/")
                .append(imgPrefix)
                .append(currentDateS)
                .append(".jpg");

        File targetFile = new File(screenshotPath.toString() );
        targetFile.getParentFile().mkdirs();
        //Copy file at destination
        try {
            FileUtils.copyFile(srcFile, targetFile);
        }catch( Exception e ){
            e.printStackTrace();
        }
    }
}
