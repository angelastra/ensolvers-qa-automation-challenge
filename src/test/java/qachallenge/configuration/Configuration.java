package qachallenge.configuration;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Configuration {
    @BeforeSuite
    public void beforeSuite() {
        // Set up test configuration (e.g., logger, reports)
    }

    @AfterSuite
    public void afterSuite() {
        // Tear down test configuration (e.g., close reports)
    }
}

