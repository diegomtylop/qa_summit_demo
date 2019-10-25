package com.globant.qasummit.data;

import com.globant.qasummit.vo.StudioVO;
import org.testng.annotations.DataProvider;

public class StudiosDataProvider {

    @DataProvider(name = "studios-data")
    public static Object[][] dataProviderMethod()
    {
        StudioVO qe = new StudioVO("Quality Engineering","quality-engineering",5);
        StudioVO bh = new StudioVO("Business Hacking","business-hacking",3);
        StudioVO ai = new StudioVO("Artificial Intelligence","artificial-intelligence",3);

        return new Object[][] {
                {qe},
                {bh},
                {ai}
        };
    }
}
