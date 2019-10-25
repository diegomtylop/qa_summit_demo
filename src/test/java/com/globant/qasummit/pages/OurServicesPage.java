package com.globant.qasummit.pages;

import com.globant.qasummit.framework.config.GlobalConfigMgr;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OurServicesPage extends  BasePage{

    @FindBy(css = ".studio-group-slide-desktop span.studio-name")
    List<WebElement> studioElements;

    private static final String STUDIOS_PATH = "/studio/";

    OurServicesPage(WebDriver pDriver) {
        super(pDriver);
    }

    public List<String> getStudioNames() {
        List<String> textOfElements =
                studioElements
                .stream()
                .map( WebElement::getText )
                .collect(Collectors.toList() );

        return textOfElements;
    }

    public StudioDetailPage navigateToStudioByName(String studioName) {
        //Scroll to make the studios section visible
        scroll("down");

        String baseUrl = GlobalConfigMgr.getInstance().getProperty("initial.page.url");
        baseUrl += STUDIOS_PATH + studioName;
        driver.get( baseUrl );
        return new StudioDetailPage( driver );
    }
}

