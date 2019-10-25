package com.globant.qasummit.tests;

import com.globant.qasummit.pages.IndexPage;
import com.globant.qasummit.pages.OurServicesPage;
import com.globant.qasummit.pages.StudioDetailPage;
import com.globant.qasummit.vo.StudioVO;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * DataProvider example
 * VO example
 */
public class StudiosInformationTest extends BaseTest{

    @Test(dataProvider = "studios-data", dataProviderClass = com.globant.qasummit.data.StudiosDataProvider.class)
    public void testStudiosAreDisplayed(StudioVO studio, ITestContext context){

        //Get expected information from Value Object
        String studioPath = studio.getPath();
        String studioName = studio.getName();
        int numberOfPractices = studio.getNumberOfPractices();

        IndexPage indexPage = (IndexPage) getInitialPage();

        //Navigate to "Our services" page
        OurServicesPage ourServicesPage = indexPage.gotoOurServicesPage();

        //Navigate to the studio's page
        StudioDetailPage detailPage = ourServicesPage.navigateToStudioByName( studioPath );

        //Assertions
        assertEquals( detailPage.getStudioTitle(), studioName,"Studio name displayed");

        assertEquals( detailPage.getNumberOfPractices(),  numberOfPractices, "Number of practices OK");

        //Take screenshot
        detailPage.takeScreenshot( context.getCurrentXmlTest().getSuite().getName(), context.getCurrentXmlTest().getName() );
    }
}
