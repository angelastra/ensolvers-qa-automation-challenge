package qachallenge.testComponents;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import qachallenge.pages.HomePage;
import qachallenge.utils.DriverUtils;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl;
    protected HomePage homePage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        // Initialize driver, set up configurations
		driver = DriverUtils.getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        // Quit driver, perform any cleanup
        driver.quit();
    }

    @BeforeMethod
    public void tearUp()
    {
        homePage = new HomePage(driver);
        homePage.logIn();
    }

    public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png"));
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
}
