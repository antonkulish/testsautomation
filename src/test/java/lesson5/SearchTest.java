package lesson5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class SearchTest implements Locators{
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("http://automationpractice.com");
    }

    @AfterClass
    public static void tearsDown() {
        webDriver.quit();
        webDriver = null;
    }

    public void assertThat(ExpectedCondition<Boolean> condition){
        (new WebDriverWait(webDriver,5)).until(condition);
    }

    public void click(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public void sendKeys(WebDriver driver, By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }


    @Test
    public void checkSearchResults(){
        click(webDriver, SEARCH_INPUT);
        sendKeys(webDriver, SEARCH_INPUT, "Printed Summer Dress");
        click(webDriver, SEARCH_BTN);
        assertThat(textToBePresentInElement(webDriver.findElement(COUNT_OF_PRODUCTS), "3 results have been found"));
        assertThat(textToBePresentInElement(webDriver.findElement(FIRST_PRODUCT_NAME), "Printed Summer Dress"));
    }
}
