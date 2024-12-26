package com.wikipedia_search.Test;

import com.wikipedia_search.testData.DataProviders;
import com.wikipedia_search.webDriverSetup.BaseTestSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.wikipedia_search.listeners.TestListener.class)
public class WikipideaSearchTest extends BaseTestSetup {

    @Test(dataProvider = "CountryCapitalData", dataProviderClass = DataProviders.class)
    public void testSearchCapital(String country, String expectedCapital) {
        wikipediaSearchPage.searchForCountry(country);
        String actualCapital = wikipediaSearchPage.getCapitalOfCountry();
        Assert.assertTrue(actualCapital.contains(expectedCapital),
                "Capital city verification failed for " + country + ". Expected: " + expectedCapital + ", but found: " + actualCapital);
    }
}
