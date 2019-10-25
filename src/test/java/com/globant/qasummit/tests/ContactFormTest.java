package com.globant.qasummit.tests;

import com.globant.qasummit.pages.ContactUsPage;
import com.globant.qasummit.pages.IndexPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ContactFormTest extends BaseTest{

    @Test
    @Parameters({"expectedTitle"})//Contact Us
    public void testNavigation(String expectedTitle){
        IndexPage indexPage = (IndexPage) getInitialPage();

        ContactUsPage contactPage = indexPage.gotoContactUsPage();

        boolean landedOnContactPage = contactPage.getTitle().contains( expectedTitle );

        assertTrue( landedOnContactPage, "User landed on contact page");
    }

    @Test
    @Parameters({"expectedPhone","expectedEmail"})
    public void testContactInfo( String expectedPhone, String expectedEmail){
        IndexPage indexPage = (IndexPage) getInitialPage();

        ContactUsPage contactPage = indexPage.gotoContactUsPage();

        String phoneDisplayed= contactPage.getContactPhone().replace(" ","");
        String emailDisplayed = contactPage.getContactEmail();

        assertEquals( phoneDisplayed, expectedPhone, "Phone displayed");
        assertEquals( emailDisplayed, expectedEmail, "Phone displayed");
    }

    @Test
    public void testContactForm( ){
        IndexPage indexPage = (IndexPage) getInitialPage();

        ContactUsPage contactPage = indexPage.gotoContactUsPage();

        boolean btnOpenFormDisplayed = contactPage.isBtnFormVisible();
        assertTrue( btnOpenFormDisplayed, "Button for opening the contact form is visible");

        contactPage.openContactForm();

        boolean formComplete = contactPage.isContactFormComplete();
        assertTrue( formComplete, "Contact form complete");

        contactPage.closeContactForm();

        btnOpenFormDisplayed = contactPage.isBtnFormVisible();

        assertTrue( btnOpenFormDisplayed, "Button for opening is visible again");
    }
}
