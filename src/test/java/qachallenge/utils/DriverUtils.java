package qachallenge.utils;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {
    private static WebDriver driver;

    public static WebDriver getDriver() throws IOException {
        // Implement logic to initialize WebDriver based on configuration
        Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/qachallenge/resources/globalData.properties");
		prop.load(fis);
		String terminalBrowser = System.getProperty("browser");
		String browser = prop.getProperty("browser");
		String definitiveBrowser = "";
		definitiveBrowser  = terminalBrowser != null ? terminalBrowser : browser;
		if(definitiveBrowser.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(definitiveBrowser.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(definitiveBrowser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(definitiveBrowser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

