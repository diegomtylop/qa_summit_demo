package com.globant.qasummit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends  BasePage{

    @FindBy(css = ".phone a")
    private WebElement phone;

    @FindBy(css=".email a")
    private WebElement email;

    @FindBy(css="a.webform-dialog-wide")
    private WebElement btnOpenContactForm;

    //Contact form
    @FindBy(css="input[name=\"first_name\"]")
    private WebElement inputFirstName;

    @FindBy(css="input[name=\"email\"]")
    private WebElement inputEmail;


    @FindBy(css=".g-recaptcha")
    private WebElement captchaElement;

    @FindBy(css="button[id ^= \"edit-actions-submit\"]")
    private WebElement bntSubmitContactForm;

    @FindBy(css="button[title=\"Close\"]")
    private WebElement btnCloseContactForm;

    ContactUsPage(WebDriver pDriver) {
        super(pDriver);
        getWait().until( ExpectedConditions.visibilityOf( btnOpenContactForm));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getContactPhone(){
        getWait().until(ExpectedConditions.visibilityOf( phone ));
        return phone.getText();
    }

    public String getContactEmail(){
        getWait().until(ExpectedConditions.visibilityOf( email ));
        return email.getText();
    }

    public void openContactForm(){
        safeClick( btnOpenContactForm );
        getWait().until( ExpectedConditions.elementToBeClickable( captchaElement ));
    }

    public void closeContactForm(){
        safeClick( btnCloseContactForm );
    }

    public boolean isContactFormComplete(){
        return isElementDisplayed( inputFirstName ) &&
                isElementDisplayed( inputEmail ) &&
                isElementDisplayed( captchaElement ) &&
                isElementDisplayed(  bntSubmitContactForm );

    }

    public boolean isBtnFormVisible(){
        return isElementDisplayed(btnOpenContactForm);
    }
}

