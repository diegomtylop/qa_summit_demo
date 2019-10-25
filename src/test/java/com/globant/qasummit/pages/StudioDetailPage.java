package com.globant.qasummit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class StudioDetailPage extends  BasePage{

    @FindBy(css = ".studio-header .title")
    WebElement studioTitle;

    @FindBy(css = ".studio-hero-sub-info")
    WebElement studioSubInfo;

    @FindBy(css = ".practices-block-card")
    List<WebElement> practices;


    StudioDetailPage(WebDriver pDriver) {
        super(pDriver);
        getWait().until(ExpectedConditions.visibilityOf( studioTitle));
    }

    public String getStudioTitle(){
        return studioTitle.getText();
    }

    public int getNumberOfPractices(){
        return practices.size();
    }
}

