package testData;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Login")
    public static Object[][] dpMethod() {
        return new Object[][]{
                {"India", "New Delhi"},
                {"England", "London"},
                {"France", "Paris"}
        };
    }

}
