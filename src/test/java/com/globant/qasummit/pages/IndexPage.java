package com.globant.qasummit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends  BasePage{

    @FindBy(css = ".header .logo")
    private WebElement logoLnk;

    //By applying POM it is also possible to subtract the menu items to a different page.
    @FindBy(linkText = "Our Services")
    private WebElement menuOurServices;

    @FindBy(linkText = "Contact Us")
    private WebElement menuContactUs;

    public IndexPage(WebDriver pDriver) {
        super(pDriver);
    }

    public OurServicesPage gotoOurServicesPage() {
        //Facade pattern
        safeClick( menuOurServices );
        return new OurServicesPage( driver );
    }

    public ContactUsPage gotoContactUsPage() {
        safeClick( menuContactUs );
        return new ContactUsPage( driver );
    }
}
