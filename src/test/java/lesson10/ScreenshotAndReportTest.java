package lesson10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@RunWith(JUnit4.class)
public class ScreenshotAndReportTest extends BaseTest{

    protected String username = "kulan888@gmail.com";
    protected String password = "Fynjirf888";

    @Test
    public void checkAccountPageIsOpenedAfterLogIn1(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        AccountPage accountPage = loginPage.logIn(username, password);
        assertThat(textToBePresentInElement(accountPage.accountPageTitle, "MY ACCOUNT"));
    }


    @Test
    public void checkAccountPageIsOpenedAfterLogIn2(){
        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSignInBtn();
        AccountPage accountPage = new AccountPage(webDriver);
        assertThat(textToBePresentInElement(accountPage.accountPageTitle, "MY ACCOUNT 2"));
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
