package lesson6;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class AuthenticationTests {

    protected static WebDriver webDriver;
    protected String username = "kulan888@gmail.com";
    protected String password = "Fynjirf888";

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

    @Ignore
    @Test
    public void checkAccountPageIsOpenedAfterLogIn1(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(username, password);
        assertThat(textToBePresentInElement(accountPage.accountPageTitle, "MY ACCOUNT"));
    }

    @Ignore
    @Test
    public void checkAccountPageIsOpenedAfterLogIn2(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInBtn();
        AccountPage accountPage = new AccountPage(webDriver);
        assertThat(textToBePresentInElement(accountPage.accountPageTitle, "MY ACCOUNT"));
    }

    @Test
    public void checkLoginPageIsOpenedAfterLogOut(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(username, password);
        loginPage = accountPage.signOut();
        assertThat(textToBePresentInElement(loginPage.loginPageTitle, "AUTHENTICATION"));
    }

}
