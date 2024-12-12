package Test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.DataProviders;

public class SausLabTest extends BaseTest {

    @Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
    public void testSearchCapital(String country, String expectedCapital) {
        homePage.searchForCountry(country);
        String actualCapital = homePage.getCapitalOfCountry();
        Assert.assertTrue(actualCapital.contains(expectedCapital),
                "Capital city verification failed for " + country + ". Expected: " + expectedCapital + " but found: " + actualCapital);
    }
}
