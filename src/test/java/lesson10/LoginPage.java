package lesson10;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private static final Logger LOG = LogManager.getLogger(HomePage.class);
    static WebDriver webDriver;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement passwd;

    @FindBy(id = "SubmitLogin")
    WebElement submit;

    @FindBy(xpath = "//h1[contains(.,('Authentication'))]")
    WebElement loginPageTitle;

    LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterUsername(String username){
        LOG.info("Enter username");
        email.clear();
        email.sendKeys(username);
    }

    public void enterPassword(String password){
        LOG.info("Enter password");
        passwd.clear();
        passwd.sendKeys(password);
    }

    public void clickSignInBtn(){
        submit.click();
    }

    public AccountPage logIn(String username, String password){
        LOG.info("User login");
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(webDriver);
    }

}
