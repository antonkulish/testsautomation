package lesson8;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BasePage {
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.CLIENT, Level.SEVERE);
        logs.enable(LogType.DRIVER, Level.WARNING);
        logs.enable(LogType.PERFORMANCE, Level.INFO);
        logs.enable(LogType.SERVER, Level.ALL);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);

        webDriver = new ChromeDriver(desiredCapabilities);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://automationpractice.com");
    }

    @AfterClass
    public static void tearsDown() {
        webDriver.quit();
        webDriver = null;
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
