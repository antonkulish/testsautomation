package lesson7;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CustomConditionsTests{
    protected static WebDriver webDriver;

    public By PRODUCT_NAME = By.xpath("//div[@class='block_content']//a[@class='product-name']");
    public By RANDOM_ELEM_FROM_HOME_PAGE = By.id("homepage-slider");
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
        HomePage homePage = new HomePage(webDriver);
        SearchResultsPage searchResultsPage = homePage.enterSearchCriteria(textForSearch);
        assertThat(searchResultsPage.listNthElementHasText(2, PRODUCT_NAME, "Blouse"));
    }

    @Test
    public void checkTitleAndUrlContainsText(){
        HomePage homePage = new HomePage(webDriver);
        SearchResultsPage searchResultsPage = homePage.enterSearchCriteria(textForSearch);
        assertThat(searchResultsPage.pageIsLoaded("Search - My Store", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dresses&submit_search="));
    }

    @Test
    public void checkElemIsNotDisplay(){
        HomePage homePage = new HomePage(webDriver);
        SearchResultsPage searchResultsPage = homePage.enterSearchCriteria(textForSearch);
        assertThat(searchResultsPage.stalenessOfElement(RANDOM_ELEM_FROM_HOME_PAGE));
    }
}
