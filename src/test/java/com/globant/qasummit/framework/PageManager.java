package com.globant.qasummit.framework;

import com.globant.qasummit.framework.config.GlobalConfigMgr;
import com.globant.qasummit.pages.BasePage;
import com.globant.qasummit.pages.IndexPage;
import org.openqa.selenium.WebDriver;

public class PageManager {

    private WebDriver driver;
    public PageManager( WebDriver driver ){
        this.driver = driver;
    }

    public BasePage getInitialPage(){
        IndexPage indexPage = new IndexPage(  driver );
        //initial.page.url
        String initialUrl = GlobalConfigMgr.getInstance().getProperty("initial.page.url");
        driver.get( initialUrl );
        return indexPage;
    }

    public void dispose(){
        driver.quit();
    }
}
