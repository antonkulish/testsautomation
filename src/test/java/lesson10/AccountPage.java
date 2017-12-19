package lesson10;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private static final Logger LOG = LogManager.getLogger(HomePage.class);
    static WebDriver webDriver;

    @FindBy(className = "logout")
    WebElement logOut;

    @FindBy(xpath = "//h1[contains(.,('My account'))]")
    WebElement accountPageTitle;

    AccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage signOut(){
        LOG.info("User logout");
        logOut.click();
        return new LoginPage(webDriver);
    }
}
