package lesson7;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CustomConditionsTests{
    protected static WebDriver webDriver;

    WebElement SEARCH_INPUT = webDriver.findElement(By.id("search_query_top"));
    WebElement SEARCH_BTN = webDriver.findElement(By.xpath("//button[@class='btn btn-default button-search']"));

    public By PRODUCT_NAME = By.xpath("//div[@class='block_content']//a[@class='product-name']");
    public String textForSearch = "dresses";

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
        (new WebDriverWait(webDriver,10)).until(condition);
    }

    @Test
    public void checkElementByNumHasText(){
        SEARCH_INPUT.clear();
        SEARCH_INPUT.sendKeys(textForSearch);
        SEARCH_BTN.click();
        CustomConditions customConditions = new CustomConditions(webDriver);
        assertThat(customConditions.listNthElementHasText(2, PRODUCT_NAME, "Blouse"));
    }

    @Test
    public void checkTitleAndUrlContainsText(){
        SEARCH_INPUT.clear();
        SEARCH_INPUT.sendKeys(textForSearch);
        SEARCH_BTN.click();
        CustomConditions customConditions = new CustomConditions(webDriver);
        assertThat(customConditions.pageIsLoaded("Search", "submit_search"));
    }

    @Test
    public void checkElemIsNotDisplay(){
        SEARCH_INPUT.clear();
        SEARCH_INPUT.sendKeys(textForSearch);
        SEARCH_BTN.click();
        CustomConditions customConditions = new CustomConditions(webDriver);
        assertThat(customConditions.stalenessOfElement(SEARCH_INPUT));
    }
}
