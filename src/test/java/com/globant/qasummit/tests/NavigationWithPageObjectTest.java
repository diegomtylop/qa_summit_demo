package com.globant.qasummit.tests;
import com.globant.qasummit.pages.IndexPage;
import com.globant.qasummit.pages.OurServicesPage;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class NavigationWithPageObjectTest extends BaseTest{

    @Test
    @Parameters({"expectedStudios"})//22 studios are expected
    public void testStudiosAreDisplayed(int expectedStudios){
        IndexPage indexPage = (IndexPage) getInitialPage();

        OurServicesPage ourServicesPage = indexPage.gotoOurServicesPage();

        List<String> studioNames = ourServicesPage.getStudioNames();

        assertEquals( studioNames.size(), expectedStudios, "Correct number of studios");
    }
}
