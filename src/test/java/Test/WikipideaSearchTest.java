package Test;

import com.wikipedia.webDriverSetup.BaseTestWithoutLT;
import com.wikipedia.webDriverSetup.LambdaTestSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.DataProviders;
import java.net.MalformedURLException;

     public class WikipideaSearchTest extends LambdaTestSetup {

    public WikipideaSearchTest() throws MalformedURLException {}
         // to run code without LambdaTest tool, please uncomment below line
    //public class WikipideaSearchTest extends BaseTestWithoutLT {
    @Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
    public void testSearchCapital(String country, String expectedCapital){
        wikipediaSearchPage.searchForCountry(country);
        String actualCapital = wikipediaSearchPage.getCapitalOfCountry();
        Assert.assertTrue(actualCapital.contains(expectedCapital),
                "Capital city verification failed for " + country + ". Expected: " + expectedCapital + " but found: " + actualCapital);
    }
}
