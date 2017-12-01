package lesson5;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest implements Locators {
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
    public void test01CheckLogin(){
        click(webDriver, SIGN_IN_BTN);
        click(webDriver, EMAIL_INPUT);
        sendKeys(webDriver, EMAIL_INPUT, "kulan888@gmail.com");
        click(webDriver, PASS_INPUT);
        sendKeys(webDriver, PASS_INPUT, "Fynjirf888");
        click(webDriver, SUBMIT_LOGIN_BTN);
        assertThat(textToBePresentInElement(webDriver.findElement(ACCOUNT_NAME), "Anton Kulish"));
    }

    @Test
    public void test02CheckOrderHistoryPageIsOpened(){
        click(webDriver, ORDER_HISTORY_BTN);
        Assert.assertTrue(webDriver.findElement(ORDER_HISTORY_TITLE).isDisplayed());
    }

    @Test
    public void test03CheckCreditSlipsPageIsOpened(){
        click(webDriver, ACCOUNT_NAME);
        click(webDriver, CREDIT_SLIPS_BTN);
        Assert.assertTrue(webDriver.findElement(CREDIT_SLIPS_TITLE).isDisplayed());
    }

    @Test
    public void test04CheckMyAddressesPageIsOpened(){
        click(webDriver, ACCOUNT_NAME);
        click(webDriver, MY_ADDRESSES_BTN);
        Assert.assertTrue(webDriver.findElement(MY_ADDRESSES_TITLE).isDisplayed());
    }

    @Test
    public void test05CheckMyPersInfoPageIsOpened(){
        click(webDriver, ACCOUNT_NAME);
        click(webDriver, MY_PERSONAL_INFO_BTN);
        Assert.assertTrue(webDriver.findElement(MY_PERSONAL_INFO_TITLE).isDisplayed());
    }

    @Test
    public void test06CheckMyWishlistPageIsOpened(){
        click(webDriver, ACCOUNT_NAME);
        click(webDriver, MY_WISHLIST_BTN);
        Assert.assertTrue(webDriver.findElement(MY_WISHLIST_TITLE).isDisplayed());
    }
}
