package com.wikipedia_search.testData;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "CountryCapitalData")
    public static Object[][] dpMethod() {
        return new Object[][]{
                {"India", "New Delhi"},
                {"England", "London"},
                {"France", "Paris"}
        };
    }
}
